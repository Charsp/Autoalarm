package com.swz.data.vo.mysql;

import java.util.Date;

public class Std_question{
	private Integer question_id;
	private String question;
	private String question_type;
	private Integer sound_id;
	private Integer create_user;
	private Byte isdelete;
	private Date updatetime;
	private String remark;

	public void setQuestion_id(Integer question_id){
		this.question_id = question_id;
	}
	public Integer getQuestion_id(){
		return question_id;
	}
	public void setQuestion(String question){
		this.question = question;
	}
	public String getQuestion(){
		return question;
	}
	public void setQuestion_type(String question_type){
		this.question_type = question_type;
	}
	public String getQuestion_type(){
		return question_type;
	}
	public void setSound_id(Integer sound_id){
		this.sound_id = sound_id;
	}
	public Integer getSound_id(){
		return sound_id;
	}
	public void setCreate_user(Integer create_user){
		this.create_user = create_user;
	}
	public Integer getCreate_user(){
		return create_user;
	}
	public void setIsdelete(Byte isdelete){
		this.isdelete = isdelete;
	}
	public Byte getIsdelete(){
		return isdelete;
	}
	public void setUpdatetime(Date updatetime){
		this.updatetime = updatetime;
	}
	public Date getUpdatetime(){
		return updatetime;
	}
	public void setRemark(String remark){
		this.remark = remark;
	}
	public String getRemark(){
		return remark;
	}

	@Override	
	public String toString() {	
		return "{"+"\"question_id\":\""+this.question_id+"\""+",\"question\":\""+this.question+"\""+",\"question_type\":\""+this.question_type+"\""+",\"sound_id\":\""+this.sound_id+"\""+",\"create_user\":\""+this.create_user+"\""+",\"isdelete\":\""+this.isdelete+"\""+",\"updatetime\":\""+this.updatetime+"\""+",\"remark\":\""+this.remark+"\""+"}";	}
}

