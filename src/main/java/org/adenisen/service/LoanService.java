package org.adenisen.service;

import java.util.Date;
import java.util.List;

import org.adenisen.Entity.Loan;

public interface LoanService {
	public Loan save(Loan loan, String ip);
	public boolean delete(Loan loan);
	public Loan getById(Long id);
	public boolean extend(Loan loan, String ip);
	public boolean isDangerTime(Loan loan, Date dangerTimeFrom, Date dangerTimeTo);
	public boolean isMaxAmount(Loan loan, Double maxAmount);
	public boolean isMaxApplicationFromOneIp(String ip, int maxCount);
	public int getExtendedWeeksCount(Loan loan);
	public int deleteById(List<Long> ids);
}
