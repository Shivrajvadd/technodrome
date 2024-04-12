package com.technodrome.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.technodrome.demo.entity.Employee;
import com.technodrome.demo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/get")
	public List<Employee> getEmployee(@RequestParam(name = "empid", required = false) Integer empId) {
		
	return employeeService.getEmployee(empId);
	}
	
	@PostMapping("/add")
	public Employee addEmployee(@RequestBody Employee emp) {
		return employeeService.addEmployee(emp);
	}
	
	@PutMapping("/update")
	public Employee updateEmployee(@RequestBody Employee emp) {
		return employeeService.updateEmployee(emp);
	}

	@DeleteMapping("/delete/{empid}")
	public Boolean deleteEmployee(@PathVariable(name = "empid") Integer empId) {
		employeeService.deleteEmployee(empId);
		return true;
	}
}
