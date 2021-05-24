package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CompanyModelDto;
import com.example.demo.service.CompanyService;

@RestController
@RequestMapping("/rest")
public class CompanyRestController {
	@Autowired
	CompanyService companyservice;
	private int modelprice;

	@RequestMapping("/loadModelByCompany/{companyId}")
	public List<CompanyModelDto> getModels(@PathVariable int companyId) {
		return companyservice.gettingModels(companyId);
	}

	@RequestMapping("/loadprice/{modelId}")
	public int getModelPrice(@PathVariable int modelId) {
		modelprice = companyservice.getModelPrices(modelId);
		return modelprice;
	}

	@RequestMapping("/loadtotalprice/{customerQuantitiesPurchased}")
	public int getTotalPrice(@PathVariable int customerQuantitiesPurchased) {
		return companyservice.getTotalPrices(customerQuantitiesPurchased, modelprice);
	}

}
