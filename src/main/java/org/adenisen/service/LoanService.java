package org.adenisen.service;

import java.util.ArrayList;
import java.util.Date;

import org.adenisen.Entity.Account;
import org.adenisen.Entity.Loan;
import org.adenisen.Entity.LoanHistory;

public interface LoanService {
	public ArrayList<LoanHistory> readHistory(Long laonId);
	public Loan save(Loan loan);
	public Loan getById(Long id);
	public boolean extend(Loan loan);
	public boolean isDangerTime(Loan loan, Date dangerTimeFrom, Date dangerTimeTo);
	public boolean isMaxAmount(Loan loan, Double maxAmount);
	public boolean isMaxApplicationFromOneIp(String ip, int maxCount);
	public int getExtendedWeeksCount(Loan loan);
}
