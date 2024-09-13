package com.jsf.hib;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

@ManagedBean(name="wdao")
@SessionScoped
public class WalletDAOImpl implements WalletDAO {

	@Override
	public List<Wallet> showCustomerWalletDao(int custId) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Wallet.class);
		cr.add(Restrictions.eq("custId", custId));
		List<Wallet> walletList = cr.list();
		return walletList;
	}

}
