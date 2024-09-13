package com.java.oyo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "billing")
public class Billing implements Serializable {

	   @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "BillID")
	    private String billId;
	  
	  
	    @Column(name = "BookID")
	    private String bookId;
	    
	  @Column(name = "RoomID")
	   private String roomId;
	  
	  @Column(name = "NoOfDays")
	   private int noOfDays;
	  
	  @Column(name = "BillAmt")
	   private int billAmt;

	public String getBillId() {
		return billId;
	}

	public void setBillId(String billId) {
		this.billId = billId;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public int getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}

	public int getBillAmt() {
		return billAmt;
	}

	public void setBillAmt(int billAmt) {
		this.billAmt = billAmt;
	}

	@Override
	public String toString() {
		return "Billing [billId=" + billId + ", bookId=" + bookId + ", roomId=" + roomId + ", noOfDays=" + noOfDays
				+ ", billAmt=" + billAmt + "]";
	}

	  
	  

	
}
