package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;



public interface EmployeeService {
	
	public List<Employee> findemployees();

	public Employee findEmployee(int id);

	public void saveEmployee(Employee theEmployee);

	public void deletEmplyee(int id);

}
