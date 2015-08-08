package com.swz.data.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONObject;

/**
 * LogAlarm.java
 *
 * @author CharsBoll
 *
 * @date 2015年8月5日
 */
public class ProcessAlarmLog {
	/** 接警日志 */
	public List<JSONObject> contentList = Collections
			.synchronizedList(new ArrayList<JSONObject>());

	public List<JSONObject> getContentList() {
		return contentList;
	}

	/*** 线程安全的list添加 */
	public boolean addContentList(JSONObject content) {
		synchronized (contentList) {
			boolean absent = !contentList.contains(content);
			if (absent)
				contentList.add(content);
			return absent;
		}
	}

	/*** 线程安全的list删除 */
	public void removeContent(JSONObject userInfo) {
		for (Iterator<JSONObject> it = contentList.iterator(); it.hasNext();) {
			JSONObject s = it.next();
			if (s.equals(userInfo)) {
				it.remove();
			}
		}
	}

}
