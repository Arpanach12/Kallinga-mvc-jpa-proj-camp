package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class CompanyModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int companymodelId;
	private String companymodelName;
	private int modelPrice;
	@ManyToOne(cascade = CascadeType.ALL)
	private Company company;
	@OneToMany(mappedBy = "companymodel",cascade = CascadeType.ALL)
	private List<Customer> customerList;
	public int getCompanymodelId() {
		return companymodelId;
	}
	public void setCompanymodelId(int companymodelId) {
		this.companymodelId = companymodelId;
	}
	public String getCompanymodelName() {
		return companymodelName;
	}
	public void setCompanymodelName(String companymodelName) {
		this.companymodelName = companymodelName;
	}
	public int getModelPrice() {
		return modelPrice;
	}
	public void setModelPrice(int modelPrice) {
		this.modelPrice = modelPrice;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public List<Customer> getCustomerList() {
		return customerList;
	}
	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}
	public CompanyModel(int companymodelId, String companymodelName, int modelPrice, Company company,
			List<Customer> customerList) {
		super();
		this.companymodelId = companymodelId;
		this.companymodelName = companymodelName;
		this.modelPrice = modelPrice;
		this.company = company;
		this.customerList = customerList;
	}
	public CompanyModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
