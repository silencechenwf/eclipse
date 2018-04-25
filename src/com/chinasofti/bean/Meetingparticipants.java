package com.chinasofti.bean;

public class Meetingparticipants {
	private Integer meetingId;
	private Integer employeeId;
	public Integer getMeetingId() {
		return meetingId;
	}
	public void setMeetingId(Integer meetingId) {
		this.meetingId = meetingId;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public Meetingparticipants(Integer meetingId, Integer employeeId) {
		super();
		this.meetingId = meetingId;
		this.employeeId = employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	@Override
	public String toString() {
		return "Meetingparticipants [meetingId=" + meetingId + ", employeeId=" + employeeId + "]";
	}
	public Meetingparticipants() {
		super();
		// TODO Auto-generated constructor stub
	}
}
