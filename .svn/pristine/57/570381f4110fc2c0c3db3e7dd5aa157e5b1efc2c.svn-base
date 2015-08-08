package com.swz.data.service;

import com.swz.voice.model.MESSAGE_INFO;
import com.swz.voice.model.SHP_A3;
import com.swz.voice.model.SSM_EVENT;

/**
 * 创建一个电话监控设备
 * 
 * @author CharsBoll
 *
 */
public class CallingPhoneSrv extends Thread {
	private static SHP_A3 deviceHanlder = SHP_A3.INSTANCE;
	private boolean endThread;
	private MESSAGE_INFO Event = new MESSAGE_INFO();

	public void setEndThread(boolean endThread) {
		this.endThread = endThread;
	}

	public void initCallingHeader() {

	}

	/**
	 * 检查各种数据事件(未填加事务处理的基础事件消息)
	 */
	public void checkBaseEvents(MESSAGE_INFO Event) {
		//
		int portNum = Event.nReference;// 获取事件的端口号
		int eventKey = Event.wEvent;
		switch (eventKey) {
		case SHP_A3.E_CHG_ChState:
			break;
		default:
			break;
		}
		;
	}

	/**
	 * 检查各种数据事件(加事务处理的事件消息)
	 */
	public void checkTransactionEvents(SSM_EVENT ssmEvent) {
		//
		int portNum = ssmEvent.nReference;// 获取事件的端口号
		int eventKey = ssmEvent.wEventCode;
		switch (eventKey) {
		case SHP_A3.E_CHG_ChState:

			break;
		case SHP_A3.E_RCV_DSTDChannel:
			switch (ssmEvent.dwParam) {
			case 1:
				break;
			}
			break;

		default:
			break;
		}
		;
	}

	/**
	 * 创建语音流
	 */
	public void creatCallingStream() {
		// 等待事件出现(等待200毫秒，是否有事件触发，有则为0)
		if (deviceHanlder.SsmWaitForEvent(200, Event) == 0) {

			// 各种事件判断
		} else {
			// 暂时没有事件被触发
		}
	}

	@Override
	public void run() {
		while (!endThread) {
			System.out.println("线程没有结束！");
		}
	}

}
