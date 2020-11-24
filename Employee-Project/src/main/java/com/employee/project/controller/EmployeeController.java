package com.employee.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.project.entity.Employee;
import com.employee.project.repository.EmployeeRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		
		return employeeRepository.findAll();
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		
		return employeeRepository.save(employee);
	}
	
	@GetMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Employee id: " + id + " doesn't exists."));
		
		return employee;
	}
	
	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@PathVariable int id,@RequestBody Employee theEmployee){
		
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Employee id: " + id + " doesn't exists."));
		
		employee.setName(theEmployee.getName());
		employee.setSalary(theEmployee.getSalary());
		employee.setDateOfJoining(theEmployee.getDateOfJoining());
		employee.setParmanent(theEmployee.isParmanent());
		employee.setDesignation(theEmployee.getDesignation());
		employee.setProfilePic(theEmployee.getProfilePic());
		employee.setResume(theEmployee.getResume());
		
		return employeeRepository.save(employee);
	}
	
	@DeleteMapping("/employees/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable int id) {
		
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Employee id: " + id + " doesn't exists."));
		
		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		return response;
	}
	
}