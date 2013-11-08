package org.adenisen;

import org.adenisen.Entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FirstExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Session sess = null;
		Transaction tran = null;
		try {
			SessionFactory sessFact = new Configuration().configure()
					.buildSessionFactory();
			sess = sessFact.openSession();
			System.out.println("Session: " + sess);
			tran = sess.beginTransaction();
			Person emp = new Person();
			emp.setName("Birendra Kumar");
			sess.save(emp);
			tran.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			sess.close();
		}

	}

}
