package com.swz.voice.model;

import java.util.List;

public class RecAlarmSetting {
	private Integer teamHandle;
	private Integer timeSpace;
	private Integer alarmSoundID;
	private Integer confirmSoundID;
	private List<String> alarmStyle;

	public Integer getTeamHandle() {
		return teamHandle;
	}

	public void setTeamHandle(Integer teamHandle) {
		this.teamHandle = teamHandle;
	}

	public Integer getTimeSpace() {
		return timeSpace;
	}

	public void setTimeSpace(Integer timeSpace) {
		this.timeSpace = timeSpace;
	}

	public Integer getAlarmSoundID() {
		return alarmSoundID;
	}

	public void setAlarmSoundID(Integer alarmSoundID) {
		this.alarmSoundID = alarmSoundID;
	}

	public Integer getConfirmSoundID() {
		return confirmSoundID;
	}

	public void setConfirmSoundID(Integer confirmSoundID) {
		this.confirmSoundID = confirmSoundID;
	}

	public List<String> getAlarmStyle() {
		return alarmStyle;
	}

	public void setAlarmStyle(List<String> alarmStyle) {
		this.alarmStyle = alarmStyle;
	}

	@Override
	public String toString() {

		return "{teamHandle:" + teamHandle + ",alarmStyle:" + alarmStyle + "}";
	}
}
