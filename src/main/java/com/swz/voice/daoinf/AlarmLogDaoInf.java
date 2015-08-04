package com.swz.voice.daoinf;

import java.util.List;

import com.swz.data.vo.mysql.Log_alarm;
import com.swz.voice.model.PageInfo;

public interface AlarmLogDaoInf {
	/**
	 * 获取自动接警日志
	 * 
	 * @return
	 */
	public List<Log_alarm> getAlarms(PageInfo pageInfo); 

	/**
	 * 获取自动接警日志
	 * 
	 * @return
	 */
	public Integer saveAlarms(Log_alarm log_alarm);
}
