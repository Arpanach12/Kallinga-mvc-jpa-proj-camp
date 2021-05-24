package com.example.demo.service.serviceimpl;


import java.sql.Date;
import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CompanyDto;
import com.example.demo.dto.CompanyModelDto;
import com.example.demo.dto.CustomerDto;
import com.example.demo.entity.Company;
import com.example.demo.entity.CompanyModel;
import com.example.demo.entity.Customer;
import com.example.demo.exception.BrandCompanyException;
import com.example.demo.repository.CompanyModelRepository;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {
	@Autowired
	CompanyRepository companyrepository;
	@Autowired
	CompanyModelRepository companymodelrepository;
	@Autowired
	CustomerRepository customerrepository;
	ModelMapper modelMapper = new ModelMapper();

	@Override
	public void insertCustomers(Customer customer) {
		customerrepository.save(customer);

	}

	@Override
	public List<CompanyModelDto> gettingModels(int companyId) {
		Company company = companyrepository.findById(companyId).get();
		List<CompanyModelDto> companymodeldto = company.getCompanymodelList().stream()
				.map(companymodelentity -> convertEntityToDto(companymodelentity)).collect(Collectors.toList());
		return companymodeldto;
	}

	private CompanyModel convertDtoToEntity(CompanyModelDto companymodeldto) {
		return modelMapper.map(companymodeldto, CompanyModel.class);
	}

	private CompanyModelDto convertEntityToDto(CompanyModel companymodel) {

		return modelMapper.map(companymodel, CompanyModelDto.class);
	}

	private CompanyDto convertEntityToDto(Company company) {

		return modelMapper.map(company, CompanyDto.class);
	}

	private Company convertDtoToEntity(CompanyDto companydto) {
		return modelMapper.map(companydto, Company.class);
	}

	private Customer convertDtoToEntity(CustomerDto customerdto) {
		return modelMapper.map(customerdto, Customer.class);
	}

	private CustomerDto convertEntityToDto(Customer customer) {

		return modelMapper.map(customer, CustomerDto.class);
	}

	@Override
	public List<Company> getcompanys() {
		List<Company> company = companyrepository.findAll();
		return company;
	}

	@Override
	public int getModelPrices(int modelId) {
		CompanyModel companymodel = companymodelrepository.findById(modelId).get();
		int prices = companymodel.getModelPrice();
		return prices;
	}

	@Override
	public int getTotalPrices(int customerQuantitiesPurchased, int modelprice) {
		int a = modelprice * customerQuantitiesPurchased;
		return a;
	}

	@Override
	public void purchaseBikes(int quantity, int companyId, int companymodelName, int modelPrice, int totalPrice,
			Date orderdate, Date deliverydate, String email) {
		List<Customer> customer2 = customerrepository.findAll();
		Customer customer3 = new Customer();
		for (Customer customer : customer2) {
			if (customer.getCustomerEmail().equals(email)) {
				customer3 = customer;
			}
		}
		int numberOfDays=0;
		long diff=deliverydate.getTime()-orderdate.getTime();
		long diffdays=diff/(24*60*60*1000)+1;
		numberOfDays=(int)diffdays;
		List<CompanyModel> companymodel1 = companymodelrepository.findAll();
		for (CompanyModel companyModel : companymodel1) {
			if (companyModel.getCompanymodelId()==companymodelName) {
				customer3.setCompanymodel(companyModel);
			}
		}
		customer3.setQuantity(quantity);
		customer3.setTotalPrice(totalPrice);
		customer3.setNoofdays(numberOfDays);
		customerrepository.saveAndFlush(customer3);
	}

	@Override
	public String check(String adminId, String adminPassword) throws BrandCompanyException {
		List<Customer> customer = customerrepository.findAll();
		String str = "";

		for (Customer customer2 : customer) {
			if (customer2.getCustomerEmail().equals(adminId)) {
				if (customer2.getPassword().equals(adminPassword)) {

					str = customer2.getCustomerEmail();

				}
				else {
					throw new BrandCompanyException("email and password not valid");
				}
			}
		}

		return str;
	}

	@Override
	public List<Customer> customerDatas() {
		List<Customer> customers=customerrepository.findAll();
		System.out.println(customers);
		return customers;
	}

	@Override
	public Customer showCustomers(int customerId) {
		Customer customer=customerrepository.findById(customerId).get();
		return customer;
	}

	@Override
	public List<Customer> showCustomerOfModels(int companymodelId) {
		CompanyModel companymodel=companymodelrepository.findById(companymodelId).get();
		List<Customer> customer=companymodel.getCustomerList();
		return customer;
	}

	@Override
	public int getallRevenue(int companyId) {
		Company company=companyrepository.findById(companyId).get();
		int sum=0;
		for (CompanyModel  companymodel : company.getCompanymodelList()) {
			for (Customer customer : companymodel.getCustomerList()) {
				sum=sum+customer.getTotalPrice();
			}
		}
		return sum;
	}

}
