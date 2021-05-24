package com.example.demo.dto;

import com.example.demo.entity.CompanyModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_NULL)
public class CustomerDto {
	private int companymodelId;
	private String companymodelName;
	private int modelPrice;
	@JsonIgnoreProperties("customerList")
	private CompanyModelDto companymodel;
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
	public CompanyModelDto getCompanymodel() {
		return companymodel;
	}
	public void setCompanymodel(CompanyModelDto companymodel) {
		this.companymodel = companymodel;
	}
	public CustomerDto(int companymodelId, String companymodelName, int modelPrice, CompanyModelDto companymodel) {
		super();
		this.companymodelId = companymodelId;
		this.companymodelName = companymodelName;
		this.modelPrice = modelPrice;
		this.companymodel = companymodel;
	}
	public CustomerDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
