package com.java.ejb;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="booking")
public class Booking implements Serializable {
	
	@Id
	@Column(name="BookId")
	private String BookId;
	
	@Column(name="RoomID")
	private String RoomID;
	
	@Column(name="CustName")
	private String CustName;
	
	@Column(name="City")
	private String City;
	
	@Column(name="BookDate")
	private Date BookDate;
	
	@Column(name="ChkInDate")
	private Date ChkInDate;
	
	@Column(name="ChkOutDate")
	private Date ChkOutDate;

	public String getBookId() {
		return BookId;
	}

	public void setBookId(String bookId) {
		BookId = bookId;
	}

	public String getRoomID() {
		return RoomID;
	}

	public void setRoomID(String roomID) {
		RoomID = roomID;
	}

	public String getCustName() {
		return CustName;
	}

	public void setCustName(String custName) {
		CustName = custName;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public Date getBookDate() {
		return BookDate;
	}

	public void setBookDate(Date bookDate) {
		BookDate = bookDate;
	}

	public Date getChkInDate() {
		return ChkInDate;
	}

	public void setChkInDate(Date chkInDate) {
		ChkInDate = chkInDate;
	}

	public Date getChkOutDate() {
		return ChkOutDate;
	}

	public void setChkOutDate(Date chkOutDate) {
		ChkOutDate = chkOutDate;
	}

	@Override
	public String toString() {
		return "Booking [BookId=" + BookId + ", RoomID=" + RoomID + ", CustName=" + CustName + ", City=" + City
				+ ", BookDate=" + BookDate + ", ChkInDate=" + ChkInDate + ", ChkOutDate=" + ChkOutDate + "]";
	}
	
	
	
	
	

}
