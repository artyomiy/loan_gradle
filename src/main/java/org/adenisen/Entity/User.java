package org.adenisen.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.collections.list.GrowthList;

@Entity
@Table(name = "USER")
public class User {
	private Long id;
    private String name;
    private Account account;

    public User() {
    }
	public User(String name) {
        this.name = name;
        new GrowthList();
    }
	
	@Id
	@Column(name = "ID", unique = true, nullable = false)
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
    
    public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}

