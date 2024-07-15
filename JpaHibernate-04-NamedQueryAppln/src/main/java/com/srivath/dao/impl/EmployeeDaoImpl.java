package com.srivath.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.srivath.dao.EmployeeDAO;
import com.srivath.entity.Employee;

public class EmployeeDaoImpl implements EmployeeDAO {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");

	@Override
	public Employee findById(Integer empId) {
		EntityManager entityManager = factory.createEntityManager();
		TypedQuery<Employee> query = entityManager.createNamedQuery("Employee.findById", Employee.class);
		query.setParameter("eid", empId);
		Employee emp = query.getSingleResult();
		entityManager.close();
		return emp;
	}

	@Override
	public List<Employee> findAll() {
		EntityManager entityManager = factory.createEntityManager();
		TypedQuery<Employee> query = entityManager.createNamedQuery("Employee.findAll", Employee.class);
		List<Employee> list = query.getResultList();
		entityManager.close();
		return list;
	}

	@Override
	public List<Object[]> fetchNameAndSalaries() {
		EntityManager entityManager = factory.createEntityManager();
		TypedQuery<Object[]> query = entityManager.createNamedQuery("Employee.fetchNameAndSalaries", Object[].class);
		List<Object[]> nameSalaryList = query.getResultList();
		entityManager.close();
		return nameSalaryList;
	}

	@Override
	public List<Employee> findBySalary(Double salary) {
		EntityManager entityManager = factory.createEntityManager();
		/*
		 * Namedquery
		 */
		TypedQuery<Employee> query = entityManager.createNamedQuery("Employee.findBySalary", Employee.class);
		query.setParameter("esal", salary);
		List<Employee> employeeList = query.getResultList();
		return employeeList;
	}

	@Override
	public List<Employee> findBySalaryNative(Double salary) {
		EntityManager entityManager = factory.createEntityManager();
		/*
		 * NamedNativeQuery
		 */
		TypedQuery<Employee> typedQuery = entityManager.createNamedQuery("Employee.findBySalaryNative", Employee.class);
		typedQuery.setParameter(1, salary);
		List<Employee> employees = typedQuery.getResultList();
		return employees;
	}

	@Override
	public List<Employee> executeCriteriaQuery(Double sal1,Double sal2) {
		EntityManager em = factory.createEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
		Root<Employee> root = cq.from(Employee.class);
		cq.select(root).where(cb.between(root.get("empSalary"), sal1, sal2));
		List<Employee> list = em.createQuery(cq).getResultList();
		return list;
	}
}
