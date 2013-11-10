package org.adenisen.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.adenisen.Entity.Loan;
import org.adenisen.Entity.LoanHistory;
import org.adenisen.Entity.Person;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class LoanServiceTest {
	LoanService loanService = new LoanServiceImpl();
	
    @Test
    public void saveLaon() {
    	Loan loan = new Loan();
    	loan.setAmount(50.0);
    	loan.setTermStart(new Date());
    	Calendar cal = Calendar.getInstance();
    	cal.add(Calendar.MONTH, 1);
    	loan = loanService.save(loan, "10.10.10.10");
    	assertTrue("Save loan test failed", loan != null && loan.getId()!=null);
    }
    
    @Test
    public void canReceivePersonIp() {
    	assertNotNull(null);
    }
    
    @Test
	public void readHistoryTest(){
		ArrayList<LoanHistory> result;
		
		assertNotNull(null);
	}
	
    @Test
	public void saveLoanHisroryTest(){
    	Loan result;
		
    	assertNotNull(null);
	}

    @Test
	public void getByIdTest(){
    	Loan result;
		
    	assertNotNull(null);
	}
    
    @Test
	public void extendtest(){
    	Loan result;
		
    	assertNotNull(null);
	}
    
    @Test
	public void isDangerTimeTest(){
    	Loan result;
		
		assertNotNull(null);
	}
    
    @Test
	public void isMaxAmountTest(){
    	Loan result;
		
    	assertNotNull(null);
	}
    
    @Test
	public void isMaxApplicationFromOneIpTest(){
    	Loan result;
		
    	assertNotNull(null);
	}
    
    @Test
	public void getExtendedWeeksCountTest(){
    	Loan result;
		
    	assertNotNull(null);
	}

}
