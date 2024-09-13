package com.java.ejb;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="billing")
public class Billing implements Serializable {
	
	@Id
	@Column(name="BookID")
	private String BookID;
	
	@Column(name="RoomID")
	private String RoomID;
	
	@Column(name="NoOfDays")
	private int NoOfDays;
	
	@Column(name="BillAmt")
	private int BillAmt;

	public String getBookID() {
		return BookID;
	}

	public void setBookID(String bookID) {
		BookID = bookID;
	}

	public String getRoomID() {
		return RoomID;
	}

	public void setRoomID(String roomID) {
		RoomID = roomID;
	}

	public int getNoOfDays() {
		return NoOfDays;
	}

	public void setNoOfDays(int noOfDays) {
		NoOfDays = noOfDays;
	}

	public int getBillAmt() {
		return BillAmt;
	}

	public void setBillAmt(int billAmt) {
		BillAmt = billAmt;
	}

	@Override
	public String toString() {
		return "Billing [BookID=" + BookID + ", RoomID=" + RoomID + ", NoOfDays=" + NoOfDays + ", BillAmt=" + BillAmt
				+ "]";
	}
	
	
	
	

}
