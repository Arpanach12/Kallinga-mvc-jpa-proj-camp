package com.example.demo.controller;



import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Company;
import com.example.demo.entity.CompanyModel;
import com.example.demo.entity.Customer;
import com.example.demo.exception.BrandCompanyException;
import com.example.demo.service.CompanyService;

@Controller
public class CompanyController {
	@Autowired
	CompanyService companyservice;
	String email;

	@RequestMapping("/")
	public String link1() {
		return "index";
	}

	@RequestMapping("customerregister")
	public String link2() {
		return "customerregister";
	}

	@RequestMapping("insertcustomer")
	public String insertCustomer(Customer customer) {
		companyservice.insertCustomers(customer);
		return "index";
	}

	@RequestMapping("adminpage")
	public String link3(@RequestParam("adminId") String adminId, @RequestParam("adminPassword") String adminPassword,Model model) {
		try {
		email = companyservice.check(adminId, adminPassword);
		}catch(BrandCompanyException e){
			model.addAttribute("errormsg",e.getMessage());
			return "index";
		}
		return "adminpage";
	}

	@RequestMapping("buybike")
	public String buyABike(Model model) {
		List<Company> company1 = companyservice.getcompanys();
		model.addAttribute("companylists", company1);
		return "buybike";
	}

	@RequestMapping("purchasebike")
	public String purchaseBike(@RequestParam("quantity") int quantity, @RequestParam("companyId") int companyId,
			@RequestParam("companymodelName") int companymodelName, @RequestParam("modelPrice") int modelPrice,
			@RequestParam("totalPrice") int totalPrice, @RequestParam("orderdate") Date orderdate,
			@RequestParam("deliverydate") Date deliverydate) {

		companyservice.purchaseBikes(quantity, companyId, companymodelName, modelPrice, totalPrice, orderdate,
				deliverydate, email);

		return "buybike";
	}

	@RequestMapping("customerdata")
	public String customerData(Model model) {
		List<Customer> customer = companyservice.customerDatas();
		model.addAttribute("customerlists", customer);
		return "customerdata";
	}

	@RequestMapping("showcustomer")
	public String showCustomer(Model model, @RequestParam("customerId") int customerId) {
		Customer customer23 = companyservice.showCustomers(customerId);
		model.addAttribute("customerlist", customer23);
		return "customerdata";
	}

	@RequestMapping("modeldata")
	public String link7(Model model) {
		List<Company> company1 = companyservice.getcompanys();
		model.addAttribute("companylists", company1);
		return "modeldata";
	}

	@RequestMapping("showcustomerofmodel")
	public String showCustomerOfModel(@RequestParam("companymodelName") int companymodelId, Model model) {

		List<Customer> customer = companyservice.showCustomerOfModels(companymodelId);
		model.addAttribute("customerlists", customer);
		return "modeldata";
	}

	@RequestMapping("surveydata")
	public String surveyData(Model model) {
		List<Company> company1 = companyservice.getcompanys();
		model.addAttribute("companylists", company1);
		return "surveydata";
	}

	@RequestMapping("showtotalrevenue")
	public String getallRevenue(@RequestParam("companyId") int companyId,Model model) {
		int a=companyservice.getallRevenue(companyId);
		model.addAttribute("revenue",a);
		return "surveydata";
	}
	

}
