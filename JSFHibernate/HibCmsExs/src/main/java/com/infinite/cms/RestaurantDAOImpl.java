package com.infinite.cms;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


@ManagedBean(name="rDao")
@SessionScoped
public class RestaurantDAOImpl implements RestaurantDAO {

	@Override
	public String addRestaurantDao(Restaurant restaurant, Menu menu) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		System.out.println(restaurant);
		List<Menu> menuList = new ArrayList<Menu>();
		menuList.add(menu);
		restaurant.setMenuList(menuList);
		Transaction trans = session.beginTransaction();
		session.save(restaurant);
		trans.commit();
		return "Added...";
	}

}
