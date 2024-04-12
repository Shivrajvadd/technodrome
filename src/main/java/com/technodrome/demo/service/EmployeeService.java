package com.technodrome.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technodrome.demo.dao.EmployeeRepository;
import com.technodrome.demo.entity.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getEmployee(Integer empId) {
		if(null != empId && empId > 0) {
			Optional<Employee> optEmp = employeeRepository.findById(empId);
			if(optEmp.isPresent()) {
				return Arrays.asList(optEmp.get());
			}else {
				return new ArrayList<>();
			}
		}
		
		Iterable<Employee> itrEmp = employeeRepository.findAll();
		List<Employee> allEmps = new LinkedList<>();
		if(null != itrEmp) {
			for(Employee emp: itrEmp) {
				allEmps.add(emp);
			}
		}
		return allEmps;
	}
	
	public Employee addEmployee(Employee emp) {
		
		return employeeRepository.save(emp);
	}
	
	public Employee updateEmployee(Employee emp) {
		if(null != emp && null != emp.getEmployeeId()) 
		{
		Optional<Employee> optDbEmp = employeeRepository.findById(emp.getEmployeeId());
		if(optDbEmp.isPresent()) {
			return employeeRepository.save(emp);
		}
	}
		return new Employee();
	}
	
	public void deleteEmployee(Integer empId) {
		employeeRepository.deleteById(empId);
	}
	
}
