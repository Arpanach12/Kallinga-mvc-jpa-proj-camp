package com.example.demo.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	DepartmentService departmentservice;
	
	@Autowired
	EmployeeService employeeservice;
	
	@RequestMapping("/")
	public String link1() {
		return "home";
	}
	@RequestMapping("adddepartment")
	public String link2() {
		return "adddepartment";
	}
	
	@PostMapping("insertdepartment")
	public String insertsDepartment(Department department) {
		departmentservice.insertingDepartment(department);
		return "home";
	}
	@RequestMapping("/addemployee")
	public String link2(Model model) {
		List<Department> department=departmentservice.getDepartment();
		model.addAttribute("deplist",department);
		return "addemployee";
	}
	
	@PostMapping("insertemployee")
	public String insertsEmployee(Employee employee,String departmentsName) {
		employeeservice.insertingEmployee(employee,departmentsName);
		return "home";
	}
	
	@RequestMapping("display")
	public String link3(Model model) throws Exception {
		List<Department> department=departmentservice.getdepartment12();
		List<Department> result = new ArrayList<Department>();
		// serialization
				FileOutputStream file = new FileOutputStream("file.txt");
				ObjectOutputStream obj = new ObjectOutputStream(file);
				obj.writeObject(department);
				obj.flush();
				obj.close();
				file.close();

				// Dserialization

				FileInputStream filein = new FileInputStream("file.txt");
				ObjectInputStream objin = new ObjectInputStream(filein);
				result = (List<Department>) objin.readObject();
				System.out.println(result);
				objin.close();
				filein.close();

			
		model.addAttribute("deplist12",department);
		return "display";
	}
	
	
	@RequestMapping("displayemployee")
	public String getemployee(String departmentsName,Model model) {
		List<Employee> employee=employeeservice.getEmployee12(departmentsName);
		model.addAttribute("employeeslists",employee);
		return "display";
	}
}
