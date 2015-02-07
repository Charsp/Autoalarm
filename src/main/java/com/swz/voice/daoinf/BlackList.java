package com.swz.voice.daoinf;

import java.util.List;

import com.swz.data.vo.mysql.Info_blacklist;
import com.swz.voice.model.PageInfo;

public interface BlackList {
	/**
	 * 获取一定数量的黑名单
	 * 
	 * @param pageInfo
	 *            页面大小和页数
	 * @return 数组类型
	 */
	public List<Info_blacklist> queryBlacklists(PageInfo pageInfo);

	/**
	 * 插入黑名单
	 * 
	 * @param blacklist
	 * @return
	 */
	public Long insertBlacklist(Info_blacklist blacklist);

	/**
	 * 从黑名单中移除
	 * 
	 * @param blacklist
	 * @return
	 */
	public Long deleteBlacklist(Info_blacklist blacklist);
}
