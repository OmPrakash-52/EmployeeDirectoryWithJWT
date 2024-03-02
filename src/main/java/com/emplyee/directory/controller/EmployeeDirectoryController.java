package com.emplyee.directory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emplyee.directory.Entity.EmployeeEntity;
import com.emplyee.directory.model.EmployeeModel;
import com.emplyee.directory.service.EmployeeService;

@RestController
public class EmployeeDirectoryController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/getAllEmployeeDetails")
	public ResponseEntity<List<EmployeeEntity>> getAllEmployee() {

		List<EmployeeEntity> employeelist = employeeService.getAllEmployeeDetails();
		return new ResponseEntity<List<EmployeeEntity>>(employeelist, HttpStatus.OK);

	}

	@PostMapping("/createNewEmployee")
	public ResponseEntity<String> createEntity(@RequestBody EmployeeModel employeeModel) {
		
		if(employeeModel.getPhoneNumber().length() < 10) {
			return new ResponseEntity<String>("Phone Number lenght is less than 10", HttpStatus.OK);
		}
		employeeService.createNewEmpDetails(employeeModel);
		return new ResponseEntity<String>("New employee create", HttpStatus.OK);
	}

	@PutMapping("/updateDetails")
	public ResponseEntity<String> updateEmployeeRecords(@RequestBody EmployeeModel employee) {
		
		if(employee.getPhoneNumber().length() < 10) {
			return new ResponseEntity<String>("Phone Number lenght is less than 10", HttpStatus.OK);
		}
		employeeService.updateEmployeeDetails(employee);
		return new ResponseEntity<String>("Records updated", HttpStatus.OK);
	}

	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id) {

		employeeService.DeleteById(id);
		return new ResponseEntity<String>("Employee Deleted", HttpStatus.OK);
	}
}
