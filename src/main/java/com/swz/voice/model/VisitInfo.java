package com.swz.voice.model;

public class VisitInfo {
	private String question;
	private String question_type;
	private String sound_path;
	private String sound_name;

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getQuestion_type() {
		return question_type;
	}

	public void setQuestion_type(String question_type) {
		this.question_type = question_type;
	}

	public String getSound_path() {
		return sound_path;
	}

	public void setSound_path(String sound_path) {
		this.sound_path = sound_path;
	}

	public String getSound_name() {
		return sound_name;
	}

	public void setSound_name(String sound_name) {
		this.sound_name = sound_name;
	}

	// SELECT * FROM info_sound,std_question where info_sound.sound_id =
	// std_question.sound_id and std_question.question_id in (select question_id
	// from tr_question_paper where paper_id =7) order by question_id;
}
