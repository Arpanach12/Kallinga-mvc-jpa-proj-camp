package com.mindtree.igmanagement.service.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.igmanagement.dto.AccountDto;
import com.mindtree.igmanagement.dto.IgDto;
import com.mindtree.igmanagement.entity.Account;
import com.mindtree.igmanagement.entity.Ig;
import com.mindtree.igmanagement.entity.Project;
import com.mindtree.igmanagement.exceptions.errorconst.ErrorConst;
import com.mindtree.igmanagement.exceptions.serviceexceptions.IgManagementServiceException;
import com.mindtree.igmanagement.exceptions.serviceexceptions.InvalidIgException;
import com.mindtree.igmanagement.exceptions.serviceexceptions.TotalProjectRevenueExceedsAccountRevenueException;
import com.mindtree.igmanagement.repository.AccountRepository;
import com.mindtree.igmanagement.repository.IgRepository;
import com.mindtree.igmanagement.repository.ProjectRepository;
import com.mindtree.igmanagement.service.IgManagementService;

@Service
public class IgManagementServiceImpl implements IgManagementService {

	@Autowired
	IgRepository igRepository;

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	ProjectRepository projectRepository;

	ModelMapper modelMapper = new ModelMapper();

	public Ig convertIgDtoToEntity(IgDto igDto) {

		return modelMapper.map(igDto, Ig.class);
	}

	public Account convertAccountDtoToEntity(AccountDto accountDto) {

		return modelMapper.map(accountDto, Account.class);
	}

	public AccountDto convertAccountEntityToDto(Account account) {

		return modelMapper.map(account, AccountDto.class);
	}

	@Override
	public String insertIgInDb(IgDto ig) {

		Ig igEntity = convertIgDtoToEntity(ig);
		igRepository.save(igEntity);

		return "Ig Inserted Suucessfully";

	}

	@Override
	public String insertAccountAndProjectsToDb(AccountDto account) throws IgManagementServiceException {

		Account accountEntity = convertAccountDtoToEntity(account);

		double sum = 0;

		Set<Project> projects = accountEntity.getProjects();

		for (Project project : projects) {
			sum = sum + project.getProjectCost();
		}

		if (sum > accountEntity.getAccountRevenue()) {
			try {
				throw new TotalProjectRevenueExceedsAccountRevenueException(
						ErrorConst.TotalProjectRevenueExceedsAccountRevenue);
			} catch (TotalProjectRevenueExceedsAccountRevenueException e) {
				throw new IgManagementServiceException(e.getMessage(), e);
			}
		}

		else {
			projects.parallelStream().forEach(project -> project.setAccount(accountEntity));
			accountRepository.save(accountEntity);
		}

		return "Account and its Projects Inserted";
	}

	@Override
	public String assignIgToAccountDb(String igName, String accountName) throws IgManagementServiceException {

		Optional<Ig> ig = igRepository.findByigName(igName);

		try {
			ig.orElseThrow(() -> new InvalidIgException(ErrorConst.InvalidIg));
		} catch (InvalidIgException e) {
			throw new IgManagementServiceException(e.getMessage(), e);
		}

		Optional<Account> account = accountRepository.findByaccountName(accountName);
		Ig igEntity = ig.get();
		Account accountEntity = account.get();
		accountEntity.setIg(igEntity);

		accountRepository.save(accountEntity);

		return "Ig assigned to the Account";
	}

	@Override
	public List<AccountDto> getAccountsBasedOnIg(String igName) {

		Ig ig = igRepository.findByigName(igName).get();

		List<Account> accounts = ig.getAccounts().stream().sorted().collect(Collectors.toList());

		List<AccountDto> accountsDto = accounts.stream().map(i -> convertAccountEntityToDto(i))
				.collect(Collectors.toList());

		return accountsDto;
	}

}
