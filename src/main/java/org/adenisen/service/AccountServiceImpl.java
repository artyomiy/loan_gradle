package org.adenisen.service;

import org.adenisen.Entity.Account;
import org.adenisen.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

	public Account save(Account account) {
		Session session = HibernateUtil.getCurrentSession();
		session.beginTransaction();
		session.save(account);
		session.getTransaction().commit();
		return account;
	}
}
