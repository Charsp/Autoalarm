package com.swz.system.config.web.controller;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.swz.voice.service.TransactionStream;

/**
 * LoginfoCtrl.java
 *
 * @author CharsBoll
 *
 * @date 2015年8月5日
 */
@Controller
public class LoginfoView {
	/**
	 * 打印截获和释放的消息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/showlog")
	@ResponseBody
	public Map<String, Object> loginfo() {
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();
		map.put("begin", TransactionStream.beginAlarmLog.getContentList());
		map.put("end", TransactionStream.noProcess.getContentList());
		return map;
	}
}
