package com.swz.data.dao;

import com.swz.data.vo.DialingState;
import com.swz.data.vo.PhoneStream;
import com.swz.voice.model.SHP_A3;

/**
 * 通话模拟类
 * 
 * @author CharsBoll
 *
 */
public class CallingStreamDao {
	/**
	 * 当前端口号
	 */
	private static SHP_A3 deviceHanlder = AlarmDeviceDao.deviceHanlder;
	private int portNum;
	private PhoneStream phoneStream;

	public PhoneStream getPhoneStream() {
		return phoneStream;
	}

	public void setPhoneStream(PhoneStream phoneStream) {
		this.phoneStream = phoneStream;
	}

	public int getPortNum() {
		return portNum;
	}

	public void setPortNum(int portNum) {
		this.portNum = portNum;
	}

	public DialingState getDialingState() {
		return dialingState;
	}

	public void setDialingState(DialingState dialingState) {
		this.dialingState = dialingState;
	}

	/**
	 * 拨号状态
	 */
	private DialingState dialingState = DialingState.CALLSTOP;

	/**
	 * 尝试拨号
	 * 
	 * @return
	 */
	public boolean tryDialing() {
		// 获取收信息
		if (phoneStream != null) {
			// 使用设备拨号
			int result = deviceHanlder.SsmAutoDial(portNum,
					phoneStream.getPhoneNum());
			if (result == 0) {
				return true;
			}
		} else {
			System.err.println("还没有手机信息呢！");
		}
		System.out.println("ER_R_____ER_R");
		return false;
	}
}
