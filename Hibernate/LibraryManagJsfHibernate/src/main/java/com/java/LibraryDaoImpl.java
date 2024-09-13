package com.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;


@ManagedBean(name="dao")
@SessionScoped
public class LibraryDaoImpl implements LibraryDao{

	
	// Use criteria for show , search and update
	
	
	// Login 
	
	@Override
	public String validateMe(LibUsers libusers) {
		
        String encr = EntryptPassword.getCode(libusers.getPassWord());
		
		Map<String,Object> sessionMap = 
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();		
		
		
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		
		Criteria cr = session.createCriteria(Books.class);
		
		cr.add(Restrictions.eq("userName", libusers.getUserName()));
		cr.add(Restrictions.eqOrIsNull("passWord", encr.trim()));
		
		cr.setProjection(Projections.rowCount());
		long  count =(Long)cr.uniqueResult();
		
		if(count==1)
		{
			return "Menu.xhtml ? faces-redirect = true";
		}
		else
		{
			sessionMap.put("error", "Inavlid Credentials");
			return "Register.xhtml ? faces-redirect = true"; 
		}
	}
	
	
	
	public List<Books> searchBook(String searchType , String searchValue)
	{
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr  = session.createCriteria(Books.class);
		List<Books> booklist = null;
		
		if(searchType.equals("Name"))
		{
			cr.add(Restrictions.eq("Name", searchValue));
			booklist = cr.list();
		}
		
		else if(searchType.equals("Author"))
		{
			cr.add(Restrictions.eq("Author", searchValue));
			booklist = cr.list();
		}
		
		else if(searchType.equals("Edition"))
		{
			cr.add(Restrictions.eq("Edition", searchValue));
			booklist = cr.list();
		}
		
		else if(searchType.equals("Dept")) 
		{    
            cr.add(Restrictions.eq("Dept", searchValue));
            booklist=cr.list();
        }
		
        else 
        {
            booklist=cr.list();
        }
		return booklist;	
	}
	
	
    // show Books
	
	@Override
	public List<Books> showBooksDao() {
		
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		
		Criteria cr = session.createCriteria(Books.class);
		
		List<Books> bookslist = cr.list();
		
		return bookslist;
	}
	
	
	private String localCode;

	public String getLocalCode() {
		return localCode;
	}

	public void setLocalCode(String localCode) {
		this.localCode = localCode;
	}
	
	public void agentLocaleCodeChanged(ValueChangeEvent e){
		//assign new value to localeCode
		this.localCode = e.getNewValue().toString();
	}



	@Override
	public String addUserDao(LibUsers libusers) {
	
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		
		String encr = EntryptPassword.getCode(libusers.getPassWord()); // For Encrypting password in database
		libusers.setPassWord(encr);
		
		Transaction t = session.beginTransaction();
		session.persist(libusers);
		t.commit();
		
		return "Thanks.xhtml ? faces-redirect = true";
	}
}
