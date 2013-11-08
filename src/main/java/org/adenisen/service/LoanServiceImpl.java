package org.adenisen.service;

import java.util.ArrayList;
import java.util.Date;

import org.adenisen.Entity.Loan;
import org.adenisen.Entity.LoanHistory;
import org.adenisen.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

@Service
public class LoanServiceImpl implements LoanService {

	public ArrayList<LoanHistory> readHistory(Long laonId) {
		ArrayList<LoanHistory> result  = new ArrayList<LoanHistory>();
		// TODO Auto-generated method stub
		return result;
	}

	public Loan save(Loan loan) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(loan);
		session.getTransaction().commit();
		return loan;
	}

	public Loan getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean extend(Loan loan) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isValid(Loan loan, Double MaxAmount, 
			Date dangerTimeFrom, Date dangerTimeTo) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isDangerTime(Loan loan, Date dangerTimeFrom,
			Date dangerTimeTo) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isMaxAmount(Loan loan, Double maxAmount) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isMaxApplicationFromOneIp(String ip, int maxCount) {
		// TODO Auto-generated method stub
		return false;
	}

	public int getExtendedWeeksCount(Loan loan) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
