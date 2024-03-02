package com.emplyee.directory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.emplyee.directory.Entity.EmployeeEntity;


public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

	@Query("from EmployeeEntity where id=:id")
	public EmployeeEntity findEmployeeByid(@Param("id") Long id);
}
