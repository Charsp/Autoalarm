package com.swz.data.vo.mysql;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@XmlRootElement
public class Userinfo {
	private int iduserinfo;
	private String username;
	private String password;
	private String nick;
	private boolean sex;
	private int age;
	private String personnal;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date date;

	public Integer getIduserinfo() {
		return iduserinfo;
	}

	public void setIduserinfo(Integer iduserinfo) {
		this.iduserinfo = iduserinfo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPersonnal() {
		return personnal;
	}

	public void setPersonnal(String personnal) {
		this.personnal = personnal;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "{iduserinfo:\"" + this.iduserinfo + "\",nick:\"" + this.nick
				+ "\",password:\"" + this.password + "\",username:\""
				+ this.username + "\",age:\"" + this.age + "\",personnal:\""
				+ this.personnal + "\",Date:\"" + this.getDate() + "\"}";
	}

}
