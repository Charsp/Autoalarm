package com.swz.voice.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.swz.voice.manager.ConfigDatas;
import com.swz.voice.model.SHP_A3;
import com.swz.voice.service.AutoAlarmProc;
import com.swz.voice.service.TransactionStream;

public class SHT_PortTread extends Thread {
	private static Logger log = LoggerFactory.getLogger(SHT_PortTread.class);
	private static final SHP_A3 MYAPI = SHP_A3.INSTANCE;
	private int currPort;
	private String telePhone;
	// 共有变量
	public static boolean isThreadStop = false;

	// 初始化端口
	public SHT_PortTread(int portNum) {
		this.currPort = portNum;
	}

	public static void sleep(long i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void clearPortData() {
		// 之前数据没有处理完成
		if (AutoAlarmProc.portBusy.containsKey(currPort)) {
			// 断电
			if (MYAPI.SsmGetLineVoltage(currPort) < 30) {
				// 线路接触不良，强制清除电话数据
				log.info("线路接触不良,电话打到一半被终止");
				MYAPI.SsmHangup(currPort); // 挂机
				TransactionStream.sendUserPress(currPort, false);
			}
			// 超时
			else if (AutoAlarmProc.isOverdued(currPort)) {
				// 播放超时音乐
				MYAPI.SsmPlayFile(currPort,ConfigDatas.getConfirmSound(), 6, 0, 150000);
				while (MYAPI.SsmCheckPlay(currPort) == 0) {
					// 放音正在进行
					SHT_PortTread.sleep(1000);
				}
				log.info("用户操作超时，系统强制结束通话");
				// 端口是否有事件输出
				MYAPI.SsmHangup(currPort); // 挂机
				// 超过预定时间，强制清除电话数据
				TransactionStream.sendUserPress(currPort, false);
			}
		}
	}

	@Override
	public void run() {
		// 测试连接与否
		while (!isThreadStop) { 
			// 空闲时候
			clearPortData();
			if (MYAPI.SsmGetLineVoltage(currPort) < 30) {
				// 电源断电时候也是可以检测到大于30的数据
				sleep(1000);
				continue;
			} else {
				sleep(200);
			}

			while (MYAPI.SsmGetChState(currPort) != 0) // 检查通道是否空闲
			{
				// 通道忙，被占用,掉线等状态
				sleep(1000);
			}
			// 获取数据段程序(get网页数据)
			telePhone = TransactionStream.getAlarmData(currPort);
			if (telePhone == null) {
				// log.info("目前堆栈没有数据！");
				continue;
			}

			while (MYAPI.SsmPickup(currPort) != 0) {
				log.info("摘机失败，尝试重新连接...");
			}

			if (MYAPI.SsmAutoDial(currPort, telePhone) < 0) // 自动拨号
			{
				log.info("拨打电话失败" + MYAPI.SsmGetLastErrMsgA());
				sleep(1000);
			}
			MYAPI.SsmClearRxDtmfBuf(currPort); // 清空DTMF字符缓存区
			AutoAlarmProc.portBusy.put(currPort, System.currentTimeMillis());// 设置端口忙,当前时间戳
		}
		// 清理本端口数据(按键数据和忙数据)
		TransactionStream.sendUserPress(currPort, false);
		MYAPI.SsmHangup(currPort); // 挂机
	}
}
