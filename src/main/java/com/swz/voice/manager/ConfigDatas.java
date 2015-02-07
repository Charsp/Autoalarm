package com.swz.voice.manager;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.swz.voice.model.VisitInfo;

public class ConfigDatas {
	/**
	 * 基本项配置
	 */
	// 获取数据网址
	private static String GetPath = "http://10.0.111.4/servlet/get_alarm_ex";
	// 发送数据网址
	private static String PutPath = "http://10.0.111.4/servlet/handle_alarm_ex";
	// 微信接口-用户信息
	private static String MYINFAddress = "http://163.177.98.244/MMI/CORE";
	// 监控总人数
	private static Integer PeopleSum = 4;
	// 平均每人分配时间(秒)
	private static Integer PerSecond = 30;
	// ShConfig.ini和ShIndex.ini两个ini文件目录の位置
	private static String SHConfig = "C:\\ShCti\\";
	// autoalarm_1_64kbps_Mono.wav 和autoalarm_2_64kbps_Mono.wav
	// 等录音文件位置
	private static String MediaPath = "F:\\sysCode\\weixin\\DLL_SO\\";
	private static String alarmSound = "";
	private static String confirmSound = "";
	private static List<String> AlarmStyle = new ArrayList<String>();
	/**
	 * 客户回访语音列表
	 */
	private static List<VisitInfo> visitInfos;
	/**
	 * 电话拨打时间限制(默认60秒，一分钟)
	 */
	private static Integer timeOut = 60;
	private static boolean debug = false;
	// 初始化参数
	static {
		resetConfigData();
		// 从数据库中读取语音信息 
	}

	public static List<VisitInfo> getVisitInfos() {
		return visitInfos;
	}

	public static void setVisitInfos(List<VisitInfo> visitInfos) {
		ConfigDatas.visitInfos = visitInfos;
	}

	public static void resetConfigData() {
		Properties properties = new Properties();
		InputStream inputStream = ConfigDatas.class
				.getResourceAsStream("/config/SHT_Config.properties");
		try {
			properties.load(inputStream);
			inputStream.close();
			AlarmStyle.clear();
			/**
			 * 基本项配置
			 */
			if (properties.containsKey("GetPath")) {
				GetPath = properties.getProperty("GetPath").trim();
			}
			if (properties.containsKey("PutPath")) {
				PutPath = properties.getProperty("PutPath").trim();
			}
			if (properties.containsKey("MYINFSite")) {
				MYINFAddress = properties.getProperty("MYINFSite").trim();
			}
			if (properties.containsKey("PeopleSum")) {
				try {
					PeopleSum = Integer.parseInt(properties.getProperty(
							"PeopleSum").trim());
				} catch (Exception exception) {
					// 参数不是数字
					exception.printStackTrace();
				}
			}
			if (properties.containsKey("PerSecond")) {
				try {
					PerSecond = Integer.parseInt(properties.getProperty(
							"PerSecond").trim());
				} catch (Exception exception) {
					// 参数不是数字
					exception.printStackTrace();
				}
			}
			if (properties.containsKey("SHConfig")) {
				SHConfig = properties.getProperty("SHConfig").trim();
			}
			if (properties.containsKey("MediaPath")) {
				MediaPath = properties.getProperty("MediaPath").trim();
			}
			if (properties.containsKey("Timeout")) {
				timeOut = Integer.parseInt(properties.getProperty("Timeout")
						.trim());
			}
			if (properties.containsKey("Debug")
					&& properties.getProperty("Debug").trim()
							.equalsIgnoreCase("true")) {
				debug = true;
			}
			if (properties.containsKey("AlarmSound")) {
				alarmSound = properties.getProperty("AlarmSound").trim();
			}
			if (properties.containsKey("confirmSound")) {
				confirmSound = properties.getProperty("confirmSound").trim();
			}
			
			if (properties.containsKey("AlarmStyle")) {
				String[] temp = properties.getProperty("AlarmStyle").split(",");
				for (int i = 0; i < temp.length; i++) {
					AlarmStyle.add(new String(temp[i].getBytes("ISO-8859-1"),
							"UTF-8"));
				}
			}
		} catch (Exception e) {
			// 获取配置文件出错
			e.printStackTrace();
		}
	}

	public static String getGetPath() {
		return GetPath;
	}

	public static String getPutPath() {
		return PutPath;
	}

	public static Integer getPeopleSum() {
		return PeopleSum;
	}

	public static Integer getPerSecond() {
		return PerSecond;
	}

	public static String getSHConfig() {
		return SHConfig;
	}

	public static String getMediaPath() {
		return MediaPath;
	}

	public static Integer getTimeOut() {
		return timeOut;
	}

	public static String getMYINFAddress() {
		return MYINFAddress;
	}

	public static boolean isDebug() {
		return debug;
	}

	public static void setGetPath(String getPath) {
		if (getPath != null) {
			GetPath = getPath;
		}
	}

	public static void setPutPath(String putPath) {
		if (putPath != null) {
			PutPath = putPath;
		}
	}

	public static void setMYINFAddress(String mYINFAddress) {
		if (mYINFAddress != null) {
			MYINFAddress = mYINFAddress;
		}
	}

	public static void setPeopleSum(Integer peopleSum) {
		if (peopleSum != null) {
			PeopleSum = peopleSum;
		}
	}

	public static void setPerSecond(Integer perSecond) {
		if (perSecond != null) {
			PerSecond = perSecond;
		}
	}

	public static void setMediaPath(String mediaPath) {
		if (mediaPath != null) {
			MediaPath = mediaPath;
		}
	}

	public static String getAlarmSound() {
		return alarmSound;
	}

	public static void setAlarmSound(String alarmSound) {
		if (alarmSound != null) {
			ConfigDatas.alarmSound = alarmSound;
		}
	}

	public static String getConfirmSound() {
		return confirmSound;
	}

	public static void setConfirmSound(String confirmSound) {
		if (confirmSound != null) {
			ConfigDatas.confirmSound = confirmSound;
		}
	}

	public static List<String> getAlarmStyle() {
		return AlarmStyle;
	}

	public static void setAlarmStyle(List<String> alarmStyle) {
		if (alarmStyle != null) {
			AlarmStyle.clear();
			AlarmStyle = alarmStyle;
		}
	}

	public static void main(String[] adStrings) {
		System.out.println(getPutPath());
		System.out.println(getGetPath());
		System.out.println(getMediaPath());
		System.out.println(getSHConfig());
		System.out.println(getPeopleSum());
		System.out.println(getPerSecond());
		System.out.println(getMYINFAddress());
		System.out.println(getTimeOut());
		System.out.println(getAlarmStyle());
	}
}
