package org.adenisen.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LOAN_HISTORY")
public class LoanHistory implements java.io.Serializable {
	public static final int LOAN_CREATED 	= 1;  	//history type
	public static final int LOAN_EXTENDED 	= 2;	//history type
	
	private Long id;
	private Date changeDate;
	private Date oldTermEnd;
	private int extendedByWeeks;
	private int historyType;
	private String personIP;
	
	@Id
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
	@Column(name="CHANGE_DATE")
	public Date getChangeDate() {
		return changeDate;
	}

	/**
	 * @param changeDate the changeDate to set
	 */
	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
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
}
