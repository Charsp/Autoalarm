package com.swz.voice.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.swz.voice.impl.BoardControlerImpl;
import com.swz.voice.manager.ConfigDatas;
import com.swz.voice.model.MESSAGE_INFO;
import com.swz.voice.model.PaperResult;
import com.swz.voice.model.QuestionResult;
import com.swz.voice.model.SHP_A3;
import com.swz.voice.model.VisitInfo;

/**
 * 自动接警
 * 
 * @author Charsp
 *
 * @date 2015年1月9日
 */
public class AutoAlarmProc extends Thread {
	private static Logger log = LoggerFactory.getLogger(AutoAlarmProc.class);
	private static AutoAlarmProc alarmProc = null;
	private static Date openedTime;
	private static boolean openedDevice;
	// 注入客户端

	/* 变量定义区域 */

	// 公有变量
	/**
	 * 车辆信息值 端口号 报警信息
	 */
	public static Map<Integer, JSONObject> vehicleId = new HashMap<>();
	/**
	 * 问卷返回信息
	 */
	public static Map<Integer, PaperResult> paperResult = new HashMap<>();
	/**
	 * 端口忙标识
	 */
	// public static Map<Integer, Long> portBusy = new HashMap<Integer, Long>();
	/**
	 * 客户回访的电话列表
	 */
	private static List<String> telephoneList = new ArrayList<String>();
	/**
	 * 客户回访之前的总数
	 */
	public static Integer historySum;
	public static Date startTime = null;
	// 私有变量
	/**
	 * 驱动程序
	 */
	private static SHP_A3 MYAPI = SHP_A3.INSTANCE;
	/**
	 * 事件设置
	 */
	private static MESSAGE_INFO Event = new MESSAGE_INFO();
	/**
	 * 媒体播放路径
	 */
	// public static String mediaPath = ConfigDatas.getMediaPath();
	// private static int outTimeLimit = ConfigDatas.getTimeOut();
	/**
	 * 事件监听标识
	 */
	private static boolean canDone = false;
	private boolean isThreadStop = false;
	/**
	 * 每个线程的按键类型号码 次数 或者当前问卷
	 */
	private static List<Integer> keyCount = new ArrayList<Integer>();
	private static BoardControlerImpl boardControlerImpl = new BoardControlerImpl();

	/* 公有方法区域 */

	/**
	 * 打开板卡
	 */
	public static int openBoard() {
		int result = -3;
		/** 配置文件检查 -3 **/
		// 语音文件不存在
		// System.out.println("配置文件为::" + ConfigDatas.getMediaPath()
		// + ConfigDatas.getAlarmSound());
		if (!new File(ConfigDatas.getMediaPath() + ConfigDatas.getAlarmSound())
				.exists()
				|| !new File(ConfigDatas.getMediaPath()
						+ ConfigDatas.getConfirmSound()).exists()) {
			// 从新加载，说重新启动一次
			ConfigDatas.resetConfigData();
		}

		if (!new File(ConfigDatas.getMediaPath() + ConfigDatas.getAlarmSound())
				.exists()
				|| !new File(ConfigDatas.getMediaPath()
						+ ConfigDatas.getConfirmSound()).exists()) {
			return result;
		}

		/** keycount 提前复值，导致没有初始化成功 **/
		result = boardControlerImpl.initdBoard();

		canDone = false;
		keyCount.clear();// 初始化按键次数
		for (int i = 0; i < MYAPI.SsmGetMaxCh(); i++)
			keyCount.add(0);

		return result;
	}

	public static void MySHTHangup(int currPort) {
		MYAPI.SsmHangup(currPort);
		// 其实，系统会强制覆盖数据段的
		if (vehicleId != null && vehicleId.containsKey(currPort)) {
			// log.info("--------------------   当前端口" + currPort
			// + "  数据被清除-------------------");
			vehicleId.remove(currPort);
		}
		try {
			keyCount.set(currPort, 0);
		} catch (Exception e) {
		}
	}

	public static Map<String, Object> getBoardInfo() {
		return boardControlerImpl.boardUsedInfo();
	}

	/**
	 * 电话事务进行中
	 * 
	 * @return 如果结束了所有通话，则返回false,否则返回true
	 */
	public static boolean telTransacting() {
		return !vehicleId.isEmpty();
	}

	public static String getPortInfo(int currPort, String context) {
		if (vehicleId.get(currPort) != null) {
			try {
				return vehicleId.get(currPort).getString(context);
			} catch (Exception e) {
				log.info("出错了" + e.getMessage(), e);
			}
		}
		return "(vehicleId已经失效)";
	}

	/**
	 * 自动接警和语音回访的主线程
	 * 
	 * @author Charsp
	 * @date 2015-02-25
	 */
	public void run() {
		log.info("mediaPath：" + ConfigDatas.getMediaPath());
		try {
			int EventCh = 0;
			// 初始化代码（第一次运行）
			Map<Integer, Boolean> portClose = new HashMap<>();
			while (!this.isThreadStop) {
				// 测试进入程序段数据
				while (!canDone) {
					if (MYAPI.SsmWaitForEvent(200, Event) == 0) {
						EventCh = Event.nReference;// 获取事件的端口号
						// 当前端口数据没有被清除
						if (vehicleId.containsKey(EventCh)
								&& !TransactionStream.isOverdued(vehicleId.get(
										EventCh).getString("telePhone"))) {
							if (Event.wEvent == SHP_A3.E_PROC_PlayEnd) {
								// 播放完成时间
								// log.info("一直出现播放完成事件 164");
								if (portClose.containsKey(EventCh)
										&& portClose.get(EventCh)) {
									MySHTHangup(EventCh);
									portClose.put(EventCh, false);
								}
							} // E_PROC_PlayFile 可以不使用播放事件

							// 自动接警系统
							if (vehicleId.get(EventCh) != null
									&& !vehicleId.get(EventCh).containsKey(
											"AutoVisit")) {

								// 要有端口的事件类型，语音接警和语音回访
								if (Event.wEvent == SHP_A3.E_CHG_ToneAnalyze) {
									int ToneType = MYAPI
											.SsmGetToneAnalyzeResult(EventCh);
									// 检测到拨号音
									if (ToneType == 0) {
										// log.info(getPortInfo(EventCh,
										// "car_no")
										// + "  通话正常结束！");
										canDone = true;
									} else if (ToneType == 1) {
										// log.info(getPortInfo(EventCh,
										// "car_no")
										// + " 端口" + EventCh + "正在拨号！");
									}
									// 检测到忙音
									else if (ToneType == 2) {
										// log.error("被  "
										// + getPortInfo(EventCh, "car_no")
										// + "  强制关掉了/或者根本就没接电话！");
										boardControlerImpl.sendUserPress(
												EventCh, false);
										MySHTHangup(EventCh); // 挂机
										canDone = true;
									}
									// 检测到回铃音
									else if (ToneType == 3) {
										// log.info("等待客户  "
										// + getPortInfo(EventCh, "car_no")
										// + " 摘机！");
									} else if (ToneType == 4 || ToneType == 5
											|| ToneType == 6) {
										// 播放初始化的音频程序
										MYAPI.SsmPlayFile(
												EventCh,
												ConfigDatas.getMediaPath()
														+ ConfigDatas
																.getAlarmSound(),
												6, 0, 160000);
										// log.info("通话成功！" + new Date());
									}
								}
								// E_CHG_RcvDTMF 信号！！
								if (Event.wEvent == SHP_A3.E_CHG_RcvDTMF) {
									String pszDtmf = MYAPI
											.SsmGetDtmfStrA(EventCh);
									switch (pszDtmf) {
									case "2":
										if (keyCount.get(EventCh) == 0) {// 程序挂机
											log.info("端口"
													+ EventCh
													+ "消息："
													+ getPortInfo(EventCh,
															"car_no")
													+ "  客户直接按键为2，转人工台！");
											// 最后一个时间很重要啊的参数
											MYAPI.SsmPlayFile(EventCh,
													ConfigDatas.getMediaPath()
															+ "SWZ_dtmf1.wav",
													-1, 0, 10000);
											// 设置为关闭窗口
											portClose.put(EventCh, true);
											boardControlerImpl.sendUserPress(
													EventCh, false);
											// 自动接警失败，程序返回给人工台

										} else {
											log.info("端口"
													+ EventCh
													+ "消息："
													+ getPortInfo(EventCh,
															"car_no")
													+ "  客户按键为2，返回上一级");
											keyCount.set(EventCh, 0);
										}
										// 重新填充 语音数据
										canDone = true;
										break;
									case "1":
										if (keyCount.get(EventCh) == 0) {
											log.info("端口"
													+ EventCh
													+ "消息："
													+ getPortInfo(EventCh,
															"car_no")
													+ "  客户第一次按键1");
											keyCount.set(EventCh, 1);
											MYAPI.SsmPlayFile(
													EventCh,
													ConfigDatas.getMediaPath()
															+ ConfigDatas
																	.getConfirmSound(),
													6, 0, 10000);
										} else if (keyCount.get(EventCh) == 1) {
											// 自动接警失败，程序返回给人工台
											boardControlerImpl.sendUserPress(
													EventCh, true);
											log.info("端口"
													+ EventCh
													+ "消息："
													+ getPortInfo(EventCh,
															"car_no")
													+ "  客户第二次按键1，已确认误报！");
											// 回复按键初始值
											keyCount.set(EventCh, 0);
											// log.info("语音问候语.............--------");
											MYAPI.SsmPlayFile(EventCh,
													ConfigDatas.getMediaPath()
															+ "SWZ_dtmf2.wav",
													-1, 0, 1000000);
											// log.info("程序挂机中.............--------");
											MySHTHangup(EventCh); // 挂机是
											// 重播
											canDone = true;
										}
										break;
									default:
										// 可以语音提示
										log.error("端口"
												+ EventCh
												+ "消息："
												+ "用户 "
												+ getPortInfo(EventCh, "car_no")
												+ " 按键" + pszDtmf + "不能识别！");
										break;
									}
								}//
								MYAPI.SsmClearRxDtmfBuf(EventCh); // 清除按键消息内容
							}
							// 自动语音回访系统（要求问题数据>0，语音>2其中友谊个是结束问候语）
							else if (ConfigDatas.getVisitInfos() != null
									&& !ConfigDatas.getVisitInfos().isEmpty()) {
								// 要有端口的事件类型，语音接警和语音回访
								if (Event.wEvent == SHP_A3.E_CHG_ToneAnalyze) {
									int ToneType = MYAPI
											.SsmGetToneAnalyzeResult(EventCh);
									// 播放当前语音
									if (ToneType == 4 || ToneType == 5
											|| ToneType == 6) {
										// 播放初始化的音频程序(播放第0个问题的语音)
										VisitInfo visitInfo = ConfigDatas
												.getVisitInfos().get(0);
										String questionFirst = visitInfo
												.getSound_path()
												+ visitInfo.getSound_name();
										MYAPI.SsmPlayFile(EventCh,
												questionFirst, 6, 0, 100000);
										// 没有创建则创建一项
										if (paperResult.get(EventCh) == null) {
											PaperResult paper = new PaperResult();
											String userName = vehicleId.get(
													EventCh).getString(
													"telePhone");
											String userPhone = vehicleId.get(
													EventCh).getString(
													"userName");
											paper.setStartDate(new Date());
											paper.setUserName(userName);
											paper.setUserPhone(userPhone);
											paperResult.put(EventCh, paper);
										}
										// 初始化语音代码，直接就可以选择问题答案!
										// log.info("自动语音回访系统通话成功！" + new
										// Date());
									}
									// 检测到忙音
									if (ToneType == 2) {
										// log.error("被  "
										// + getPortInfo(EventCh, "car_no")
										// + "  强制关掉了/或者根本就没接电话！");
										// 自动接警失败，程序返回给人工台
										keyCount.set(EventCh, 0);
										boardControlerImpl.sendUserPress(
												EventCh, false);
										MySHTHangup(EventCh); // 挂机
										canDone = true;
									}
									if (ToneType == 0) {
										// log.info(getPortInfo(EventCh,
										// "car_no")
										// + "  通话正常结束！");
										// 我方关闭该按键，为正常关闭，否则为用户强制结束关闭电话系统
									}
								}// end wEventCode
									// E_CHG_RcvDTMF 信号 用户互交程序
								if (Event.wEvent == SHP_A3.E_CHG_RcvDTMF) {
									String pszDtmf = MYAPI
											.SsmGetDtmfStrA(EventCh);
									// 获取当前端口位置的问题
									try {
										// 获得本次播发 问卷的问题的信息(第keyCount个问题)
										VisitInfo visitInfo = ConfigDatas
												.getVisitInfos().get(
														keyCount.get(EventCh));
										// 判断语音格式，多项选择型 和 YesNo 型
										switch (pszDtmf) {
										case "0":// 第零项
										case "1":// 第一项
										case "2":// 第二项
										case "3":// 第三项
										case "4":// 第四项
										case "5":// 第五项
											// Yes-No类型判别
											if (visitInfo.getQuestion_type()
													.equalsIgnoreCase("yesno")
													&& !pszDtmf.equals("1")
													&& !pszDtmf.equals("2")) {
												log.info("用户按键错误！ 非1或2在类型为 yesno下 ");
											}
											// 正确按键，进入下一题
											else {
												// 日志信息 增加一个问题的结果
												QuestionResult questionResult = new QuestionResult();
												questionResult
														.setQuestionId(visitInfo
																.getQuestion_id());
												questionResult
														.setQuestionType(visitInfo
																.getQuestion_type());
												questionResult
														.setKeyVal(pszDtmf);
												// 获取原始
												PaperResult paper = paperResult
														.get(EventCh);
												List<QuestionResult> questionResults = paper
														.getQuestionResults();
												if (questionResults == null) {
													questionResults = new ArrayList<QuestionResult>();
												}
												// 新增加一个问题
												questionResults
														.add(questionResult);
												paper.setQuestionResults(questionResults);
												// 填充完毕
												paperResult.put(EventCh, paper);
												// 增加一个变量
												keyCount.set(
														EventCh,
														keyCount.get(EventCh) + 1);
												// 播放下一个语音
												/**
												 * 算法： 0 -> n
												 * 
												 */
												System.out
														.println(ConfigDatas
																.getVisitInfos()
																.size()
																+ "but"
																+ keyCount
																		.get(EventCh));
												if (ConfigDatas.getVisitInfos()
														.size() > keyCount
														.get(EventCh)) {
													// 获得下一个语音播放
													visitInfo = ConfigDatas
															.getVisitInfos()
															.get(keyCount
																	.get(EventCh));
													MYAPI.SsmPlayFile(
															EventCh,
															visitInfo
																	.getSound_path()
																	+ visitInfo
																			.getSound_name(),
															6, 0, 1000000);
												}
												// 所有语音播放完成，回复问候语句
												else {
													// 获得下一个语音播放
													MYAPI.SsmPlayFile(
															EventCh,
															ConfigDatas
																	.getMediaPath()
																	+ ConfigDatas
																			.getEndGreeting(),
															6, 0, 100000);
													// 初始化程序位置
													keyCount.set(EventCh, 0);
													MySHTHangup(EventCh); // 挂机
													// log.info("程序挂机中------.............------");
													boardControlerImpl
															.sendVisitInfo(paperResult
																	.get(EventCh));// 发送信息
												}
												log.info("在问题上，用户选择了 "
														+ pszDtmf);
											}
											break;
										default:
											// 用户操作错误语音
											MYAPI.SsmPlayFile(
													EventCh,
													visitInfo.getSound_path()
															+ visitInfo
																	.getSound_name(),
													6, 0, 1000000);
											log.error("用户按键错误！ 1-5 ");
											break;
										}
										MYAPI.SsmClearRxDtmfBuf(EventCh); // 清除按键消息内容
										// }
									} catch (Exception e) {
										log.error("当前没有语音内容", e);
									}
									MYAPI.SsmClearRxDtmfBuf(EventCh); // 清除按键消息内容
								}// EndIf E_CHG_RcvDTMF
							}
						} else {
							// log.info("确认端口" + EventCh +
							// " 已经没有数据了,正在释放端口信息...");
							// 直接给挂机
							MySHTHangup(EventCh); // 挂机是
						}
					}// End If
				}// Done // 半秒钟延时等待
				Thread.sleep(500);
				canDone = false;
			}
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
		} finally {
			// 强制关闭板卡
			boardControlerImpl.stopBoard();
			log.info("##################板卡关闭###################");
		}
	}

	public static int closeAlarmProc() {
		if (alarmProc != null && !alarmProc.isThreadStop) {
			canDone = true;
			alarmProc.isThreadStop = true;
			alarmProc = null;
			// 关闭成功
			setOpenedDevice(false);
			return 0;
		} else {
			// 设备还没有打开,关闭失败
			return 4003;
		}
	}

	public static boolean openedDevice() {
		if (alarmProc == null)
			return false;
		else {
			return true;
		}
	}

	public static Date getOpenedTime() {
		return openedTime;
	}

	public static void setOpenedTime(Date openedTime) {
		AutoAlarmProc.openedTime = openedTime;
	}

	public static boolean getOpenedDevice() {
		return openedDevice;
	}

	public static void setOpenedDevice(boolean openedDevice) {
		AutoAlarmProc.openedDevice = openedDevice;
	}

	public static int openAlarmProc() {
		// 设备存在
		setOpenedDevice(true);
		if (!openedDevice()) {
			int openid = openBoard();
			if (openid == 0) {
				alarmProc = new AutoAlarmProc();
				alarmProc.start();
				setOpenedTime(new Date());
				return 0;
			}
			// 驱动重复加载
			else if (openid == -2) {
				return 4004;
			}
			// 基本配置文件加载错误
			else if (openid == -3) {
				return 4005;
			}
		}
		// 打开失败好不好！
		setOpenedDevice(false);
		return 4001;
	}

	public synchronized static List<String> getTelephoneList() {
		return telephoneList;
	}

	public static void removeTelephoneList() {
		telephoneList.remove(0);
	}

	public static void clearTelephoneList() {
		telephoneList.clear();
	}

	public static void addTelephoneList(String str) {
		telephoneList.add(str);
	}

	public static void setTelephoneList(List<String> telephoneList) {
		AutoAlarmProc.telephoneList = telephoneList;
	}

}
