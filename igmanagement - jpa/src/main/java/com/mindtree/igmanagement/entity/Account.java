package com.mindtree.igmanagement.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Account implements Comparable<Account>{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountId;
	private String accountName;
	private double accountRevenue;
	
	@OneToMany(mappedBy = "account",cascade = CascadeType.PERSIST)
	Set<Project> projects;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Ig ig;

	public Account() {
		super();
	}

	public Account(int accountId, String accountName, double accountRevenue, Set<Project> projects, Ig ig) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.accountRevenue = accountRevenue;
		this.projects = projects;
		this.ig = ig;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public double getAccountRevenue() {
		return accountRevenue;
	}

	public void setAccountRevenue(double accountRevenue) {
		this.accountRevenue = accountRevenue;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	public Ig getIg() {
		return ig;
	}

	public void setIg(Ig ig) {
		this.ig = ig;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountName=" + accountName + ", accountRevenue=" + accountRevenue
				+ ", projects=" + projects + ", ig=" + ig + "]";
	}

	@Override
	public int compareTo(Account account) {
		
		if (account.accountRevenue>this.accountRevenue)
			return 1;
		else
			if(account.accountRevenue<this.accountRevenue)
				return -1;
			else
				return 0;
	}
	
	
}
