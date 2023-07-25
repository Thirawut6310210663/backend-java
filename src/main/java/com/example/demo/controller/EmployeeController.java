package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;

@RestController
public class EmployeeController {

	private List<Employee> data = new ArrayList<Employee>();
	
	@GetMapping("/employee")
	public List<Employee> getEmployee(){
		return data;
	}
	
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee body) {
		
		for(int i = 0; i < data.size(); i++) {
			if(body.getEmployeeId() == data.get(i).getEmployeeId()) {
			return null;
			
			}
		}
		data.add(body);
		return body;
		
	}
	@GetMapping("/employee/{employeeId}")
	public Employee getEmployeeDetail(@PathVariable Integer employeeId) {
	    for (Employee employee : data) {
	        if (employeeId.equals(employee.getEmployeeId())) {
	            return employee;
	        }
	    }
	    
	    return null;
	}

	
	@PutMapping("/employee/{employeeId}")
	public Employee updateEmployee(@PathVariable Integer employeeId, @RequestBody Employee body) {
	    for (Employee employee : data) {
	        if (employeeId.equals(employee.getEmployeeId())) {
	            employee.setFirstName(body.getFirstName());
	            employee.setLastName(body.getLastName());
	            employee.setSalary(body.getSalary());
	            return employee;
	        }
	    }
	    return null;
	}

	@DeleteMapping("/employee/{employeeId}")
	public String deleteEmployee(@PathVariable Integer employeeId) {
	    for (Employee employee : data) {
	        if (employeeId.equals(employee.getEmployeeId())) {
	            data.remove(employee);
	            return "delete success";
	        }
	    }
	    return "employee not found";
	}
}



