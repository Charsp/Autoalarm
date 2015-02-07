package com.swz.data.vo.mysql;

public class Info_user{
	private Integer user_id;
	private String user_num;
	private String password;
	private String user_name;
	private Byte isdelete;

	public void setUser_id(Integer user_id){
		this.user_id = user_id;
	}
	public Integer getUser_id(){
		return user_id;
	}
	public void setUser_num(String user_num){
		this.user_num = user_num;
	}
	public String getUser_num(){
		return user_num;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public String getPassword(){
		return password;
	}
	public void setUser_name(String user_name){
		this.user_name = user_name;
	}
	public String getUser_name(){
		return user_name;
	}
	public void setIsdelete(Byte isdelete){
		this.isdelete = isdelete;
	}
	public Byte getIsdelete(){
		return isdelete;
	}

	@Override	
	public String toString() {	
		return "{"+"\"user_id\":\""+this.user_id+"\""+",\"user_num\":\""+this.user_num+"\""+",\"password\":\""+this.password+"\""+",\"user_name\":\""+this.user_name+"\""+",\"isdelete\":\""+this.isdelete+"\""+"}";	}
}

