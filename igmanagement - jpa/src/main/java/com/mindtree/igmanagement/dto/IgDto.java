package com.mindtree.igmanagement.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class IgDto {

	
	private int igId;
	private String igName;
	
	@JsonIgnoreProperties("ig")
	Set<AccountDto> accounts;

	public IgDto() {
		super();
	}

	public IgDto(int igId, String igName, Set<AccountDto> accounts) {
		super();
		this.igId = igId;
		this.igName = igName;
		this.accounts = accounts;
	}

	public int getIgId() {
		return igId;
	}

	public void setIgId(int igId) {
		this.igId = igId;
	}

	public String getIgName() {
		return igName;
	}

	public void setIgName(String igName) {
		this.igName = igName;
	}

	public Set<AccountDto> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<AccountDto> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "IgDto [igId=" + igId + ", igName=" + igName + ", accounts=" + accounts + "]";
	}
	
	
}
