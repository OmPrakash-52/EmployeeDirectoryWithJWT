package com.emplyee.directory.serviceImpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.emplyee.directory.Entity.EmployeeEntity;
import com.emplyee.directory.model.EmployeeModel;
import com.emplyee.directory.repository.EmployeeRepository;
import com.emplyee.directory.service.EmployeeService;

@Component
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<EmployeeEntity> getAllEmployeeDetails() {
		
		List<EmployeeEntity> employeeDetails =  employeeRepository.findAll();
		return employeeDetails;
	}

	@Override
	public void createNewEmpDetails(EmployeeModel employeePayload) {
		
		EmployeeEntity result = modelMapper.map(employeePayload,EmployeeEntity.class);	
		employeeRepository.save(result);
	}

	@Override
	public EmployeeEntity findEmployeeById(Long id) {
		return employeeRepository.findEmployeeByid(id);
		
	}

	@Override
	public void updateEmployeeDetails(EmployeeModel employeeModel) {
		EmployeeEntity result = modelMapper.map(employeeModel,EmployeeEntity.class);
		result = employeeRepository.findEmployeeByid(result.getId());
		result.setName(employeeModel.getName());
		result.setAddress(employeeModel.getAddress());
		result.setPhoneNumber(employeeModel.getPhoneNumber());
		result.setPinCode(employeeModel.getPinCode());
		employeeRepository.save(result);
	}

	@Override
	public void DeleteById(Long id) {		
		
		EmployeeEntity	result = employeeRepository.findEmployeeByid(id);
		employeeRepository.delete(result);
	}
	
	

}
