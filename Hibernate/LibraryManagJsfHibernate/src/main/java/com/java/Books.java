package com.java;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@ManagedBean
@SessionScoped
@Entity
@Table(name="Books")
public class Books {

	@Id
	@Column(name="Id")
	
	private int Id;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getEdition() {
		return Edition;
	}
	public void setEdition(String edition) {
		Edition = edition;
	}
	public String getDept() {
		return Dept;
	}
	public void setDept(String dept) {
		Dept = dept;
	}
	public int getTotalBooks() {
		return TotalBooks;
	}
	public void setTotalBooks(int totalBooks) {
		TotalBooks = totalBooks;
	}
	
	private String Name;
	private String Author;
	private String Edition;
	private String  Dept;
	private int TotalBooks;
	@Override
	public String toString() {
		return "Books [Id=" + Id + ", Name=" + Name + ", Author=" + Author + ", Edition=" + Edition + ", Dept=" + Dept
				+ ", TotalBooks=" + TotalBooks + "]";
	}
}
