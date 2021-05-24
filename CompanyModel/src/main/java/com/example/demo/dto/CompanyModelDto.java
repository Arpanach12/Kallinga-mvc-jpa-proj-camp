package com.example.demo.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.example.demo.entity.Company;
import com.example.demo.entity.Customer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_NULL)
public class CompanyModelDto {
	private int companymodelId;
	private String companymodelName;
	private int modelPrice;
	@JsonIgnoreProperties("companymodelList")
	private CompanyDto company;
	@JsonIgnoreProperties("companymodel")
	private List<CustomerDto> customerList;
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
	public CompanyDto getCompany() {
		return company;
	}
	public void setCompany(CompanyDto company) {
		this.company = company;
	}
	public List<CustomerDto> getCustomerList() {
		return customerList;
	}
	public void setCustomerList(List<CustomerDto> customerList) {
		this.customerList = customerList;
	}
	public CompanyModelDto(int companymodelId, String companymodelName, int modelPrice, CompanyDto company,
			List<CustomerDto> customerList) {
		super();
		this.companymodelId = companymodelId;
		this.companymodelName = companymodelName;
		this.modelPrice = modelPrice;
		this.company = company;
		this.customerList = customerList;
	}
	public CompanyModelDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
