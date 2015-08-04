package com.swz.system.admin;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserInfo {
	private Integer id;
	private String userName;
	private String password;
	/**
	 * 用户许可
	 */
	private Permission permission;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	@Override
	public String toString() {
		Map<String, Object> userMap = new HashMap<String, Object>();
		userMap.put("id", this.getId());
		userMap.put("userName", this.getUserName());
		userMap.put("password", this.getPassword());
		userMap.put("permission", this.getPermission());
		return userMap.toString();
	}
}