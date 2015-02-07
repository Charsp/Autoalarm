package com.swz.voice.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.swz.voice.impl.BoardControlerImpl;
import com.swz.voice.manager.ConfigDatas;
import com.swz.voice.model.MESSAGE_INFO;
import com.swz.voice.model.SHP_A3;

/**
 * 自动接警
 * 
 * @author Charsp
 *
 * @date 2015年1月9日
 */
public class AutoAlarmProc extends Thread implements ServletContextListener {
	private static Logger log = LoggerFactory.getLogger(AutoAlarmProc.class);
	private static AutoAlarmProc alarmProc = null;
	private static Date openedTime;
	private static boolean openedDevice;
	/* 变量定义区域 */

	// 公有变量
	/**
	 * 车辆信息值 端口号 报警信息
	 */
	public static Map<Integer, JSONObject> vehicleId = new HashMap<Integer, JSONObject>();
	/**
	 * 端口忙标识
	 */
	public static Map<Integer, Long> portBusy = new HashMap<Integer, Long>();
	/**
	 * 客户回访的电话列表
	 */
	public static List<String> telephoneList = new ArrayList<String>();
	
	// 私有变量
	/**
	 * 驱动程序
	 */
	private static SHP_A3 MYAPI = SHP_A3.INSTANCE;
	/**
	 * 事件设置
	 */
	private static MESSAGE_INFO Event = new MESSAGE_INFO();
	/**
	 * 媒体播放路径
	 */
	// public static String mediaPath = ConfigDatas.getMediaPath();
	// private static int outTimeLimit = ConfigDatas.getTimeOut();
	/**
	 * 事件监听标识
	 */
	private static boolean canDone = false;
	private boolean isThreadStop = false;
	/**
	 * 每个线程的按键类型号码 次数 或者当前问卷
	 */
	private static List<Integer> keyCount = new ArrayList<Integer>();
	private static BoardControlerImpl boardControlerImpl = new BoardControlerImpl();

	/* 公有方法区域 */
	/**
	 * 存在车辆id这一项，已经在报警通话中了
	 * 
	 * @param car_object_id
	 *            车辆的car_object_id号码
	 * @return 没有拨打：false，通话中：true
	 */
	public static boolean hasVehicleId(String car_object_id) {
		boolean result = false;
		// Iterator<?> key = vehicleId.entrySet().iterator();
		// 查看当前车辆中有没有车辆id
		for (Integer key : vehicleId.keySet()) {
			try {
				if (vehicleId.get(key).getString("car_object_id")
						.equals(car_object_id))
					result = true;
				log.error(vehicleId.get(key).getString("car_no") + " 已经在拨打了！");
				break;
			} catch (Exception e) {
				log.error(vehicleId.get(key).getString("car_no")
						+ " 信息中缺乏car_object_id项");
			}
		}
		return result;
	}

	/**
	 * 打开板卡
	 * 
	 * @param first
	 *            是否为第一次程序运行
	 * @throws Exception
	 *             打开失败，抛出初始化失败异常
	 */
	public static int openBoard() {
		keyCount.clear();// 初始化按键次数
		canDone = false;
		for (int i = 0; i < MYAPI.SsmGetMaxCh(); i++)
			keyCount.add(0);
		return boardControlerImpl.initdBoard();
	}

	/**
	 * 清除过期历史数据(板卡内的缓存数据处理)
	 * 
	 * @param currPort
	 *            当前端口
	 * @return 超时为True,正常为False
	 */
	public static boolean isOverdued(int currPort) {
		int seconds = (int) ((System.currentTimeMillis() - portBusy
				.get(currPort)) / 1000);
		if (seconds > ConfigDatas.getTimeOut()) {
			log.error("拨打电话超时");
			return true;
		}
		return false;
	}

	/**
	 * 电话事务进行中
	 * 
	 * @return 如果结束了所有通话，则返回false,否则返回true
	 */
	public static boolean telTransacting() {
		return !vehicleId.isEmpty();
	}

	public static String getPortInfo(int currPort, String context) {
		if (vehicleId.get(currPort) != null) {
			try {
				return vehicleId.get(currPort).getString(context);
			} catch (Exception e) {
				log.info("");
			}
		}
		return "(vehicleId已经失效)";
	}

	@Override
	public void run() {
		log.info("mediaPath：" + ConfigDatas.getMediaPath());
		try {
			int EventCh = 0;
			// 初始化代码（第一次运行）
			while (!this.isThreadStop) {
				// 测试进入程序段数据
				while (!canDone) {
					if (MYAPI.SsmWaitForEvent(200, Event) == 0) {
						EventCh = Event.nReference;// 获取事件的端口号

						// 自动接警系统
						if (vehicleId.get(EventCh).containsKey("AutoAlarm")) {

							// 要有端口的事件类型，语音接警和语音回访
							if (Event.wEventCode == SHP_A3.E_CHG_ToneAnalyze) {
								int ToneType = MYAPI
										.SsmGetToneAnalyzeResult(EventCh);
								// 检测到拨号音
								if (ToneType == 1) {
									//
									log.info(getPortInfo(EventCh, "car_no")
											+ " 端口" + EventCh + "正在拨号！");
								}
								// 检测到回铃音
								if (ToneType == 3) {
									log.info("等待客户  "
											+ getPortInfo(EventCh, "car_no")
											+ " 摘机！");
								}
								if (ToneType == 4 || ToneType == 5
										|| ToneType == 6) {
									// 播放初始化的音频程序
									MYAPI.SsmPlayFile(EventCh,
											ConfigDatas.getAlarmSound(), 6, 0,
											150000);
									// log.info("通话成功！" + new Date());
								}
								// 检测到忙音
								if (ToneType == 2) {
									log.error("被  "
											+ getPortInfo(EventCh, "car_no")
											+ "  强制关掉了/或者根本就没接电话！");
									// 自动接警失败，程序返回给人工台
									TransactionStream.sendUserPress(EventCh,
											false);
									MYAPI.SsmHangup(EventCh); // 挂机
									canDone = true;
								}
								if (ToneType == 0) {
									log.info(getPortInfo(EventCh, "car_no")
											+ "  通话正常结束！");
								}
							}
							// E_CHG_RcvDTMF 信号！！
							if (Event.wEventCode == SHP_A3.E_CHG_RcvDTMF) {
								String pszDtmf = MYAPI.SsmGetDtmfStrA(EventCh);
								switch (pszDtmf) {
								case "2":
									if (keyCount.get(EventCh) == 0) {// 程序挂机
										log.info("端口"
												+ EventCh
												+ "消息："
												+ getPortInfo(EventCh, "car_no")
												+ "  客户直接按键为2，转人工台！");
										MYAPI.SsmPlayFile(EventCh,
												ConfigDatas.getMediaPath()
														+ "/SWZ_dtmf1.wav", -1,
												0, 1000000);
										// 自动接警失败，程序返回给人工台
										TransactionStream.sendUserPress(
												EventCh, false);
										MYAPI.SsmHangup(EventCh);
									} else if (keyCount.get(EventCh) == 1) {
										log.info("端口"
												+ EventCh
												+ "消息："
												+ getPortInfo(EventCh, "car_no")
												+ "  客户按键为2，返回上一级");
										keyCount.set(EventCh, 0);
									}
									// 重新填充 语音数据
									canDone = true;
									break;
								case "1":
									if (keyCount.get(EventCh) == 0) {
										log.info("端口"
												+ EventCh
												+ "消息："
												+ getPortInfo(EventCh, "car_no")
												+ "  客户第一次按键1");
										keyCount.set(EventCh, 1);
										MYAPI.SsmPlayFile(EventCh,
												ConfigDatas.getConfirmSound(),
												6, 0, 100000);
									} else if (keyCount.get(EventCh) == 1) {
										log.info("端口"
												+ EventCh
												+ "消息："
												+ getPortInfo(EventCh, "car_no")
												+ "  客户第二次按键1，已确认误报！");
										MYAPI.SsmPlayFile(EventCh,
												ConfigDatas.getMediaPath()
														+ "SWZ_dtmf2.wav", -1,
												0, 100000);
										keyCount.set(EventCh, 0);
										// 自动接警失败，程序返回给人工台
										TransactionStream.sendUserPress(
												EventCh, true);
										MYAPI.SsmHangup(EventCh);
										// 需要重播，确认
										canDone = true;
									}
									break;
								default:
									// 可以语音提示
									log.error("端口" + EventCh + "消息：" + "用户 "
											+ getPortInfo(EventCh, "car_no")
											+ " 按键" + pszDtmf + "不能识别！");
									break;
								}
								MYAPI.SsmClearRxDtmfBuf(EventCh); // 清除按键消息内容
							}//
						}
						// 自动语音回访系统
						else {
							// 当前问题的语音格式
							// 要有端口的事件类型，语音接警和语音回访
							if (Event.wEventCode == SHP_A3.E_CHG_ToneAnalyze) {
								int ToneType = MYAPI
										.SsmGetToneAnalyzeResult(EventCh);
								// 播放当前语音
								if (ToneType == 4 || ToneType == 5
										|| ToneType == 6) {
									// 播放初始化的音频程序
									MYAPI.SsmPlayFile(EventCh,
											ConfigDatas.getAlarmSound(), 6, 0,
											150000);
									// log.info("通话成功！" + new Date());
								}
								// 检测到忙音
								if (ToneType == 2) {
									log.error("被  "
											+ getPortInfo(EventCh, "car_no")
											+ "  强制关掉了/或者根本就没接电话！");
									// 自动接警失败，程序返回给人工台
									TransactionStream.sendUserPress(EventCh,
											false);
									MYAPI.SsmHangup(EventCh); // 挂机
									canDone = true;
								}
								if (ToneType == 0) {
									log.info(getPortInfo(EventCh, "car_no")
											+ "  通话正常结束！");
								}
							}// end wEventCode
								// E_CHG_RcvDTMF 信号 用户互交程序
							if (Event.wEventCode == SHP_A3.E_CHG_RcvDTMF) {
								String pszDtmf = MYAPI.SsmGetDtmfStrA(EventCh);
								// 判断语音格式，多项选择型 和 YesNo 型
								if (canDone) {
									switch (pszDtmf) {
									case "1":// YES
									case "2":// NO
									}
								} else {
									switch (pszDtmf) {
									case "1":// 第一项
									case "2":// 第二项
									case "3":// 第三项
									case "4":// 第四项
									case "5":// 第五项
									}
								}

								MYAPI.SsmClearRxDtmfBuf(EventCh); // 清除按键消息内容
							}
						}
					}// End if
				}// done // 半秒钟延时等待
				Thread.sleep(500);
				canDone = false;
			}
		} catch (Exception ex) {
			log.error(ex.getMessage());
		} finally {
			// 强制关闭板卡
			boardControlerImpl.stopBoard();
			log.info("##################板卡关闭###################");
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		closeAlarmProc();
	}

	public static int closeAlarmProc() {
		if (alarmProc != null && !alarmProc.isThreadStop) {
			canDone = true;
			alarmProc.isThreadStop = true;
			alarmProc = null;
			// 关闭成功
			setOpenedDevice(false);
			return 0;
		} else {
			// 设备还没有打开,关闭失败
			return 4003;
		}
	}

	public static boolean openedDevice() {
		if (alarmProc == null)
			return false;
		else {
			return true;
		}
	}

	public static Date getOpenedTime() {
		return openedTime;
	}

	public static void setOpenedTime(Date openedTime) {
		AutoAlarmProc.openedTime = openedTime;
	}

	public static boolean getOpenedDevice() {
		return openedDevice;
	}

	public static void setOpenedDevice(boolean openedDevice) {
		AutoAlarmProc.openedDevice = openedDevice;
	}

	public static int openAlarmProc() {
		// 设备存在
		setOpenedDevice(true);
		if (!openedDevice()) {
			int openid = openBoard();
			if (openid == 0) {
				alarmProc = new AutoAlarmProc();
				alarmProc.start();
				setOpenedTime(new Date());
				return 0;
			}
			// 加载驱动失败，请查看线路连接 设备不存在，请检查线路是否连接正常！
			else if (openid == -1) {
				setOpenedDevice(false);
				return 4001;
			}
			// 驱动重复加载
			else if (openid == -2) {
				return 4004;
			}
		}
		// 重复打开
		return 4004;
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		openAlarmProc();
	}
}
