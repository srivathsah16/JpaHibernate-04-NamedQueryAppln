package com.srivath.client;

import java.util.List;

import com.srivath.dao.EmployeeDAO;
import com.srivath.dao.impl.EmployeeDaoImpl;
import com.srivath.entity.Employee;

public class Tester {
	public static void main(String[] args) {
		EmployeeDAO dao = new EmployeeDaoImpl();

		/*
		 * findById()
		 */
//		System.out.println(dao.findById(787));

		/*
		 * findAll()
		 */
//		List<Employee> empList = dao.findAll();
//		empList.stream().forEach(System.out::println);
//		System.out.println("Employees whose salary > 8000");
//		empList.stream().filter(emp -> emp.getEmpSalary()>8000).forEach(System.out::println);

		/*
		 * fetchNameAndSalaries()
		 */
//		List<Object[]> nameList = dao.fetchNameAndSalaries();
//		nameList.stream().forEach(obj -> {
//			System.out.println("name=" + obj[0] + ", salary=" + obj[1]);
//		});

		/*
		 * findBySalary()
		 */
//		List<Employee> employees = dao.findBySalary(8900.0);
//		employees.stream().map(emp -> emp.getEmpName() + " " + emp.getEmpSalary()).forEach(System.out::println);

		/*
		 * findBySalaryNative()
		 */
//		List<Employee> emplList = dao.findBySalaryNative(7900.0);
//		emplList.stream().map(e -> "name = "+ e.getEmpName() + ", salary = " + e.getEmpSalary()).forEach(System.out::println);

		/*
		 * executeCriteriaQuery()
		 */
		List<Employee> employees = dao.executeCriteriaQuery(5000d, 6500d);
		//System.out.println("Employees with salary > 8999 is");
		employees.stream().map(e -> e.getEmpName() + " " + e.getEmpSalary()).forEach(System.out::println);
	}
}
