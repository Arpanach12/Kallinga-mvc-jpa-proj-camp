package com.mindtree.igmanagement.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int projectId;
	private String projectName;
	private int resourceCount;
	private double projectCost;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Account account;

	public Project() {
		super();
	}

	public Project(int projectId, String projectName, int resourceCount, double projectCost, Account account) {
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

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", resourceCount=" + resourceCount
				+ ", projectCost=" + projectCost + ", account=" + account + "]";
	}
	
	
	
}
