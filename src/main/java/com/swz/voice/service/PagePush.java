package com.swz.voice.service;

/**
 * 网页推送技术(HTML5)
 * 
 * @author Charsp
 *
 * @date 2015年1月8日
 */
public interface PagePush {

	// Json 串推送
	public void sendJsonToUrl();

	// XML 文本推送
	public void sendXmlToUrl();

	// 其他格式(大数据推送)
	public void sendTextUrl();

}
