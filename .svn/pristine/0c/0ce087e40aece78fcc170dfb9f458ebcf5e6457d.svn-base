package com.swz.voice.model;

/**
 * 语音卡基础状态信息
 * 
 * @author Charsp
 *
 * @date 2015年1月6日
 */
public class BaseStatus {
	// 语音机器当前数量
	private int currSumLines = 0;
	// 电话线当前连接数量
	private int currTeleLines = 0;
	// 忙线路
	private int busyLines = 0;

	public int getCurrSumLines() {
		return currSumLines;
	}

	public int getCurrTeleLines() {
		return currTeleLines;
	}

	public int getBusyLines() {
		return busyLines;
	}

	@Override
	public String toString() {
		// 返回json信息
		return "{currSumLines:\"" + currSumLines + "\", currTeleLines:\""
				+ currTeleLines + "\", busyLines:\"" + busyLines + "\"}";
	}
}
