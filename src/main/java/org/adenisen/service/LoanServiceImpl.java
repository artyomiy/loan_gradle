package org.adenisen.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.util.Date;

import org.adenisen.Entity.Loan;
import org.adenisen.Entity.LoanHistory;
import org.adenisen.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

@Service
public class LoanServiceImpl implements LoanService {

	public Loan save(Loan loan, String ip) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			createLoanHistory(loan, ip, LoanHistory.LOAN_CREATED);
			loan = (Loan)session.save(loan);
			setPersonIp(loan, ip);
			session.flush();
			tx.commit();
		}catch(Exception e){
			if (tx!=null) tx.rollback();
		}finally {
			session.close();
		}
		return loan;
	}

	public Loan getById(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Loan result = null;
		try{
			result = (Loan)session.load(Loan.class, id);
		}catch (Exception e){
		}finally{
			session.close();
		}
		 
		return result;
	}

	public boolean extend(Loan loan, String ip) {
		Session session = HibernateUtil.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			createLoanHistory(loan, ip, LoanHistory.LOAN_CREATED);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(loan.getTermEnd());
			calendar.add(Calendar.WEEK_OF_YEAR, Loan.EXTEND_WEEKS_COUNT);
			loan = (Loan)session.save(loan);
			setPersonIp(loan, ip);
			session.flush();
			tx.commit();
		}catch(Exception e){
			if (tx!=null) tx.rollback();
			return false;
		} finally {
			session.close();
		}
		return true;
	}

	public boolean isDangerTime(Loan loan, Date dangerTimeFrom,
			Date dangerTimeTo) {
		return loan.getTermStart().after(dangerTimeFrom)
				&& loan.getTermStart().before(dangerTimeTo);
	}

	public boolean isMaxAmount(Loan loan, Double maxAmount) {
		return loan.getAmount().equals(maxAmount) ;
	}

	public boolean isMaxApplicationFromOneIp(String ip, int maxCount) {
		List list = new ArrayList();
		try{
			Query query = HibernateUtil.getSessionFactory().openSession().
					createQuery("from LOAN_HISTORY where PERSON_IP = :ip and "
							+ " TRUNC(sysdate) = changeDate and "
							+ " HISTORY_TYPE = :histType");
			query.setParameter("ip", ip);
			query.setParameter("histType", LoanHistory.LOAN_CREATED);
			list = query.list();
		}catch (Exception ex){
			return false;
		}
		
		return list.size() >= maxCount;
	}
	
	public boolean delete(Loan loan) {
		Session session = HibernateUtil.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(loan);
			session.flush();
			tx.commit();
		}catch(Exception e){
			if (tx!=null) tx.rollback();
			return false;
		} finally{
			session.close();
		}
		return true;
	}
	
	public int deleteById(List<Long> ids) {
		int result;
		try{
			Query query = HibernateUtil.getSessionFactory().openSession().
					createQuery("delete from LOAN where ID in (:idList) ");
			StringBuilder idList = new StringBuilder();
			for (Long id : ids){
				idList.append(id);
				idList.append(",");
			}
			idList.deleteCharAt(idList.length()-1);
			query.setString("idList", idList.toString());
			result = query.executeUpdate();
		}catch (Exception ex){
			return -1;
		}
		
		return result;
	}
	
	public int getExtendedWeeksCount(Loan loan) {
		int result = 0;
		for (LoanHistory hist : loan.getLoanHistoryList()){
			if (LoanHistory.LOAN_EXTENDED == hist.getHistoryType()){
				result++;
			}
		}
		return result;
	}

	private void createLoanHistory(Loan loan, String ip, int histActType) {
		LoanHistory hist = new LoanHistory();
		hist.setCreated(new Date());
		hist.setPersonIP(ip);
		hist.setHistoryType(histActType);
		hist.setLoan(loan);
		loan.getLoanHistoryList().add(hist);
		if (histActType == LoanHistory.LOAN_EXTENDED){
			hist.setOldEndDate(loan.getTermEnd());
			hist.setExtendedByWeeks(Loan.EXTEND_WEEKS_COUNT);
		}
	}
	
	private void setPersonIp(Loan loan, String ip) {
		if (loan.getAccount() != null &&
				loan.getAccount().getPerson() != null){
			loan.getAccount().getPerson().setIp(ip);
		}
		
	}
}
