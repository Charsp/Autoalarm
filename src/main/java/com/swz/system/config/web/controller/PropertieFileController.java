package com.swz.system.config.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swz.data.vo.mysql.Userinfo;
import com.swz.system.admin.UserInfo;
import com.swz.system.dao.UserDao;

@RestController 
public class PropertieFileController {
	private static final Logger logger = LoggerFactory
			.getLogger(PropertieFileController.class);
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	// 用户登录成功
	@RequestMapping(value = "/adminlogin")
	public UserInfo userLogin(HttpServletRequest request, UserInfo userInfo) {
		// 获取用户登录信息
		System.out.println("用户信息" + userInfo.toString());
		logger.info("获得用户信息为" + userInfo.toString());
		List<String> list = new ArrayList<String>();
		list.add("no1");
		list.add(userInfo.getUserName());
		list.add(userInfo.getPassword());
		list.add(userInfo.toString());
		return userInfo;
	}

	@RequestMapping(value = "/wellcome")
	public Userinfo wellcome() {

		return userDao.find(1);
	}

	// 显示系统配置文件

	@RequestMapping(value = "/open")
	public Map<String, Object> open() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("errcode", 0);
		logger.info("用户打开设备");
		return map;
	}

	@RequestMapping(value = "/close")
	public Map<String, String> close() {
		Map<String, String> map = new HashMap<String, String>();
		return map;
	}

}
