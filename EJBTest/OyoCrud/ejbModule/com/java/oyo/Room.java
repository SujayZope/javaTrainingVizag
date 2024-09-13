package com.java.oyo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "room")
public class Room implements Serializable{

	 @Override
	public String toString() {
		return "Room [roomId=" + roomId + ", Type=" + Type + ", status=" + status + ", costPerDay=" + costPerDay + "]";
	}

	private static final long serialVersionUID = 1L;
	   
	     @Id
	    @Column(name = "RoomID")
	    private String roomId;
	 
	    @Column(name = "Type")
	    private String Type ;
	 
	    @Column(name = "Status")
	    @Enumerated(EnumType.STRING)
	    private Status status;
	 
	    @Column(name = "CostPerDay")
	    private int costPerDay;

		public String getRoomId() {
			return roomId;
		}

		public void setRoomId(String roomId) {
			this.roomId = roomId;
		}

		public String getType() {
			return Type;
		}

		public void setType(String type) {
			Type = type;
		}

		public Status getStatus() {
			return status;
		}

		public void setStatus(Status status) {
			this.status = status;
		}

		public int getCostPerDay() {
			return costPerDay;
		}

		public void setCostPerDay(int costPerDay) {
			this.costPerDay = costPerDay;
		}	
	
	    
	
	
	
}
