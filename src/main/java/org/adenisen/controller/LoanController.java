package org.adenisen.controller;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.servlet.http.HttpServletRequest;

import org.adenisen.Entity.Account;
import org.adenisen.Entity.Loan;
import org.adenisen.Entity.LoanHistory;
import org.adenisen.Entity.Person;
import org.adenisen.common.Helper;
import org.adenisen.service.AccountService;
import org.adenisen.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope("session") 
public class LoanController {
	
	LoanService loanService;
	AccountService accountService;
	Account account = new Account();
	
	@Autowired
	public LoanController(LoanService loanService, AccountService accountService) {
		this.loanService = loanService;
		this.accountService = accountService;
	}
	
    @RequestMapping("home")
    public String loadHomePage(Model m, HttpServletRequest request) {
    	if (account.getPerson() == null){
    		Person person = new Person("Fake user");
    		person.setIp(request.getRemoteAddr());
            account.setPerson(person);
    	}
    	m.addAttribute("name", account.getPerson().getName());
        return "home";
    }
    
	@RequestMapping(value="loanForm", method=RequestMethod.POST)
	public ModelAndView getLoan(@ModelAttribute Loan newLoan) {
		Loan loan = new Loan(newLoan.getAmount(), newLoan.getTermMonth());
		ModelAndView modelAndView = new ModelAndView();
		Date dangerTimeFrom = Helper.addTimeToCurrentDate(Loan.DANGER_TIME_FROM);
		Date dangerTimeTo = Helper.addTimeToCurrentDate(Loan.DANGER_TIME_TO);
		if ((loanService.isDangerTime(loan, dangerTimeFrom, dangerTimeTo) 
					&& loanService.isMaxAmount(loan, Loan.MAX_AMOUNT))
				|| loanService.isMaxApplicationFromOneIp(account.getPerson().getIp(), Loan.MAX_APP_COUNT_FROM_IP)){
			modelAndView.addObject("loanInfoNOK", "Loan was rejected" );	
		}else{
			account.addLoan(loan);
			loan.setAccount(account);
			loanService.save(loan, account.getPerson().getIp());
			modelAndView.addObject("loanInfoOK", "Loan was successfully granted" );
		}
		
		modelAndView.setViewName("myLoans");
		return modelAndView;
	}
	
	@RequestMapping("loan/history/{index}")
	public List<LoanHistory> getLoanHistory(@PathVariable int index) {
		if (account.getLoanList().size() < index){
			return account.getLoanList().get(index).getLoanHistoryList();
		}
		return null;
	}
	
	@RequestMapping("loan/extend/{index}")
	public String extendLoan(@PathVariable int index) {
		boolean result = false;
		if (account.getLoanList().size() < index){
			result = loanService.extend(account.getLoanList().get(index), account.getPerson().getIp());
		}
		return result ? "Extended" : "Not extended";
	}

}
