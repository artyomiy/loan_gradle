package org.adenisen.Entity;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "LOAN")
public class Loan implements java.io.Serializable{
	private Long id;
	private Double amount = 0.0;
	private Date termEnd;
	private Date termStart;
	
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
	@Column(name = "ID", unique = true, nullable = false)	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Transient
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	@Transient
	public Date getTermEnd() {
		return termEnd;
	}
	public void setTermEnd(Date termEnd) {
		this.termEnd = termEnd;
	}
	@Transient
	public Date getTermStart() {
		return termStart;
	}
	public void setTermStart(Date termStart) {
		this.termStart = termStart;
	}
}
