package org.adenisen.Entity;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "ACCOUNT")
public class Account implements java.io.Serializable{
	private Long id;
	private ArrayList<Loan> loanList = new ArrayList<Loan>();

	@Id
	@Column(name = "ID", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Transient
	public ArrayList<Loan> getLoan() {
		return loanList;
	}

	public void setLoan(ArrayList<Loan> loan) {
		if (loan != null){
			this.loanList = loan;
		}
	}
	
	@Transient
	public void addLoan(Loan loan){
		this.loanList.add(loan);
	}
}
