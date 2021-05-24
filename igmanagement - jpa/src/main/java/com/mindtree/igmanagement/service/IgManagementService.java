package com.mindtree.igmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.igmanagement.dto.AccountDto;
import com.mindtree.igmanagement.dto.IgDto;
import com.mindtree.igmanagement.exceptions.serviceexceptions.IgManagementServiceException;

@Service
public interface IgManagementService {

	/**
	 * @param ig
	 * @return response as "Ig inserted Successfully" when Ig is inserted
	 */
	String insertIgInDb(IgDto ig);

	/**
	 * @param account
	 * @return response as "Account and its Projects inserted Successfully" upon insertion
	 * @throws IgManagementServiceException when projects cost is more than account revenue
	 */
	String insertAccountAndProjectsToDb(AccountDto account) throws IgManagementServiceException;

	/**
	 * @param igName
	 * @param accountName
	 * @return response as "Ig assigned to account" when ig is assigned to account
	 * @throws IgManagementServiceException when  Ig is not found
	 */
	String assignIgToAccountDb(String igName, String accountName) throws IgManagementServiceException;

	/**
	 * @param igName
	 * @return all accounts in descending order of their revenues
	 */
	List<AccountDto> getAccountsBasedOnIg(String igName);

	

}
