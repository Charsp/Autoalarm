package com.swz.voice.daoinf;

import java.util.List;

import com.swz.data.vo.mysql.Std_question;
import com.swz.data.vo.mysql.Std_questionpaper;

public interface Questionpaper {
	// 问卷信息
	/**
	 * 查询所有问卷信息
	 * 
	 * @return
	 */
	public List<Std_questionpaper> getQuestionpapers();

	/**
	 * 增加问题表
	 * 
	 * @param questionpaper
	 *            问题表中paper_nam key 唯一 不能重复
	 * @return
	 */
	public Integer saveQuestionpaper(Std_questionpaper questionpaper);

	/**
	 * 更新现有问卷
	 * 
	 * @param questionpaper
	 * @return
	 */
	public Integer updateQuestionpaper(Std_questionpaper questionpaper);

	/**
	 * 删除请求表
	 * 
	 * @param id
	 * @return
	 */
	public Integer delQuestionpaper(Integer id);

	/**
	 * 获取所有问题
	 * 
	 * @return 获取所有问卷的问题
	 */
	public List<Std_question> getQuestions();

	/**
	 * 保存设置的问题
	 * 
	 * @return 所保存问题的id
	 */
	public Integer saveQuestion(Std_question question);

	/**
	 * 更新现有问题
	 * 
	 * @param question
	 * @return
	 */
	public Integer updateQuestion(Std_question question);

	/**
	 * 增加问题
	 * 
	 * @return 所增加问题的id
	 * 
	 */
	public Integer delQuestion(Integer id);

	/**
	 * 设置为默认回访问卷
	 * 
	 * @param id
	 * @return
	 */
	public Integer setDefaultPaper(Integer id);

	/**
	 * 获取默认paper_id
	 * 
	 * @return
	 */
	public Integer getDefaultPaper();
}
