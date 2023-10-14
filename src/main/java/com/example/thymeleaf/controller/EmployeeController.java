package com.example.thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.thymeleaf.entity.Employee;
import com.example.thymeleaf.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping({"/list", "/"})
	public ModelAndView getAllEmployees() {
		ModelAndView mav = new ModelAndView("list-employees");
		mav.addObject("employees", service.findAll());
		return mav;
	}
	
	@GetMapping("/addEmployeeForm")
	public ModelAndView addEmployeeForm() {
		ModelAndView mav = new ModelAndView("add-employee-form");
		Employee newEmployee = new Employee();
		mav.addObject("employee", newEmployee);
		return mav;
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute Employee employee) {
		service.save(employee);
		return "redirect:/list";
	}
	
	@GetMapping("/showUpdateForm")
	public ModelAndView showUpdateForm(@RequestParam String employeeId) {
		ModelAndView mav = new ModelAndView("add-employee-form");
		Employee employee = service.findById(employeeId);
		mav.addObject("employee", employee);
		return mav;
	}
	
	@GetMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam String employeeId) {
		service.deleteById(employeeId);
		return "redirect:/list";
	}
}
