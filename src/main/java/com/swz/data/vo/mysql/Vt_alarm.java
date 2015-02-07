package com.swz.data.vo.mysql;

import java.util.Date;

public class Vt_alarm{
	private Integer id;
	private Date count_date;
	private Integer alarm_total;
	private Integer call_total;
	private Integer call_out;
	private Integer alarm_cancel;
	private Integer alarm_1;
	private Integer alarm_2;
	private Integer alarm_3;
	private Integer alarm_4;
	private Integer alarm_5;
	private Integer alarm_6;
	private Integer alarm_7;
	private Integer alarm_8;

	public void setId(Integer id){
		this.id = id;
	}
	public Integer getId(){
		return id;
	}
	public void setCount_date(Date count_date){
		this.count_date = count_date;
	}
	public Date getCount_date(){
		return count_date;
	}
	public void setAlarm_total(Integer alarm_total){
		this.alarm_total = alarm_total;
	}
	public Integer getAlarm_total(){
		return alarm_total;
	}
	public void setCall_total(Integer call_total){
		this.call_total = call_total;
	}
	public Integer getCall_total(){
		return call_total;
	}
	public void setCall_out(Integer call_out){
		this.call_out = call_out;
	}
	public Integer getCall_out(){
		return call_out;
	}
	public void setAlarm_cancel(Integer alarm_cancel){
		this.alarm_cancel = alarm_cancel;
	}
	public Integer getAlarm_cancel(){
		return alarm_cancel;
	}
	public void setAlarm_1(Integer alarm_1){
		this.alarm_1 = alarm_1;
	}
	public Integer getAlarm_1(){
		return alarm_1;
	}
	public void setAlarm_2(Integer alarm_2){
		this.alarm_2 = alarm_2;
	}
	public Integer getAlarm_2(){
		return alarm_2;
	}
	public void setAlarm_3(Integer alarm_3){
		this.alarm_3 = alarm_3;
	}
	public Integer getAlarm_3(){
		return alarm_3;
	}
	public void setAlarm_4(Integer alarm_4){
		this.alarm_4 = alarm_4;
	}
	public Integer getAlarm_4(){
		return alarm_4;
	}
	public void setAlarm_5(Integer alarm_5){
		this.alarm_5 = alarm_5;
	}
	public Integer getAlarm_5(){
		return alarm_5;
	}
	public void setAlarm_6(Integer alarm_6){
		this.alarm_6 = alarm_6;
	}
	public Integer getAlarm_6(){
		return alarm_6;
	}
	public void setAlarm_7(Integer alarm_7){
		this.alarm_7 = alarm_7;
	}
	public Integer getAlarm_7(){
		return alarm_7;
	}
	public void setAlarm_8(Integer alarm_8){
		this.alarm_8 = alarm_8;
	}
	public Integer getAlarm_8(){
		return alarm_8;
	}

	@Override	
	public String toString() {	
		return "{"+"\"id\":\""+this.id+"\""+",\"count_date\":\""+this.count_date+"\""+",\"alarm_total\":\""+this.alarm_total+"\""+",\"call_total\":\""+this.call_total+"\""+",\"call_out\":\""+this.call_out+"\""+",\"alarm_cancel\":\""+this.alarm_cancel+"\""+",\"alarm_1\":\""+this.alarm_1+"\""+",\"alarm_2\":\""+this.alarm_2+"\""+",\"alarm_3\":\""+this.alarm_3+"\""+",\"alarm_4\":\""+this.alarm_4+"\""+",\"alarm_5\":\""+this.alarm_5+"\""+",\"alarm_6\":\""+this.alarm_6+"\""+",\"alarm_7\":\""+this.alarm_7+"\""+",\"alarm_8\":\""+this.alarm_8+"\""+"}";	}
}

