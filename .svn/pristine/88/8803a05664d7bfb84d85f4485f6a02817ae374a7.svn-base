package com.swz.system.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;

public abstract class BaseDao {
	protected SqlSessionTemplate sessionTemplate;
	protected static final String MYBATIS_NAMESPACE = "com.swz.test";
	protected static final String MYBATIS_NAMESPACE_STRING="com.swz.weixinapp";

	public SqlSessionTemplate getSessionTemplate() {
		return sessionTemplate;
	}

	@Resource
	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
		this.sessionTemplate = sessionTemplate;
	} 
}
