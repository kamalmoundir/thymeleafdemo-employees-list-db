package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.thymeleafdemo.DAO.EmployeeRepasotory;
import com.luv2code.springboot.thymeleafdemo.entity.Employee;



@Service
public class EmployeeServiceImp implements EmployeeService {

	
	private EmployeeRepasotory theEmployeeRepasotory;
	
    @Autowired
	public EmployeeServiceImp( EmployeeRepasotory employeeRepasotory) {
    	theEmployeeRepasotory=employeeRepasotory;
	}
	
	
	
	@Override
	public List<Employee> findemployees() {
		
		return theEmployeeRepasotory.findAllByOrderByLastNameAsc();
	}

	@Override
	public Employee findEmployee(int id) {

		Optional<Employee> result = theEmployeeRepasotory.findById(id);
		
		Employee employee = null;
		
		if (result.isPresent()) {
			employee = result.get();
		}
		else {
			throw new RuntimeException("we don't find employee  :" +id);
		}
		
		return employee;
	}

	@Override
	public void saveEmployee(Employee theEmployee) {
		
		theEmployeeRepasotory.save(theEmployee);
	}

	@Override
	public void deletEmplyee(int id) {
	
		theEmployeeRepasotory.deleteById(id);;

	}

}
