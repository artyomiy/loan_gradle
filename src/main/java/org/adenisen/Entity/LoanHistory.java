package org.adenisen.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LOAN_HISTORY")
public class LoanHistory implements java.io.Serializable {
	public static final int LOAN_CREATED 	= 1;  	//history type
	public static final int LOAN_EXTENDED 	= 2;	//history type
	
	private Long id;
	private Date created;
	private Date oldTermEnd;
	private int extendedByWeeks;
	private int historyType;
	private String personIP;
	private Loan loan;
	
	public LoanHistory(){
	}
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the changeDate
	 */
	@Column(name="CREATED")
	public Date getCreated() {
		return created;
	}

	/**
	 * @param created the changeDate to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/**
	 * @return the oldEndDate
	 */
	@Column(name="OLD_TERM_END")
	public Date getOldEndDate() {
		return oldTermEnd;
	}

	/**
	 * @param oldEndDate the oldEndDate to set
	 */
	public void setOldEndDate(Date oldEndDate) {
		this.oldTermEnd = oldEndDate;
	}

	/**
	 * @return the extendedByWeeks
	 */
	@Column(name="EXTENDED_BY_WEEKS")
	public int getExtendedByWeeks() {
		return extendedByWeeks;
	}

	/**
	 * @param extendedByWeeks the extendedByWeeks to set
	 */
	public void setExtendedByWeeks(int extendedByWeeks) {
		this.extendedByWeeks = extendedByWeeks;
	}

	@Column(name="HISTORY_TYPE")
	public int getHistoryType() {
		return historyType;
	}

	public void setHistoryType(int historyType) {
		this.historyType = historyType;
	}

	@Column(name="PERSON_IP")
	public String getPersonIP() {
		return personIP;
	}

	public void setPersonIP(String personIP) {
		this.personIP = personIP;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LOAN_ID", nullable = false)
	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan laon) {
		this.loan = laon;
	}
}
