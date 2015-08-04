package com.swz.voice.dao;

import org.springframework.stereotype.Repository;

import com.swz.data.vo.mysql.Info_user;

@Repository
public class VisitLogDao extends BaseOperateDao {

	public Info_user findById(Long id) {
		return sessionTemplate.selectOne(MYBATIS_NAMESPACE_STRING
				+ ".queryinfo_user", id);
	}
}
