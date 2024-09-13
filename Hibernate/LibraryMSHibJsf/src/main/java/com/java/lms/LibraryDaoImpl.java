package com.java.lms;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import org.hibernate.HibernateException;
import org.hibernate.Query;

@ManagedBean(name = "bookDao")
@SessionScoped
public class LibraryDaoImpl implements LibraryDAO {
	private String searchType;
	private String searchValue;

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}
	
	@Override
    public String searchBookDetailsDao(int id) {
		Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();		
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr= session.createCriteria(Books.class);
		cr.add(Restrictions.eq("id", id));
		List<Books> bList = cr.list();
		Books book = bList.get(0);
		sessionMap.put("editBook", book);
		return "UpdateBookDetails.xhtml?faces-redirect=true";
	}

	@Override
	public List<Books> searchBooks() throws HibernateException {

		if (searchType == null || searchValue == null) {
			return null;
		}
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Books.class);
		if (searchType.equals("id")) {
			cr.add(Restrictions.eq("id", Integer.parseInt(searchValue)));
		} else if (searchType.equals("bookname")) {
			cr.add(Restrictions.eq("name", searchValue));
		} else if (searchType.equals("authorname")) {
			cr.add(Restrictions.eq("author", searchValue));
		} else if (searchType.equals("dept")) {
			cr.add(Restrictions.eq("dept", searchValue));
		}else if (searchType.equals("all")) {
			cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		}
		List<Books> booksList = cr.list();
		session.close();
		return booksList;
	}
		
	
	@Override
	public String authenticate(Login login) {
		String encr = EntryptPassword.getCode(login.getPassCode());
		Map<String,Object> sessionMap = 
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();		
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Login.class);
		cr.add(Restrictions.eq("userName", login.getUserName()));
		cr.add(Restrictions.eq("passCode", encr.trim()));
		List<Login> loginList = cr.list();
		System.out.println("Records are " +loginList.size());
		if (loginList.size()==1) {
			return "ShowAgent.xhtml?faces-redirect=true";			
		} else {
			sessionMap.put("error", "Invalid Credentials...");
			return "Login.xhtml?faces-redirect=true";
		}
	}

	@Override
	public String validateMe(Login login) {
		String encr = EntryptPassword.getCode(login.getPassCode());
		Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();		
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Login.class);
		cr.add(Restrictions.eq("userName", login.getUserName()));
		cr.add(Restrictions.eq("passCode", encr.trim()));
		cr.setProjection(Projections.rowCount());
		long count =(Long)cr.uniqueResult();
		if (count==1) {
			return "Menu.xhtml?faces-redirect=true";			
		} else {
			sessionMap.put("error", "Invalid Credentials...");
			return "Login.xhtml?faces-redirect=true";
		}
	}
		
	@Override
	public String addUser(Login login) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		String encPwd = EntryptPassword.getCode(login.getPassCode());
		login.setPassCode(encPwd);
		Transaction t=session.beginTransaction();
        session.save(login);
        t.commit();
        System.out.println("Record Inserted...");
		return "Login.xhtml?faces-redirect=true";
	}
	
	@Override
	public String addBookDetailsDao(Books books)  {
		
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Transaction t=session.beginTransaction();
	    session.save(books);
	    t.commit();
	    System.out.println("Record Inserted...");
		return "BookShow.xhtml?faces-redirect=true";

	}
	
	@Override
	public String updateBookDetailsDao(Books bNew) {
			
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Transaction t=session.beginTransaction();
		session.update(bNew);
	    t.commit();
	    System.out.println("Record Updated...");
		return "BookShow.xhtml?faces-redirect=true";
	}

	@Override
	public String deleteBookDetailsDao(int id) {
		
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Query query = session.createQuery("from books where id="+id);
		List<Books> bList = query.list();
		if(bList.size()==0){
			System.out.println("Record not found..");
		}else{
			Books bk=bList.get(0);
			Transaction t=session.beginTransaction();
	        session.delete(bk);
	        t.commit();
			System.out.println("Record Deleted...");
		}
			return "BookShow.xhtml?faces-redirect=true";
	}
		  

}
