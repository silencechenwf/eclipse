package com.chinasofti.bean;

import java.sql.Date;

public class Meeting {
	private Integer meetingId;
	private String meetingName;
	private Integer roomId;
	private Integer reservationistId;
	private Integer numberOfParticipants;
	private Date startTime;
	private Date endTime;
	private Date reservationTime;
	private Date canceledTime;
	private String description;
	private String status;
	private String roomName;
	public Meeting() {
		super();
	}
	public Meeting(Integer meetingId, String meetingName, Integer roomId, Integer reservationistId,
			Integer numberOfParticipants, Date startTime, Date endTime, Date reservationTime, Date canceledTime,
			String description, String status, String roomName) {
		super();
		this.meetingId = meetingId;
		this.meetingName = meetingName;
		this.roomId = roomId;
		this.reservationistId = reservationistId;
		this.numberOfParticipants = numberOfParticipants;
		this.startTime = startTime;
		this.endTime = endTime;
		this.reservationTime = reservationTime;
		this.canceledTime = canceledTime;
		this.description = description;
		this.status = status;
		this.roomName = roomName;
	}
	public Integer getMeetingId() {
		return meetingId;
	}
	public void setMeetingId(Integer meetingId) {
		this.meetingId = meetingId;
	}
	public String getMeetingName() {
		return meetingName;
	}
	public void setMeetingName(String meetingName) {
		this.meetingName = meetingName;
	}
	public Integer getRoomId() {
		return roomId;
	}
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
	public Integer getReservationistId() {
		return reservationistId;
	}
	public void setReservationistId(Integer reservationistId) {
		this.reservationistId = reservationistId;
	}
	public Integer getNumberOfParticipants() {
		return numberOfParticipants;
	}
	public void setNumberOfParticipants(Integer numberOfParticipants) {
		this.numberOfParticipants = numberOfParticipants;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Date getReservationTime() {
		return reservationTime;
	}
	public void setReservationTime(Date reservationTime) {
		this.reservationTime = reservationTime;
	}
	public Date getCanceledTime() {
		return canceledTime;
	}
	public void setCanceledTime(Date canceledTime) {
		this.canceledTime = canceledTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	@Override
	public String toString() {
		return "Meeting [meetingId=" + meetingId + ", meetingName=" + meetingName + ", roomId=" + roomId
				+ ", reservationistId=" + reservationistId + ", numberOfParticipants=" + numberOfParticipants
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", reservationTime=" + reservationTime
				+ ", canceledTime=" + canceledTime + ", description=" + description + ", status=" + status
				+ ", roomName=" + roomName + "]";
	}
	
}
