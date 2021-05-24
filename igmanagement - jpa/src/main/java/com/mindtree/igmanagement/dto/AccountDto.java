package com.mindtree.igmanagement.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class AccountDto {

	private int accountId;
	private String accountName;
	private double accountRevenue;

	@JsonIgnoreProperties("account")
	Set<ProjectDto> projects;

	@JsonIgnoreProperties("accounts")
	private IgDto ig;

	public AccountDto() {
		super();
	}

	public AccountDto(int accountId, String accountName, double accountRevenue, Set<ProjectDto> projects, IgDto ig) {
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

	
	public Set<ProjectDto> getProjects() {
		return projects;
	}

	public void setProjects(Set<ProjectDto> projects) {
		this.projects = projects;
	}

	
	public IgDto getIg() {
		return ig;
	}

	public void setIg(IgDto ig) {
		this.ig = ig;
	}

	@Override
	public String toString() {
		return "AccountDto [accountId=" + accountId + ", accountName=" + accountName + ", accountRevenue="
				+ accountRevenue + ", projects=" + projects + ", ig=" + ig + "]";
	}

}
