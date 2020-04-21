package com.luv2code.springboot.thymeleafdemo.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;




public interface EmployeeRepasotory extends JpaRepository<Employee, Integer> {

	
	// add a method to sort by last name 
	public List<Employee> findAllByOrderByLastNameAsc();
}
