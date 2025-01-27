package com.java.oyo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "booking")
public class Booking implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	   
    @Id
    @Column(name = "BookId")
    private String bookId;
    
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

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getBookDate() {
		return bookDate;
	}

	public void setBookDate(Date bookDate) {
		this.bookDate = bookDate;
	}

	public Date getCheckinDate() {
		return checkinDate;
	}

	public void setCheckinDate(Date checkinDate) {
		this.checkinDate = checkinDate;
	}

	public Date getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

@Column(name = "RoomID")
   private String roomId;

   @Column(name = "CustName")
   private String customerName ;

   @Column(name = "City")
   private String city;

   @Column(name = "BookDate")
   private Date bookDate;

   @Column(name = "ChkInDate")
   private Date checkinDate;
   
   @Column(name = "ChkOutDate")
   private Date checkoutDate;

@Override
public String toString() {
	return "Booking [bookId=" + bookId + ", roomId=" + roomId + ", customerName=" + customerName + ", city=" + city
			+ ", bookDate=" + bookDate + ", checkinDate=" + checkinDate + ", checkoutDate=" + checkoutDate + "]";
}
   
   
	

}
