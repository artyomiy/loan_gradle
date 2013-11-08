package org.adenisen.service;

import static org.junit.Assert.*;
import java.util.Calendar;
import java.util.Date;

import org.adenisen.Entity.Loan;
import org.adenisen.Entity.Person;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class LoanServiceTest {
	LoanService loanService;
	
	@Autowired
	public LoanServiceTest(LoanService loanService) {
		this.loanService = loanService;
	}
	
    @Test
    public void saveLaon() {
    	Loan loan = new Loan();
    	loan.setAmount(50.0);
    	loan.setTermStart(new Date());
    	Calendar cal = Calendar.getInstance();
    	cal.add(Calendar.MONTH, 1);
    	loan = loanService.save(loan);
    	assertTrue("Save loan test failed", loan != null && loan.getId()!=null);
    }
    
    @Test
    public void canReceivePersonIp() {
    	assertNull(null);
    }
}
