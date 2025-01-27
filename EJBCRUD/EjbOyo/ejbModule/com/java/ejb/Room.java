package com.java.ejb;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="room")
public class Room implements Serializable {
	
	@Id
	@Column(name="RoomID")
	private String RoomID;
	
	@Column(name="Type")
	private String Type;
	
	@Enumerated(EnumType.STRING)
	@Column(name="Status")
	private RStatus Status;
	
	@Column(name="CostPerDay")
	private int CostPerDay;

	public String getRoomID() {
		return RoomID;
	}

	public void setRoomID(String roomID) {
		RoomID = roomID;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public RStatus getStatus() {
		return Status;
	}

	public void setStatus(RStatus status) {
		Status = status;
	}

	public int getCostPerDay() {
		return CostPerDay;
	}

	public void setCostPerDay(int costPerDay) {
		CostPerDay = costPerDay;
	}

	@Override
	public String toString() {
		return "Room [RoomID=" + RoomID + ", Type=" + Type + ", Status=" + Status + ", CostPerDay=" + CostPerDay + "]";
	}
	
	
	
	

}
