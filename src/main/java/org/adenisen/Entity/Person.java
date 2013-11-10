package org.adenisen.Entity;

import java.beans.Transient;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON")
public class Person {
	private Long id;
    private String name;
    private String IP;
    private Account account;

    public Person() {
    }
	public Person(String name) {
        this.name = name;
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

	@Column(name = "NAME", unique = false, nullable = false)
    public String getName() {
        return name;
    }
	
	public void setName(String name) {
        this.name = name;
    }
    
	
	@Transient
	public String getIp() {
		return IP;
	}
	public void setIp(String ip) {
		this.IP = ip;
	}
	
	@OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "person")
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}

}

