package com.example.demo.service;




import java.sql.Date;
import java.util.List;

import com.example.demo.dto.CompanyModelDto;
import com.example.demo.entity.Company;
import com.example.demo.entity.Customer;
import com.example.demo.exception.BrandCompanyException;

public interface CompanyService {

	void insertCustomers(Customer customer);

	List<CompanyModelDto> gettingModels(int companyId);

	List<Company> getcompanys();

	int getModelPrices(int modelId);

	int getTotalPrices(int customerQuantitiesPurchased,int modelprice);

	void purchaseBikes(int quantity, int companyId, int companymodelName, int modelPrice, int totalPrice,
			Date orderdate, Date deliverydate,String email);

	String check(String adminId, String adminPassword) throws BrandCompanyException;

	List<Customer> customerDatas();

	Customer showCustomers(int customerId);

	List<Customer> showCustomerOfModels(int companymodelId);

	int getallRevenue(int companyId);

	
}
