package com.mindtree.igmanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class ProjectDto {

	
	private int projectId;
	private String projectName;
	private int resourceCount;
	private double projectCost;
	
	@JsonIgnoreProperties("projects")
	private AccountDto account;

	public ProjectDto() {
		super();
	}

	public ProjectDto(int projectId, String projectName, int resourceCount, double projectCost, AccountDto account) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.resourceCount = resourceCount;
		this.projectCost = projectCost;
		this.account = account;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public int getResourceCount() {
		return resourceCount;
	}

	public void setResourceCount(int resourceCount) {
		this.resourceCount = resourceCount;
	}

	public double getProjectCost() {
		return projectCost;
	}

	public void setProjectCost(double projectCost) {
		this.projectCost = projectCost;
	}

	public AccountDto getAccount() {
		return account;
	}

	public void setAccount(AccountDto account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "ProjectDto [projectId=" + projectId + ", projectName=" + projectName + ", resourceCount="
				+ resourceCount + ", projectCost=" + projectCost + ", account=" + account + "]";
	}
	
	
	
}
