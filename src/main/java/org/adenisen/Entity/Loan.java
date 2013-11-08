package org.adenisen.Entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "LOAN")
public class Loan implements java.io.Serializable{
	public static final double MAX_AMOUNT = 500.0;
	public static final int MAX_APP_COUNT_FROM_IP 	= 3;
	public static final String DANGER_TIME_FROM	= "00:00";
	public static final String DANGER_TIME_TO	= "06:00";
	
	private Long id;
	private Double amount = 0.0;
	private Date termEnd;
	private Date termStart;
	private Double	interestIndex = 1.0;
	private ArrayList<LoanHistory> loanHistoryList = new ArrayList<LoanHistory>();
	private int termMonth;
	
	public Loan(){
	}
	
	public Loan(Double amount, int term){
		setAmount(amount);
		setTermStart(new Date());
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.MONTH, term);
		setTermEnd(calendar.getTime());
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="AMOUNT")
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	@Column(name="TERM_END")
	public Date getTermEnd() {
		return termEnd;
	}
	public void setTermEnd(Date termEnd) {
		this.termEnd = termEnd;
	}
	@Column(name="TERM_START")
	public Date getTermStart() {
		return termStart;
	}
	public void setTermStart(Date termStart) {
		this.termStart = termStart;
	}

	/**
	 * @return the loanHistoryList
	 */
	@OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="LOAN_ID", nullable=false)
	public ArrayList<LoanHistory> getLoanHistoryList() {
		return loanHistoryList;
	}

	/**
	 * @param loanHistoryList the loanHistoryList to set
	 */
	public void setLoanHistoryList(ArrayList<LoanHistory> loanHistoryList) {
		this.loanHistoryList = loanHistoryList;
	}

	/**
	 * @return the interestIndex
	 */
	@Column(name="INTEREST_INDEX")
	public Double getInterestIndex() {
		return interestIndex;
	}

	/**
	 * @param interestIndex the interestIndex to set
	 */
	public void setInterestIndex(Double interestIndex) {
		this.interestIndex = interestIndex;
	}

	@Transient
	public int getTermMonth() {
		return termMonth;
	}

	public void setTermMonth(int termMonth) {
		this.termMonth = termMonth;
	}
}
