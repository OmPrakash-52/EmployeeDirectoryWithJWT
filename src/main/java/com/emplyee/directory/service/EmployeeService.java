package com.emplyee.directory.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.emplyee.directory.Entity.EmployeeEntity;
import com.emplyee.directory.model.EmployeeModel;

@Component
public interface EmployeeService {

	public List<EmployeeEntity> getAllEmployeeDetails();
	
	public void createNewEmpDetails(EmployeeModel employeePayload);
	
	public EmployeeEntity findEmployeeById(Long id);
	
	public void updateEmployeeDetails(EmployeeModel employeeModel);
	
	public void DeleteById(Long id);
}
