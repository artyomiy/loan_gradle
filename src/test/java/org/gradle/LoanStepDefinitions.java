package org.gradle;

import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.adenisen.Entity.Account;
import org.adenisen.Entity.Loan;
import org.adenisen.Entity.User;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.Format;
import cucumber.api.PendingException;
 
public class LoanStepDefinitions {
	private User user;
	
	@Given("^a user has no applications$")
	public void a_user_has_no_applications() throws Throwable {
		user = new User("Alan");
		user.setAccount(new Account());
	}

	@When("^user applied for loan (\\d+) and term (\\d+) month$")
	public void user_applied_for_loan_and_term_month(int arg1, int arg2) throws Throwable {
		Loan loan = new Loan(new Double(arg1), arg2);
		user.getAccount().addLoan(loan);
	}
	
	@When("^application submitted between (.+) and (.+)$")
	public void application_submitted_between_T_and_T_(
			String validFrom, String validTo) throws Throwable {
//	    DateFormat format = new SimpleDateFormat("HH:mm:ss");
//	    Date timeFrom = format.parse(validFrom);
//	    Date timeTo = format.parse(validTo);
//	    Calendar cal = Calendar.getInstance();
//	    cal.setTime(user.getAccount().getLoan().get(0).getTermStart());
//	    Date submitHours = new Date();
//	    assertTrue(timeFrom.before(cal.get(Calendar.HOUR_OF_DAY)) );
	    throw new PendingException();
	}

	@When("^not selected the max amount$")
	public void not_selected_the_max_amount() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@When("^number of applications from a single IP within a day is less then (\\d+)$")
	public void number_of_applications_from_a_single_IP_within_a_day_is_less_then(int arg1) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@Then("^users loan balance should be (\\d+)$")
	public void users_loan_balance_should_be(int arg1) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}
	
	@Then("^term date (\\d+)$")
	public void term_date(int arg1) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}
}
