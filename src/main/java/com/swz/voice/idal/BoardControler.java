package com.swz.voice.idal;

import java.util.Map;

/**
 * 板卡基本操作与信息获取
 * 
 * @author Charsp
 *
 * @date 2015年1月8日
 */
public interface BoardControler {

	/**
	 * 获取当前板卡的基本信息(Map形式的字符流)
	 * 
	 * @return
	 * 
	 */
	public Map<String, Integer> boardUsedInfo();

	/**
	 * 关闭板卡(停止运行)
	 * 
	 * @return 返回关闭信息Json结构
	 */
	public String closeBoard();

	/**
	 * 停止板卡运行(永久性)
	 * 
	 * @return
	 */
	public String stopBoard();

	/**
	 * 板卡的重启
	 * 
	 * @return 成功返回true
	 */
	public boolean restartBoard();

	/**
	 * 初始化板卡信息(开始运行)
	 * 
	 * @return
	 */
	public int initdBoard();

	/**
	 * 创建相应线程
	 * 
	 * @param maxPort
	 *            最大端口号
	 * @return 成功返回0
	 */
	public int startPortThread(int maxPort);

	/**
	 * 撤销相应线程
	 * 
	 * @param maxPort
	 *            最大端口号
	 * @return 成功返回0
	 */
	public int endPortThread();

	/**
	 * 开始自动接警
	 * 
	 * @return 成功返回0
	 */
	public int startAutoAlarm();

	/**
	 * 停止自动接警
	 * 
	 * @return 成功返回0
	 */
	public int stopAutoAlarm();

	/**
	 * 
	 */
}
