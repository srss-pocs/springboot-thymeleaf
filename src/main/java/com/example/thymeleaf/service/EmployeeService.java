package com.example.thymeleaf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.thymeleaf.entity.Employee;
import com.example.thymeleaf.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	public void save(Employee employee) {
		employeeRepository.save(employee);
	}

	public Employee findById(String employeeId) {
		return employeeRepository.findById(employeeId).get();
	}

	public void deleteById(String employeeId) {
		employeeRepository.deleteById(employeeId);
	}

}
