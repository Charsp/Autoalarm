package com.swz.data.vo.mysql;

public class Std_questionpaper{
	private Integer paper_id;
	private String paper_name;
	private Integer create_user;
	private Byte isdefault;
	private Byte isdelete;
	private String remark;

	public void setPaper_id(Integer paper_id){
		this.paper_id = paper_id;
	}
	public Integer getPaper_id(){
		return paper_id;
	}
	public void setPaper_name(String paper_name){
		this.paper_name = paper_name;
	}
	public String getPaper_name(){
		return paper_name;
	}
	public void setCreate_user(Integer create_user){
		this.create_user = create_user;
	}
	public Integer getCreate_user(){
		return create_user;
	}
	public void setIsdefault(Byte isdefault){
		this.isdefault = isdefault;
	}
	public Byte getIsdefault(){
		return isdefault;
	}
	public void setIsdelete(Byte isdelete){
		this.isdelete = isdelete;
	}
	public Byte getIsdelete(){
		return isdelete;
	}
	public void setRemark(String remark){
		this.remark = remark;
	}
	public String getRemark(){
		return remark;
	}

	@Override	
	public String toString() {	
		return "{"+"\"paper_id\":\""+this.paper_id+"\""+",\"paper_name\":\""+this.paper_name+"\""+",\"create_user\":\""+this.create_user+"\""+",\"isdefault\":\""+this.isdefault+"\""+",\"isdelete\":\""+this.isdelete+"\""+",\"remark\":\""+this.remark+"\""+"}";	}
}

