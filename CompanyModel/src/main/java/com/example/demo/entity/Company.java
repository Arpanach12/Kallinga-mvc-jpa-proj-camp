package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GeneratorType;

@Entity
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int companyId;
	private String companyName;
	@OneToMany(mappedBy = "company",cascade = CascadeType.ALL)
	private List<CompanyModel> companymodelList;
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public List<CompanyModel> getCompanymodelList() {
		return companymodelList;
	}
	public void setCompanymodelList(List<CompanyModel> companymodelList) {
		this.companymodelList = companymodelList;
	}
	public Company(int companyId, String companyName, List<CompanyModel> companymodelList) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.companymodelList = companymodelList;
	}
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
