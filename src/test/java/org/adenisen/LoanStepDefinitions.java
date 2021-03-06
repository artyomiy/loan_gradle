package org.adenisen;

import static org.junit.Assert.*;

import java.util.Date;

import org.adenisen.Entity.Account;
import org.adenisen.Entity.Loan;
import org.adenisen.Entity.Person;
import org.adenisen.common.Helper;
import org.adenisen.service.LoanService;
import org.adenisen.service.LoanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
 
public class LoanStepDefinitions {
	private final String TEST_IP = "10.10.10.10";
	private Person user;
	private Account account;
	
	private LoanService service = new LoanServiceImpl();
	
	@Given("^a user has no loan$")
	public void a_user_has_no_applications() throws Throwable {
		user = new Person("Alan");
		account = new Account();
		account.setPerson(user);
		assertTrue(account.getLoanList().isEmpty());
	}

	@When("^user applied for loan (\\d+) and term (\\d+) month$")
	public void user_applied_for_loan_and_term_month(int arg1, int arg2) throws Throwable {
		Loan loan = new Loan(new Double(arg1), arg2);
		loan.setAccount(account);
		account.addLoan(loan);
	}
	
	@When("^application submitted not between (.+) and (.+)$")
	public void application_submitted_not_between_T_and_T_(
			String dangerFrom, String dangerTo) throws Throwable {
		Date dangerTimeFrom = Helper.addTimeToCurrentDate(dangerFrom);
		Date dangerTimeTo = Helper.addTimeToCurrentDate(dangerTo);
	    assertFalse(service.isDangerTime(account.getLoanList().get(0), dangerTimeFrom, dangerTimeTo) );
	}

	@When("^not selected the max amount$")
	public void not_selected_the_max_amount() throws Throwable {
		assertFalse(service.isMaxAmount(account.getLoanList().get(0), Loan.MAX_AMOUNT));
	}

	@When("^number of applications from a single IP (\\.+) within a day is less then (\\d+)$")
	public void number_of_applications_from_a_single_IP_within_a_day_is_less_then(String arg1, int arg2) throws Throwable {
		account.getPerson().setIp(arg1);
		assertFalse(service.isMaxApplicationFromOneIp(account.getPerson().getIp(), arg2));
	}

	@Then("^users loan balance should be (\\d+)$")
	public void users_loan_balance_should_be(int arg1) throws Throwable {
		Loan loan = account.getLoanList().get(0);
		service.save(loan, account.getPerson().getIp());
		account = loan.getAccount();
		assertTrue(account.getLoanList().get(0).getAmount() == arg1);
	}
	
	@Then("^term date (\\d+)$")
	public void term_date(int arg1) throws Throwable {
		assertTrue(account.getLoanList().get(0).getTermMonth() == arg1);
	}
	
	@Given("^user has a loan in his account$")
	public void user_has_a_loan_in_his_account() throws Throwable {
//		user = new Person("Alan");
//		account = new Account();
//		account.setPerson(user);
//		Loan loan = new Loan(100.0,2);
//		loan.setAccount(account);
//		service.save(loan, TEST_IP);
		assertFalse(account.getLoanList().isEmpty());
//		assertNull(null);
	}

	@When("^user extend a loan$")
	public void user_extend_a_loan() throws Throwable {
		Loan loan = account.getLoanList().get(0);
		Boolean result = service.extend(loan, account.getPerson().getIp());
		account = loan.getAccount();
		assertTrue(result);
	}

	@Then("^term of the loan extended by (\\d+)$")
	public void term_of_the_loan_extended_by(int arg1) throws Throwable {
		assertTrue(arg1 == service.getExtendedWeeksCount(account.getLoanList().get(0)));	
	}

	@Then("^interest increased by (\\d+.\\d+) factor$")
	public void interest_increased_by_factor(Double arg1) throws Throwable {
		assertTrue(arg1.equals(account.getLoanList().get(0).getInterestIndex()));	
	}

}
