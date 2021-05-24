package com.example.demo.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository employeerepository;
	@Autowired
	DepartmentRepository departmentrepository;
	
	@Override
	public void insertingEmployee(Employee employee,String departmentsName) {
		List<Department> dep=departmentrepository.findAll();
		List<Employee> employees=new ArrayList<Employee>();
		Department de=new Department();
		
		//employees.add(employee);
		for (Department department : dep) {
			if(department.getDepartmentName().equals(departmentsName)) {
				de=department;
			}
			employee.setDepartment(de);
		}
		
		
		employeerepository.save(employee);
		
	}

	@Override
	public List<Employee> getEmployee12(String departmentsName) {
		List<Department> dep=departmentrepository.findAll();
		List<Employee> employees=new ArrayList<Employee>();
		for (Department department : dep) {
			if(department.getDepartmentName().equals(departmentsName)) {
				employees=department.getEmployeeList();
			}
			
		}
		
		return employees;
	}

}
