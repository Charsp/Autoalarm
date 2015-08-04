package com.swz.web.controllerinf;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.swz.data.vo.mysql.Info_blacklist;
import com.swz.data.vo.mysql.Info_sound;
import com.swz.data.vo.mysql.Info_user;
import com.swz.data.vo.mysql.Log_visit;
import com.swz.data.vo.mysql.Std_question;
import com.swz.data.vo.mysql.Std_questionpaper;
import com.swz.data.vo.mysql.Tr_question_paper;
import com.swz.voice.model.PageInfo;

public interface TransactionControllerinf {
	// 登录
	public Map<String, Object> login(HttpServletRequest request, Info_user user);

	// 更改用户信息
	public Map<String, Object> updae(HttpServletRequest request, Info_user user);

	// ************ 报表插入操作 ************ //
	/** 增加问题报表 **/
	public Map<String, Object> addQuestionpaper(HttpServletRequest request,
			Std_questionpaper questionpaper);

	/** 增加问题 **/
	public Map<String, Object> addQustion(HttpServletRequest request,
			Std_question question);

	/**
	 * 增加关系表 不依靠{@link #addQuestionpaper(HttpServletRequest, Std_questionpaper)}
	 * 和 {@link #addQustion(HttpServletRequest, Std_question)}
	 **/
	public Map<String, Object> addQuestionForpaper(HttpServletRequest request,
			Tr_question_paper question_paper);

	// ************ 报表查询操作 ************ //
	/** 查询所有报表 **/
	public Map<String, Object> queryQuestionpaper(HttpServletRequest request);

	/** 查询所有问题 **/
	public Map<String, Object> queryQuestion(HttpServletRequest request);

	// ************ 删除操作 ************ //
	/** 删除问卷 request 传递一个paper_id **/
	public Map<String, Object> delQuestionpaper(HttpServletRequest request);

	/** 删除一个问题 request 传递一个paper_id **/
	public Map<String, Object> delQuestion(HttpServletRequest request);

	/** 重指定问卷中移除一个问题 **/
	public Map<String, Object> delQuestionForpaper(HttpServletRequest request,
			Tr_question_paper question_paper);

	// ************ 语音操作 ************ //
	/** 增加语音信息 **/
	public Map<String, Object> addSound(HttpServletRequest request,
			Info_sound sound);

	/** 查询所有语音信息 **/
	public Map<String, Object> querySound(HttpServletRequest request);

	/** 删除指定语音 **/
	public Map<String, Object> delSound(HttpServletRequest request);

	/**
	 * 用户上传文件到服务器
	 * 
	 * @deprecated
	 **/
	public Integer uploadVoiceFile(HttpServletRequest request);

	// ************ 统计操作 ************ //
	/** 数据量大，估计得分页统计 tips: 不需要用户权限就可以查询 公开接口 **/
	public Map<String, Object> queryLog_visit(PageInfo pageInfo);

	/** 增加日志文档 返回为 integer的整型 0为成功 **/
	public Integer addLog_visit(Log_visit visit);

	// ************ 黑名单设置(电话) ************ //
	/** 增加黑名单 给个黑名结构就行 **/
	public Map<String, Object> addBlackList(HttpServletRequest request,
			Info_blacklist baBlacklist);

	/** 删除某一个黑名单电话 参数传递一个黑名单id值 **/
	public Map<String, Object> delBlackList(HttpServletRequest request);

	/** 查询所有黑名单信息 需要权限 **/
	public Map<String, Object> queryBlackList(HttpServletRequest request);

	// ************ 板卡信息状态 ************ //
	/** 查询板卡信息 **/
	public Map<String, Object> queryBoardInfo(HttpServletRequest request);
}
