package com.swz.data.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.swz.data.vo.AlarmDevice;
import com.swz.data.vo.PhoneStream;
import com.swz.voice.model.SHP_A3;

/**
 * 语音接警设备信息(由于设备只有一台，所以必须使用静态类)
 * 
 * @author CharsBoll
 *
 */
public class AlarmDeviceDao {
	/**
	 * 设备句柄(整个驱动程序)
	 */
	public static SHP_A3 deviceHanlder = SHP_A3.INSTANCE;
	/** 端口当前信息(端口叠加增大，不依赖设备，而依赖驱动) */
	private static Map<Integer, PhoneStream> phoneStreamMap = new HashMap<Integer, PhoneStream>();
	/** 车辆列表 */
	private static List<AlarmDevice> alarmDeviceList = new ArrayList<AlarmDevice>();;

	public static List<AlarmDevice> getAlarmDeviceList() {
		return alarmDeviceList;
	}

	/**
	 * 增加一台设备
	 * 
	 * @param alarmDevice
	 */
	public static void AddDevice(AlarmDevice alarmDevice) {
		if (alarmDeviceList == null) {
			alarmDeviceList = new ArrayList<AlarmDevice>();
		}
		alarmDeviceList.add(alarmDevice);
	}

	public static Map<Integer, PhoneStream> getPhoneStreamMap() {
		return phoneStreamMap;
	}

	/**
	 * 给一个端口增加一台手机
	 * 
	 * @param ch
	 * @param phoneStream
	 */
	public static void AddPortInfo(int ch, PhoneStream phoneStream) {
		phoneStreamMap = new HashMap<Integer, PhoneStream>();
		phoneStreamMap.put(ch, phoneStream);
	}

	/**
	 * 删除一个端口的信息
	 * 
	 * @param ch
	 */
	public void removePortInfo(int ch) {
		phoneStreamMap.put(ch, null);
	}
}
