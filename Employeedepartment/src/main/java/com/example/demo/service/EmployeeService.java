package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Employee;

public interface EmployeeService {

	void insertingEmployee(Employee employee,String departmentsName);

	List<Employee> getEmployee12(String departmentsName);

}
