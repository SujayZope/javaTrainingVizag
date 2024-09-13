package com.java.stock;

import java.util.Date;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.persistence.UniqueConstraint;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Distinct;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import infinite.HealthPharmacy.Pharmacy;
import infinite.HealthPharmacy.SessionHelper;
import infinite.HealthPharmacy.Stock;

@ManagedBean(name = "sDao")
@SessionScoped
public class StockDAOImpl implements StockDAO {
	Date today= new Date();

	private String localCode;

	public String getLocalCode() {
		return localCode;
	}

	public void setLocalCode(String localCode) {
		this.localCode = localCode;
	}

	public void searchSelect(ValueChangeEvent e) {
		this.localCode = (String) e.getNewValue();
		
	}

	private int pharmId;
	
	public int getPharmId() {
		return pharmId;
	}

	public void setPharmId(int pharmId) {
		this.pharmId = pharmId;
	}

	public void pharmaIdIdLocaleCodeChanged(ValueChangeEvent e){
		String pharmName = e.getNewValue().toString();
		setLocalCode(pharmName);
		System.out.println("....."+pharmName);
		int pharmId = searchpharmaIdByName(pharmName);
		setPharmId(pharmId);
		System.out.println("localCode"+getPharmId());
		
		}
	// -------------------SHOW-STOCK-------------------------
	@Override
	public List<Stock> showStock() {
		// TODO Auto-generated method stub
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Stock.class);
		List<Stock> stockList = cr.list();
		return stockList;
	}

	// ----------------------------ADD-STOCK----------------------
	@Override
	public String addStock(Stock stock,int pharmaid) {
		
		// TODO Auto-generated method stub
		stock.setPharmId(pharmaid);
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cri = session.createCriteria(Stock.class);
		cri.add(Restrictions.eq("itemName", stock.getItemName()));
		cri.add(Restrictions.eq("price", stock.getPrice()));
		cri.add(Restrictions.eq("mfgDate", stock.getMfgDate()));
		cri.add(Restrictions.eq("expiryDate", stock.getExpiryDate()));
		cri.add(Restrictions.eq("vendor", stock.getVendor()));
		cri.add(Restrictions.eq("pharmId", stock.getPharmId()));

		List<Stock> stockLst = cri.list();
		if(stockLst.size()==0){
System.out.println("adding..");
		Transaction trans = session.beginTransaction();
		session.save(stock);
		trans.commit();}
		else{
			
			Stock st= stockLst.get(0);
			st.setQuantity(st.getQuantity()+stock.getQuantity());			;
			
			System.out.println("updating...");
			Transaction trans = session.beginTransaction();
			session.update(st);
			trans.commit();
		}
		return "ShowStock.xhtml?faces-redirect=true";
	}

	// -------------------SEARCH BY PHARMACY NAMES-------------------
	@Override
	public List<Stock> searchPharmName(String value) {
		SessionFactory sfactory = SessionHelper.getConnection();
		Session session = sfactory.openSession();
		Criteria cri = session.createCriteria(Stock.class);
		cri.add(Restrictions.eq("pharmName", value));
		// cri.add(Restrictions.eq("itemName", value));
		List<Stock> stockList = cri.list();
		return stockList;
	}

	@Override
	public Stock searchStock(int itemId) {
		// Map<String, Object> sessionMap =
		// FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Stock.class);
		cr.add(Restrictions.eq("itemId", itemId));
		// Stock record = (Stock) cr.uniqueResult();
		Stock stock = (Stock) cr.uniqueResult();

		// sessionMap.put("stock", record);
		return stock;
	}

	// -----------------UPDATE AND DELETE-----------------
	@Override
	public String updateStock(Stock stock) {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		session.update(stock);
		trans.commit();
		sessionMap.put("pharmacyInfo", stock);

		return "ShowStock.xhtml?faces-redirect=true";
	}

	public String actionOnUpdate(int itemId) {
		// System.out.println("item id =" + itemId);
		Stock stockFound = searchStock(itemId);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("pharmacyInfo", stockFound);
		// System.out.println(stockFound);
		// System.out.println(e.getExpiryDate()+" exp ");
		// System.out.println(e.getMfgDate()+" mfg");

		return "UpdateStock.xhtml?faces-redirect=true";
	}

	@Override
	public String deleteStock(Stock stock) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Stock.class);
		Transaction trans = session.beginTransaction();
		session.delete(stock);
		trans.commit();
		return "SearchItem.xhtml?faces-redirect=true";
	}

	// -----------DROP-DOWN FOR ITEMS--------------------
	@Override
	public List<String> getitemNames() {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Stock.class);
		// Projection projection = Projections.property("itemName");
		// TO AVOID REPEATED VALUES WE USE DISTINCT
		Projection projection = Projections.distinct(Property.forName("itemName"));
		cr.setProjection(projection);
		List<String> list = cr.list();
		System.out.println("items  " + list);
		return list;
	}
	@Override
	public List<Stock> getPharmacyNames() {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Stock.class);
		// Projection projection = Projections.property("itemName");
		// TO AVOID REPEATED VALUES WE USE DISTINCT
		Projection projection = Projections.distinct(Property.forName("pharmName"));
		cr.setProjection(projection);
		List<Stock> list = cr.list();
		System.out.println("items  " + list);
		return list;
	}
	// -------Expiry-Date & stock for getting alert-------------

	public int expiryDays(Date exp, Date mfg) {

		try {
			System.out.println("expiry date=" + exp);
			System.out.println("mfg date =" + mfg);
			long diff = exp.getTime() - mfg.getTime();
			long diff2 = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
			System.out.println("difference" + diff2);
			// int count =(int) diff/(60*1000*24);
			// int count =(int) diff/(60*60*1000*24);

			if (diff2 < 180) {
				return 1;
			} else
				return 0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int quantity(int quantity) {
		if (quantity <= 150) {
			// System.out.println("stock is going to finish");
			return 1;
		} else {
			// System.out.println("Available");
			return 0;
		}
	}

	@Override
	public int searchpharmaIdByName(String pharmaName) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Pharmacy.class);
		cr.add(Restrictions.eq("pharmaName", pharmaName));
		Projection projection = Projections.distinct(Property.forName("pharmaId"));
		cr.setProjection(projection);
		int pharmaid = (int)cr.uniqueResult();
		System.out.println("method " +pharmaid);
		System.out.println("hii");
		return pharmaid;
		
	
		
	}
//====================================================================
	
	@Override
	public String findPharmacyName(int pharmaId) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Pharmacy.class);
		cr.add(Restrictions.eq("pharmaId", pharmaId));
		Projection projection = Projections.property("pharmaName");
		cr.setProjection(projection);
		String name = (String) cr.uniqueResult();
		System.out.println("method " + name);
		return name;
	}

	@Override
	public List<String> getPharmacyName() {
SessionFactory sf = SessionHelper.getConnection();
Session session = sf.openSession();
Criteria cr = session.createCriteria(Pharmacy.class);
Projection projection = Projections.distinct(Property.forName("pharmaName"));
cr.setProjection(projection);
List<String> list = cr.list();
System.out.println("name" +list);
		return list;
	}

	
}
