package org.adenisen.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.adenisen.Entity.Loan;
import org.adenisen.common.Helper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LoanServiceTest {
	private final String IP_FOR_TEST = "10.10.10.11";
	LoanService loanService = new LoanServiceImpl();
	Loan loan = null;
	List<Long> loanIds = new ArrayList();
	
	@Before
    public void setUp() {
    	loan = new Loan();
    	loan.setAmount(50.0);
    	loan.setTermStart(new Date());
    	Calendar cal = Calendar.getInstance();
    	cal.add(Calendar.MONTH, 1);
    }
	
    @Test
    public void saveLoan() {
    	boolean result = false;
    	loan = loanService.save(loan, IP_FOR_TEST);
    	if (loan != null && loan.getId()!=null){
    		loanIds.add(loan.getId());
    		result = true;
    	}
    	assertTrue("Save loan test failed", result);
    }
    
    @Test
	public void readHistoryTest(){
		assertFalse(loan.getLoanHistoryList().isEmpty());
	}

    @Test
	public void getByIdTest(){
    	Loan newLoan = loanService.getById(loan.getId());
    	assertNotNull(newLoan);
	}
    
    @Test
	public void extendTest(){
    	assertTrue(loanService.extend(loan, IP_FOR_TEST));
	}
    
    @Test
	public void isDangerTimeTest(){
    	Loan loan = new Loan(100.0, 3);
    	loan.setTermStart( Helper.addTimeToCurrentDate("04:10"));
		assertTrue(loanService.isDangerTime(loan, Helper.addTimeToCurrentDate(Loan.DANGER_TIME_FROM), 
    			Helper.addTimeToCurrentDate(Loan.DANGER_TIME_TO)));
	}
    
    @Test
	public void isMaxAmountTest(){
    	Loan newLoan = new Loan(Loan.MAX_AMOUNT, 3);
    	assertTrue(loanService.isMaxAmount(newLoan, Loan.MAX_AMOUNT));
	}
    
    @Test
	public void isMaxApplicationFromOneIpTest(){
    	for (int i = 0 ; i < 2; i++){
    		Loan loan = new Loan(100.0,1);
    		loanService.save(loan, IP_FOR_TEST);
    		loanIds.add(loan.getId());
    	}
		assertFalse(loanService.isMaxApplicationFromOneIp(IP_FOR_TEST,
				Loan.MAX_APP_COUNT_FROM_IP));
	}
    
	@After
    public void cleanUp() {
		loan = null;
    	loanService.deleteById(loanIds);
    }
    
}
