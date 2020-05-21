package com.bhank.service;

import java.util.List;

import com.bhank.exception.BusinessException;
import com.bhank.model.Customer;
import com.bhank.model.Employee;

public interface EmployeeService {
	// create
		Employee createEmployee(Employee e) throws BusinessException;

		// update
		Employee updateEmployee(Employee e) throws BusinessException;

		// read
		List<Employee> selectAllEmployees() throws BusinessException;

		Employee selectEmployeeByNameAndPassword(String name, String Password) throws BusinessException;

		Employee selectEmployeeById(String id) throws BusinessException;

		// delete
		void deleteEmployee(Employee e) throws BusinessException;
}