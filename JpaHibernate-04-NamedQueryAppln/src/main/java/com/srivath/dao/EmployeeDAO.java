package com.srivath.dao;

import java.util.List;

import com.srivath.entity.Employee;

public interface EmployeeDAO {

	Employee findById(Integer empId);

	List<Employee> findAll();

	List<Object[]> fetchNameAndSalaries();

	List<Employee> findBySalary(Double salary);

	List<Employee> findBySalaryNative(Double salary);

	List<Employee> executeCriteriaQuery(Double sal1,Double sal2);
}
