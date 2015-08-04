package com.swz.voice.service;

import net.sf.json.JSONObject;

public class PhoneAdresss {

	/**
	 * �����ֻ������������ĸ����еģ�������������API
	 * 
	 * @param mobileNumber
	 *            �ֻ�����
	 * @return 
	 *         {"mobile":"15216991423","province":"�㶫","isp":"�й��ƶ�","stock":"1"
	 *         , "amount":"10","maxprice":"0","minprice":"0","cityname":"����"}
	 * 
	 */
	public static JSONObject calcMobileCity(String mobileNumber) {
		String jsonString = null;
		JSONObject jsonObject = null;
		String urlString = "http://virtual.paipai.com/extinfo/GetMobileProductInfo?amount=10&mobile="
				+ mobileNumber;
		try {
			jsonString = HttpServlet.sendGet(urlString, null, "GBK");
			jsonString = jsonString.substring(0, jsonString.indexOf(");"));
			jsonString = jsonString.replace("(", "").replace(");", "");
			System.out.println(jsonString);
			jsonObject = JSONObject.fromObject(jsonString);
		} catch (Exception e) {
			System.err.println("api.k780.com:88/网站异常！！" + e.getMessage());
		}
		return jsonObject;
	}

	public static JSONObject getMobileInfo(String phoneNum) {
		// 有配额限制，和糟糕的网站
		// http://api.k780.com:88/?app=phone.get&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4&format=json&phone=13702271353
		JSONObject jsonObject = null;

		try {
			String string = HttpServlet
					.sendGet(
							"http://api.k780.com:88/?app=phone.get&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4&format=json&phone="
									+ phoneNum, null, null);
			jsonObject = JSONObject.fromObject(string);
			System.out.println("程序返回值" + jsonObject);
			System.out.println("程序返回值" + jsonObject);
			System.out.println("程序返回值" + jsonObject);
			if (jsonObject.getString("success").equals("1")) {
				jsonObject = jsonObject.getJSONObject("result");
			} else {
				jsonObject = null;
			}

		} catch (Exception e) {
			System.out.println("api.k780.com:88/网站异常！！");
		}
		return jsonObject;
	}

	public static void main(String[] args) throws Exception {
		// 1521698,1521699
		// String testMobileNumber = "15216991423";
		// JSONObject telePhone = calcMobileCity(testMobileNumber);
		// System.out.println(telePhone);
		// if (telePhone.getString("province").equals("�㶫")
		// && telePhone.getString("cityname").equals("����")) {
		// System.out.println(true);
		// } else {
		// System.err.println(false);
		// }
		System.out.println(getMobileInfo("15216991423"));
	}
}