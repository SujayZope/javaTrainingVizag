package com.Medical_Entry;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ManagedBean(name="item_name")
@SessionScoped
@Entity
@Table(name="stock")
public class Item_Stock {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="itemId")
	private int stock_id;
	
	@Column(name="itemName")
	private String item_name;
	
	@Column(name="price")
	private double price;
	
	@Column(name="expiryDate")
	private Date expdate;
	
	@Column(name="quantity")
	private int quant;
	
	

	public int getStock_id() {
		return stock_id;
	}

	public void setStock_id(int stock_id) {
		this.stock_id = stock_id;
	}

	public int getQuant() {
		return quant;
	}

	public void setQuant(int quant) {
		this.quant = quant;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getExpdate() {
		return expdate;
	}

	public void setExpdate(Date expdate) {
		this.expdate = expdate;
	}

	@Override
	public String toString() {
		return "Item_Stock [item_nam=" + item_name + ", price=" + price + ", expdate=" + expdate + "]";
	}
	
	

}
