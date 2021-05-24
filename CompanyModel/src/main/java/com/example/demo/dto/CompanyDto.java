package com.example.demo.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.example.demo.entity.CompanyModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class CompanyDto {
	
	private int customerId;
	private String customerName;
	private String hobby;
	private String password;
	private String gender;
	private String customerEmail;
	private String phone;
	private int totalPrice;
	private int quantity;
	private int noofdays;
	@JsonIgnoreProperties("company")
	private CompanyModel companymodel;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getNoofdays() {
		return noofdays;
	}
	public void setNoofdays(int noofdays) {
		this.noofdays = noofdays;
	}
	public CompanyModel getCompanymodel() {
		return companymodel;
	}
	public void setCompanymodel(CompanyModel companymodel) {
		this.companymodel = companymodel;
	}
	public CompanyDto(int customerId, String customerName, String hobby, String password, String gender,
			String customerEmail, String phone, int totalPrice, int quantity, int noofdays, CompanyModel companymodel) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.hobby = hobby;
		this.password = password;
		this.gender = gender;
		this.customerEmail = customerEmail;
		this.phone = phone;
		this.totalPrice = totalPrice;
		this.quantity = quantity;
		this.noofdays = noofdays;
		this.companymodel = companymodel;
	}
	public CompanyDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
