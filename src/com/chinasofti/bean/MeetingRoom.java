package com.chinasofti.bean;

public class MeetingRoom {
	private Integer roomId;
	private Integer roomNum;
	private String roomName;
	private Integer capacity;
	private String status;
	private String description;
	public MeetingRoom(Integer meetingId, Integer meetingNum, String meetingName, Integer capacity, String status,
			String description) {
		super();
		this.roomId = meetingId;
		this.roomNum = meetingNum;
		this.roomName = meetingName;
		this.capacity = capacity;
		this.status = status;
		this.description = description;
	}
	public MeetingRoom() {
		super();
	}
	public Integer getRoomId() {
		return roomId;
	}
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
	public Integer getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(Integer roomNum) {
		this.roomNum = roomNum;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
