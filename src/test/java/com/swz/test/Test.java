package com.swz.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 
 * @author Charsp
 *
 * @date 2015年1月27日
 */
public class Test {
	private static Integer numInteger;

	public Integer getNumInteger() {
		return numInteger;
	}

	public static void main(String[] args) throws InterruptedException {
		// System.out.println("d"+numInteger);
		// Map<String, Integer>map =new HashMap<String, Integer>();
		// map.put("123",123);
		// Integer integer =123;
		// List<VisitInfo> visitInfos = new ArrayList<VisitInfo>();
		// VisitInfo visitInfo = new VisitInfo();
		// visitInfo.setQuestion("dd");
		// visitInfo.setQuestion_type("xxxxxx");
		// visitInfos.add(visitInfo);
		// visitInfos.add(visitInfo);
		//
		// JSONObject alarmSignal = JSONObject.fromObject(visitInfos.get(0));
		// alarmSignal.put("AutoVisit", "AutoVisit");
		//
		// visitInfos.remove(0);
		// System.out.println(visitInfos.size() + "  ddddd " +
		// alarmSignal);
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+08:00"));
		Date date = new Date();
		String dateString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(date);
		System.out.println("国际化中国的日期为：" + dateString);
		Calendar calendar = Calendar.getInstance();
		calendar.set(1970, 0, 1);
		System.err.println(date + "dddddd" + calendar.getTime());

	}
}
