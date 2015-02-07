package com.swz.voice.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;

public class BaseOperateDao {
	protected SqlSessionTemplate sessionTemplate;
	protected static final String MYBATIS_NAMESPACE_STRING = "com.swz.weixinapp";

	public SqlSessionTemplate getSessionTemplate() {
		return sessionTemplate;
	}

	@Resource
	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
		this.sessionTemplate = sessionTemplate;
	}
}
