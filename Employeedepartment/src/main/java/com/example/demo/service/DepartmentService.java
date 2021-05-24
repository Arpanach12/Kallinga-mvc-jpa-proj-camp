package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Department;

public interface DepartmentService {

	void insertingDepartment(Department department);

	List<Department> getDepartment();

	List<Department> getdepartment12();

}
