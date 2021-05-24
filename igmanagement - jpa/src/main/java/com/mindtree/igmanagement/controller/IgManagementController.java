package com.mindtree.igmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.igmanagement.dto.AccountDto;
import com.mindtree.igmanagement.dto.IgDto;
import com.mindtree.igmanagement.exceptions.controllerexception.IgManagementControllerException;
import com.mindtree.igmanagement.exceptions.serviceexceptions.IgManagementServiceException;
import com.mindtree.igmanagement.service.IgManagementService;

@RestController
public class IgManagementController {

	@Autowired
	IgManagementService service;

	/**
	 * @param ig
	 * @return response as "Ig inserted Successfully" when Ig is inserted
	 */
	@PostMapping("/ig")
	public String insertIg(@RequestBody IgDto ig) {

		String response = service.insertIgInDb(ig);
		return response;
	}

	/**
	 * @param account
	 * @return response as "Account and its Projects inserted Successfully" upon
	 *         insertion
	 * @throws IgManagementControllerException when projects cost is more than
	 *                                         account revenue
	 */
	@PostMapping("/accountandproject")
	public String insertAccountAndProjects(@RequestBody AccountDto account) throws IgManagementControllerException {

		String response = "";
		try {
			response = service.insertAccountAndProjectsToDb(account);
		} catch (IgManagementServiceException e) {
			throw new IgManagementControllerException(e.getMessage(), e);
		}

		return response;
	}

	/**
	 * @param igName
	 * @param accountName
	 * @return response as "Ig assigned to account" when ig is assigned to account
	 * @throws IgManagementControllerException when Ig is not found
	 */
	@PostMapping("/assign/{igName}/{accountName}")
	public String assignIgToAccount(@PathVariable String igName, @PathVariable String accountName)
			throws IgManagementControllerException {

		String response = "";
		try {
			response = service.assignIgToAccountDb(igName, accountName);
		} catch (IgManagementServiceException e) {
			throw new IgManagementControllerException(e.getMessage(), e);
		}
		return response;
	}

	/**
	 * @param igName
	 * @return all accounts in descending order of their revenues
	 */
	@GetMapping("/showaccounts/{igName}")
	public List<AccountDto> getAccounts(@PathVariable String igName) {

		List<AccountDto> accounts = service.getAccountsBasedOnIg(igName);

		return accounts;
	}
}
