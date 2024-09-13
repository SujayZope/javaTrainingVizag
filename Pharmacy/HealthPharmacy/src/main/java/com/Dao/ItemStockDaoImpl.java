package com.Dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.Medical_Entry.Item_Stock;
import com.Medical_Entry.Medical;

import infinite.HealthPharmacy.SessionHelper;

@ManagedBean(name="stockImpl")
@SessionScoped
public class ItemStockDaoImpl implements ItemStockDao {
	
	private String localCode;
	private double itemprice;
	private Integer quantity;
	private Date itemExpDate;
	
	

	
	public Date getItemExpDate() {
		return itemExpDate;
	}

	public void setItemExpDate(Date itemExpDate) {
		this.itemExpDate = itemExpDate;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public double getItemprice() {
		return itemprice;
	}

	public void setItemprice(double itemprice) {
		this.itemprice = itemprice;
	}

	public String getLocalCode() {
		return localCode;
	}

	public void setLocalCode(String localCode) {
		this.localCode = localCode;
	}
	
	
	public void itemIdLocaleCodeChanged(ValueChangeEvent e){
//		Map<String,Object> sessionMap = 
//				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();		
		String rname = e.getNewValue().toString();
		
		setLocalCode(rname);
		
		Double price = searchpriceByName(rname);
		setItemprice(price);
		System.out.println("localcod"+getItemprice());
		
		Date expdt = searchExpDateByName(rname);
		setItemExpDate(expdt);
//		
	}
	
	public Double searchpriceByName(String itemName) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Item_Stock.class);
		cr.add(Restrictions.eq("item_name", itemName));

		Projection projection = Projections.property("price"); 
		cr.setProjection(projection); 
		Double price = (Double)cr.uniqueResult();
		System.out.println("method " +price);
		System.out.println("hii");
		return price;
	}
	
	public Date searchExpDateByName(String itemName){
		
		SessionFactory sfactory = SessionHelper.getConnection();
		Session session = sfactory.openSession();
		Criteria criteria = session.createCriteria(Item_Stock.class);
		criteria.add(Restrictions.eq("item_name", itemName));
		
		Projection projection = Projections.property("expdate");
		criteria.setProjection(projection);
		Date expdate = (Date)criteria.uniqueResult();
		
		return expdate;
	}

	public void updateQuantity(Medical med) {
		
		SessionFactory sfactory = SessionHelper.getConnection();
		Session session = sfactory.openSession();
		Criteria criteria = session.createCriteria(Item_Stock.class);
		criteria.add(Restrictions.eq("item_name", med.getMedicin_name()));
		
		
		
		Item_Stock item_stock = (Item_Stock) criteria.uniqueResult();
		int updateQuantity=item_stock.getQuant()-med.getQuantity();
		item_stock.setQuant(updateQuantity);
		
		System.out.println("Fromm Update Quantity Stock = "+ updateQuantity);
		
		Transaction trans = session.beginTransaction();
		session.update(item_stock);
		trans.commit();
		
	}
	
	
	public List<String> showMenuItemNames() {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Item_Stock.class);
//		cr.add(Restrictions.eq("stock_id", bid));
		Projection projection = Projections.property("item_name");
		cr.setProjection(projection);
		List<String> stList = cr.list();
		return stList;
	}
	
	public void quantityIdLocaleCodeChanged(ValueChangeEvent e){
//		Map<String,Object> sessionMap = 
//				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();		
		String stringquantity = e.getNewValue().toString();
		Integer quant=Integer.parseInt(stringquantity);
//		setQuantity();
		this.quantity=quant;
		System.out.println("quantity  ="+this.quantity);
		
//		
	}
	public double amountCalculate(){
		double amount = 0;
		try {
			
			if (this.itemprice != 0 && this.quantity != 0) {
				amount = getQuantity() * getItemprice();
				return amount;
			}
			return amount;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return amount;

	}
public int searchStockIdbyName(String itemName){
	SessionFactory sf = SessionHelper.getConnection();
	Session session = sf.openSession();
	Criteria cr = session.createCriteria(Item_Stock.class);
	cr.add(Restrictions.eq("item_name", itemName));

	Projection projection = Projections.property("stock_id"); 
	cr.setProjection(projection); 
	int stockid = (int)cr.uniqueResult();
	
	return stockid;
		
	}
	

}
