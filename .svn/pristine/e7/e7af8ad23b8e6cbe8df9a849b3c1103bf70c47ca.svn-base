package com.swz.voice.daoinf;

import java.util.List;

import com.swz.data.vo.mysql.Std_question;
import com.swz.data.vo.mysql.Tr_question_paper;

/**
 * 问卷和问题的关系表
 * 
 * @author Charsp
 *
 * @date 2015年1月27日
 */
public interface QustionRelation {

	/** 按照问卷id获取其问题设置 **/
	public List<Std_question> getQuestionsByQuery_id(Integer id);

	/** 唯一连接键 关系表 question_paper question_id 和question_paper_id **/
	public Integer saveQuestion_paper(Tr_question_paper question_paper);

	/** 删除 问卷-问题 关系 **/
	public Integer delQustionRelation(Tr_question_paper question_paper);  
}
