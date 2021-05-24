package com.mindtree.adminusermvc.service;

import com.mindtree.adminusermvc.entity.Person;
import com.mindtree.adminusermvc.exception.AdminUserServiceException;

public interface AdminUserService {

	String findRole(String personName, String personPassword) throws AdminUserServiceException;

	void insertUser(Person person);


}
