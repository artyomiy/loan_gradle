package org.adenisen.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.adenisen.Entity.Account;
import org.adenisen.Entity.Loan;
import org.adenisen.Entity.LoanHistory;

public interface LoanService {
	public List<LoanHistory> readHistory(Loan loan);
	public Loan save(Loan loan, String ip);
	public Loan getById(Long id);
	public boolean extend(Loan loan, String ip);
	public boolean isDangerTime(Loan loan, Date dangerTimeFrom, Date dangerTimeTo);
	public boolean isMaxAmount(Loan loan, Double maxAmount);
	public boolean isMaxApplicationFromOneIp(String ip, int maxCount);
	public int getExtendedWeeksCount(Loan loan);
}
