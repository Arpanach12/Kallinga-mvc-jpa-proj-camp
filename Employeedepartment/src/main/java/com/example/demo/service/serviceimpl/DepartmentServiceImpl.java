package com.example.demo.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.DepartmentService;
@Service
public class DepartmentServiceImpl implements DepartmentService {
@Autowired
EmployeeRepository employeerepository;
@Autowired
DepartmentRepository departmentrepository;
	@Override
	public void insertingDepartment(Department department) {
		departmentrepository.save(department);
		
	}
	@Override
	public List<Department> getDepartment() {
		List<Department> dep=departmentrepository.findAll();
		return dep;
	}
	@Override
	public List<Department> getdepartment12() {
		List<Department> de=departmentrepository.findAll();
		return de;
	}

}
