package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService theEmployeeService;

	public EmployeeController(EmployeeService employeeService) {
		theEmployeeService = employeeService;

	}

	// add mapping for list
	@GetMapping("/list")
	public String listEmp(Model model) {

		// get employees from the data base
		List<Employee> employees = theEmployeeService.findemployees();

		model.addAttribute("employees", employees);
		return "employees/emplyees-list";
	}

	@GetMapping("/ShowEmployeeForm")
	public String showForm(Model theModel) {

		// create model attribute to bind form data
		Employee theEmployee = new Employee();

		
		theModel.addAttribute("employee", theEmployee);
		return "employees/employee-form";
	}
	
	
	@GetMapping("/ShowUpdateForm")
	public String showUpdateForm(@RequestParam("employeeId") int theid,Model theModel) {

		//get the employee from service
		Employee theEmployee=theEmployeeService.findEmployee(theid);
		//add the employee to the attribute
		theModel.addAttribute("employee",theEmployee);
        //send over to our form
		
		theModel.addAttribute("employee", theEmployee);
		return "employees/employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		
		//save the employee
		theEmployeeService.saveEmployee(theEmployee);
		
		//use a redirect to prevent duplicate submission
		
		return "redirect:/employees/list";
	}
	
  @GetMapping("/DeleteEmployee")
   public String deleteEmp(@RequestParam("employeeId") int theid) {
	  
	  theEmployeeService.deletEmplyee(theid);
	  
	  return "redirect:/employees/list";
  }
	
	
	
	
	
}
