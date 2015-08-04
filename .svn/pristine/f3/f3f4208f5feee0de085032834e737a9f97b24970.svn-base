package com.swz.system.config.web.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swz.voice.manager.ConfigDatas;
import com.swz.voice.service.AutoAlarmProc;

@RestController
public class DeviceOperateController extends BaseController {
	@RequestMapping(value = "/OpenDevice")
	public Map<String, Object> voiceDeviceOpen(HttpServletRequest request) {
		// 按照权限分配职能
		HttpSession session = request.getSession();
		if (getUserPower((Integer) session.getAttribute("UserId")) > 9) {
			// 尝试打开设备
			return returnErrorCode(AutoAlarmProc.openAlarmProc());
		}
		return returnErrorCode(2009);
	}

	@RequestMapping(value = "/CloseDevice")
	public Map<String, Object> voiceDeviceClose(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (getUserPower((Integer) session.getAttribute("UserId")) > 9) {
			// 尝试关闭设备
			return returnErrorCode(AutoAlarmProc.closeAlarmProc());
		}
		return returnErrorCode(2009);
	}

	/**
	 * 输出参数配置页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/ConfigPage")
	public Map<String, Object> getRunStatus(HttpServletRequest request) {
		Map<String, Object> map = returnErrorCode(0);
		map.put("AlarmSound", ConfigDatas.getAlarmSound());
		map.put("AlarmStyle", ConfigDatas.getAlarmStyle());
		map.put("ConfirmSound", ConfigDatas.getConfirmSound());
		map.put("GetPath", ConfigDatas.getGetPath());
		map.put("MediaPath", ConfigDatas.getMediaPath());
		map.put("MYINFAddress", ConfigDatas.getMYINFAddress());
		map.put("PeopleSum", ConfigDatas.getPeopleSum());
		map.put("PerSecond", ConfigDatas.getPerSecond());
		map.put("PutPath", ConfigDatas.getPutPath());
		map.put("SHConfig", ConfigDatas.getSHConfig());
		map.put("TimeOut", ConfigDatas.getTimeOut());
		return map;
	}

	@RequestMapping(value = "/DeviceStatus")
	public Map<String, Object> getDeviceStatus() {
		Map<String, Object> map = returnErrorCode(0);
		if (AutoAlarmProc.getOpenedDevice()) {
			map.put("Opened", true);
			map.put("OpenTime", AutoAlarmProc.getOpenedTime());
		} else {
			map.put("Opened", false);
		}
		return map;
	}
}
