package com.swz.voice.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.swz.data.vo.mysql.Info_blacklist;
import com.swz.data.vo.mysql.Info_sound;
import com.swz.data.vo.mysql.Info_user;
import com.swz.data.vo.mysql.Log_visit;
import com.swz.data.vo.mysql.Std_question;
import com.swz.data.vo.mysql.Std_questionpaper;
import com.swz.data.vo.mysql.Tr_question_paper;
import com.swz.voice.daoinf.BlackList;
import com.swz.voice.daoinf.Questionpaper;
import com.swz.voice.daoinf.QustionRelation;
import com.swz.voice.daoinf.SoundDaoInf;
import com.swz.voice.daoinf.UserDaoInf;
import com.swz.voice.daoinf.VisitDaoInf;
import com.swz.voice.model.PageInfo;
import com.swz.voice.model.VisitInfo;

@Repository
public class ClientVisitDao extends BaseOperateDao implements UserDaoInf,
		BlackList, Questionpaper, QustionRelation, SoundDaoInf, VisitDaoInf {

	@Override
	public Info_user findById(Long id) {
		return sessionTemplate.selectOne(MYBATIS_NAMESPACE_STRING
				+ ".queryinfo_user", id);
	}

	@Override
	public Integer findByUser(Info_user user) {
		return sessionTemplate.selectOne(MYBATIS_NAMESPACE_STRING + ".queryid",
				user);
	}

	@Override
	public List<Info_blacklist> queryBlacklists(PageInfo pageInfo) {
		return sessionTemplate.selectList(MYBATIS_NAMESPACE_STRING
				+ ".queryInfo_blacklist", pageInfo);
	}

	@Override
	public Long insertBlacklist(Info_blacklist blacklist) {
		return sessionTemplate.selectOne(MYBATIS_NAMESPACE_STRING
				+ ".queryinfo_user", blacklist);
	}

	@Override
	public Long deleteBlacklist(Info_blacklist blacklist) {
		return sessionTemplate.selectOne(MYBATIS_NAMESPACE_STRING
				+ ".queryinfo_user", blacklist);
	}

	@Override
	public List<Std_questionpaper> getQuestionpapers() {
		return sessionTemplate.selectList(MYBATIS_NAMESPACE_STRING
				+ ".select_questionpaper");
	}

	@Override
	public List<Std_question> getQuestionsByQuery_id(Integer id) {
		// 有可能有id有可能没有id的值
		return sessionTemplate.selectList(MYBATIS_NAMESPACE_STRING
				+ ".select_question_paperid", id);
	}

	@Override
	public List<Std_question> getQuestions() {
		return sessionTemplate.selectList(MYBATIS_NAMESPACE_STRING
				+ ".select_question");
	}

	@Override
	public Integer saveQuestion(Std_question question) {
		return sessionTemplate.insert(MYBATIS_NAMESPACE_STRING
				+ ".insert_question", question);
	}

	@Override
	public Integer delQuestion(Integer id) {
		return sessionTemplate.selectOne(MYBATIS_NAMESPACE_STRING
				+ ".select_question_paperid", id);
	}

	@Override
	public Integer saveQuestionpaper(Std_questionpaper questionpaper) {
		sessionTemplate.insert(MYBATIS_NAMESPACE_STRING
				+ ".insert_questionpaper", questionpaper);
		return questionpaper.getPaper_id();
	}

	@Override
	public Integer delQuestionpaper(Integer id) {
		return sessionTemplate.selectOne(MYBATIS_NAMESPACE_STRING
				+ ".select_question_paperid", id);
	}

	@Override
	public Integer saveQuestion_paper(Tr_question_paper question_paper) {
		return sessionTemplate.insert(MYBATIS_NAMESPACE_STRING
				+ ".insert_questionrelation", question_paper);
	}

	@Override
	public Integer delQustionRelation(Tr_question_paper question_paper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer saveVoiceFile(Info_sound sound) {
		return sessionTemplate.insert(MYBATIS_NAMESPACE_STRING
				+ ".insert_sound", sound);
	}

	@Override
	public List<Info_sound> queryVoiceFiles() {
		return sessionTemplate.selectList(MYBATIS_NAMESPACE_STRING
				+ ".select_sound");
	}

	@Override
	public Info_sound queryVoicebyID(Integer id) {
		return sessionTemplate.selectOne(MYBATIS_NAMESPACE_STRING
				+ ".select_sound_id", id);
	}

	@Override
	public Integer delVoiceFile(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer saveVisit(Log_visit visit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Log_visit> getVisits(PageInfo pageInfo) {
		return sessionTemplate.selectList(MYBATIS_NAMESPACE_STRING
				+ ".select_visit");
	}

	@Override
	public Integer updateQuestionpaper(Std_questionpaper questionpaper) {
		return sessionTemplate.update(MYBATIS_NAMESPACE_STRING
				+ ".update_paper", questionpaper);
	}

	@Override
	public Integer updateQuestion(Std_question question) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer setDefaultPaper(Integer id) {
		// 删除之前默认id
		sessionTemplate.update(MYBATIS_NAMESPACE_STRING
				+ ".update_paper_cleardefault");

		return sessionTemplate.update(MYBATIS_NAMESPACE_STRING
				+ ".update_paper_default", id);
	}

	public List<VisitInfo> getVisitInfos(Integer id) {
		return sessionTemplate.selectOne(MYBATIS_NAMESPACE_STRING
				+ ".select_paper_default", id);
	}

}