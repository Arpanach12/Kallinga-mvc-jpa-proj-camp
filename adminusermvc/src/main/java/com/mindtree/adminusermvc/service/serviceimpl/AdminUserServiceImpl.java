package com.mindtree.adminusermvc.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.adminusermvc.entity.Person;
import com.mindtree.adminusermvc.exception.AdminUserServiceException;
import com.mindtree.adminusermvc.repository.PersonRepository;
import com.mindtree.adminusermvc.service.AdminUserService;

@Service
public class AdminUserServiceImpl implements AdminUserService{

	@Autowired
	private PersonRepository personRepository;

	@Override
	public String findRole(String personName, String personPassword) throws AdminUserServiceException {
	
		String role = "";
		Person person = personRepository.findBypersonName(personName).orElseThrow(()->new AdminUserServiceException("User Not Found"));
		
		if(person.getPersonPassword().equals(personPassword)) {
			if(person.getPersonRole().equalsIgnoreCase("user")) {
				role = role  + "KALINGA";
			}
			else
				role = role+"MINDTREE";
		}
		else
			throw new AdminUserServiceException("User Not Found");
		
		return role;
	}

	@Override
	public void insertUser(Person person) {
		
		personRepository.save(person);
		
	}

	
	
}
