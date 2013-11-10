package org.adenisen.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "ACCOUNT")
public class Account implements java.io.Serializable{
	private Long id;
	private List<Loan> loanList = new ArrayList<Loan>();
	private Person person;
	
	
	public Account(){
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
	
	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "account")
	public List<Loan> getLoanList() {
		return loanList;
	}

	public void setLoanList(ArrayList<Loan> loan) {
		if (loan != null){
			this.loanList = loan;
		}
	}
	
	@Transient
	public void addLoan(Loan loan){
		this.loanList.add(loan);
	}

	@OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="PERSON_ID", nullable=false)
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}
