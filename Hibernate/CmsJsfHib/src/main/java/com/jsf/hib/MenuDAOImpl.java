package com.jsf.hib;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

@ManagedBean(name="menuDao")
@SessionScoped
public class MenuDAOImpl implements MenuDAO {

	@Override
	public List<Menu> showMenuByRestaurant(int rid) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Menu.class);
		cr.add(Restrictions.eq("restaurantId", rid));
		List<Menu> menuList = cr.list();
		return menuList;
	}

}
