package com.Dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.Medical_Entry.Medical_Bill;

import infinite.HealthPharmacy.SessionHelper;

import com.Medical_Entry.Item_Stock;
import com.Medical_Entry.Medical;


@ManagedBean(name="medicalImpl")
@SessionScoped
public class MedicalDaoImpl implements MedicalDao {
	
	private String localCode;
	private Integer billId;
	ArrayList<Medical> m1=new ArrayList<Medical>();
	private  double totalAmmount;
	
	
	Date date;
	

	public Date getDate() {
		return new Date() ;
	}


	public double getTotalAmmount() {
		return totalAmmount;
	}


	public void setTotalAmmount(double totalAmmount) {
		this.totalAmmount = totalAmmount;
	}


	public ArrayList<Medical> getM1() {
		return m1;
	}


	public void setM1(ArrayList<Medical> m1) {
		this.m1 = m1;
	}


	public Integer getBillId() {
		return billId;
	}


	public void setBillId(Integer billId) {
		this.billId = billId;
	}


	public String getLocalCode() {
		return localCode;
	}


	public void setLocalCode(String localCode) {
		this.localCode = localCode;
	}
	


	public void searchSelected(ValueChangeEvent e)
	{
		this.localCode = (String) e.getNewValue();
	}
	
	//**********************************************
	private String btchno;
	private Date expdt;
	
	
	
	public Date getExpdt() {
		return expdt;
	}


	public void setExpdt(Date expdt) {
		this.expdt = expdt;
	}


	public String getBtchno() {
		return btchno;
	}


	public void setBtchno(String btchno) {
		int bno = (int) (Math.random()*1000); //		String batchNo = generateBatchNo();
		String batchNo = "BN" + bno;
		this.btchno = batchNo;
	}

	public String getbtno()
	{
		int bno = (int) (Math.random()*1000); //		String batchNo = generateBatchNo();
		String batchNo = "BN" + bno;
		
		return batchNo;
	}

	@Override
	public String addMedicinSale(Medical medical,double price) {

		Map<String,Object> sessionMap = 
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		medical.setSale_date(new Date());
		
		/*int bno = (int) (Math.random()*1000); //		String batchNo = generateBatchNo();
		String batchNo = "BN" + bno;*/
		medical.setBatchno(getBtchno());
//		setBtchno(getbtno());
		
		medical.setHsn(3004);
		
		medical.setExpDate(getExpdt());
//		setExpdt(itemExpDate);
		
		medical.setPrice(price);
		medical.setAmount(this.totalAmmount);
		
		SessionFactory sfactory = SessionHelper.getConnection();
		Session session = sfactory.openSession();

		Transaction transaction = session.beginTransaction();
		session.save(medical);
		transaction.commit();
		sessionMap.put("medic", medical);
		
//		Bill b= new Bill();
	//	b.setStock_id(stock_id);
		// int i=0;
		ItemStockDaoImpl imp=new ItemStockDaoImpl();
		for (Medical medical2 : m1) {
			Medical_Bill b= new Medical_Bill();
			//b.setBill_no(i);
			int a=imp.searchStockIdbyName(medical2.getMedicin_name());
			System.out.println(a+"id..............");
			b.setStock_id(a);
			b.setQuantity(medical2.getQuantity());
			b.setBatchno(medical2.getBatchno());
			b.setPatientid(medical.getPatientid());
			b.setHsn(3004);
			b.setHospital_name(medical.getHospital_id());
			b.setMedical_name(medical.getMedical_id());
			b.setSale_date(new Date());
			b.setExpdate(medical2.getExpDate());
			b.setAmount(medical2.getAmount());
			
			SessionFactory sfactory2 = SessionHelper.getConnection();
			Session session2 = sfactory2.openSession();

			Transaction transaction2= session2.beginTransaction();
			session2.save(b);
			transaction2.commit();
			//i++;
			
		}

		return "Medical_Bill.xhtml?faces-redirect=true";
	}
	
	
	//***************************************************************************************

	//***************************************************************************************



	public List<Medical> getDrid() {
		
		SessionFactory sfactory = SessionHelper.getConnection();
		Session session = sfactory.openSession();
		
		Criteria criteria = session.createCriteria(Medical.class);
		Projection projection = Projections.distinct(Property.forName("dr_id"));
//		Projection projection = Projections.property("dr_id");  //Instead of Projection we can use Query
		
		criteria.setProjection(projection);
		
		List<Medical> drList = criteria.list();
		
		return drList;
	}
	
	public List<Item_Stock> getItemNam() {
		
		SessionFactory sfactory = SessionHelper.getConnection();
		Session session = sfactory.openSession();
		
		Criteria criteria = session.createCriteria(Item_Stock.class); //countDistinct("medicin_name");
		Projection projection = Projections.distinct(Property.forName("item_name"));
		
//		Projection projection = Projections.property("item_nam");
		criteria.setProjection(projection);
		List<Item_Stock> itemList = criteria.list();
		
		return itemList;
	}


	@Override
	public List<Medical> showtBill() {
		
		SessionFactory sfactory = SessionHelper.getConnection();
		Session session = sfactory.openSession();
		
		Criteria criteria = session.createCriteria(Medical.class);
		
		List<Medical> medicaList = criteria.list();
		
		return medicaList;
	}
	
	public List<Item_Stock> showStock(){
		
		SessionFactory sfactory = SessionHelper.getConnection();
		Session session = sfactory.openSession();
		
		Criteria criteria = session.createCriteria(Item_Stock.class);
		
		List<Item_Stock> stockList = criteria.list();
		
		return stockList;
	}
	


	@Override
	public List<Medical> serachBillByPID(String value) {
		SessionFactory sfactory = SessionHelper.getConnection();
		Session session = sfactory.openSession();
		
		Criteria criteria = session.createCriteria(Medical.class);
		criteria.add(Restrictions.eq("patientid",value));
		List<Medical> medicaList = criteria.list();
		
		return medicaList;
	}


	@Override
	public List<Medical> searchByMedicalId(String medicalId) {
		
		SessionFactory sfactory = SessionHelper.getConnection();
		Session session = sfactory.openSession();
		
		Criteria criteria = session.createCriteria(Medical.class);
		criteria.add(Restrictions.eq("medical_id", medicalId));
		List<Medical> medicalList = criteria.list();
		
		return medicalList;
	}


	@Override
	public List<Medical> searchByHospitalId(String hospitalId) {
		
		SessionFactory sfactory = SessionHelper.getConnection();
		Session session = sfactory.openSession();
		
		Criteria criteria = session.createCriteria(Medical.class);
		criteria.add(Restrictions.eq("hospital_id", hospitalId));
		List<Medical> hospitalList = criteria.list();
		
		return hospitalList;
		
	}
	
	public String addToCart(Medical medical,double price, Date itemExpDate){
//		Map<String,Object> sessionMap = 
//				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		setBtchno(getbtno());
		System.out.println("Batch No form Add List = "+ getBtchno());
		
		setExpdt(itemExpDate);
		
		SessionFactory sfactory = SessionHelper.getConnection();
		Session session = sfactory.openSession();
		m1.add(new Medical(medical.getMedicin_name(), price, medical.getQuantity(),price*medical.getQuantity(),getBtchno(),getExpdt(), 3004) );
		double totalprice=0;
		for (Medical medical2 : m1) {
			
			totalprice=totalprice+medical2.getAmount();
			
			
		}
		ItemStockDaoImpl imple= new ItemStockDaoImpl();
		imple.updateQuantity(m1.get(m1.size()-1));
		this.totalAmmount=totalprice;
		System.out.println("out of for loop ");
		return "Demo2.xhtml?faces-redirect=true";
	}
	
	public String removeCart(Medical m){
		
//		for (Medical md : m1) {
//			
//			if(md.getMedicin_name()==m.getMedicin_name())
//				System.out.println("medicine in for loop "+m.getMedicin_name());
//			m1.remove(md);
//		}
		this.totalAmmount=this.totalAmmount-m.getPrice()*m.getQuantity();
		ListIterator<Medical> it = m1.listIterator();

		while ( it.hasNext() ) {
		   Medical med = it.next();

		      if (med.getMedicin_name()==m.getMedicin_name() ) {
		        it.remove(); break; }
		     
		}
		
	
		
		SessionFactory sfactory = SessionHelper.getConnection();
		Session session = sfactory.openSession();
		Criteria criteria = session.createCriteria(Item_Stock.class);
		criteria.add(Restrictions.eq("item_name", m.getMedicin_name()));
		
		
		
		Item_Stock item_stock = (Item_Stock) criteria.uniqueResult();
		int updateQuantity=item_stock.getQuant()+ m.getQuantity();
		item_stock.setQuant(updateQuantity);
		
		System.out.println("Fromm Update Quantity Stock = "+ updateQuantity);
		
		Transaction trans = session.beginTransaction();
		session.update(item_stock);
		trans.commit();
		
		return "Demo2.xhtml?faces-redirect=true";
	}
	
	
	

}
