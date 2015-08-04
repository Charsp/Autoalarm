package com.swz.voice.model;

import java.util.Date;
import java.util.List;

public class PaperResult {
	/**
	 * 问卷id
	 */
	private Integer paper_id;
	/**
	 * 用户电话
	 */
	private String userPhone;
	/**
	 * 用户名称
	 */
	private String userName;
	/**
	 * 用户回答总数
	 */
	private Integer answerResult;
	/**
	 * 开始时间
	 */
	private Date startDate;
	/**
	 * 问题结果集
	 */
	private List<QuestionResult> questionResults;

	public Integer getPaper_id() {
		return paper_id;
	}

	public void setPaper_id(Integer paper_id) {
		this.paper_id = paper_id;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getAnswerResult() {
		return answerResult;
	}

	public void setAnswerResult(Integer answerResult) {
		this.answerResult = answerResult;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public List<QuestionResult> getQuestionResults() {
		return questionResults;
	}

	public void setQuestionResults(List<QuestionResult> questionResults) {
		this.questionResults = questionResults;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
