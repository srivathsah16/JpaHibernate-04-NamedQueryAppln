package com.srivath.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_Employees")
@NamedQueries(value = { @NamedQuery(name = "Employee.findAll", query = "FROM Employee e"),
		@NamedQuery(name = "Employee.findById", query = "FROM Employee e WHERE e.empId"),
		@NamedQuery(name = "Employee.fetchNameAndSalaries", query = "SELECT e.empName,e.empSalary FROM Employee e") })
@NamedQuery(name = "Employee.findBySalary", query = "FROM Employee e WHERE e.empSalary > : esal")
@NamedNativeQuery(name = "Employee.findBySalaryNative", query = "SELECT * FROM tbl_Employees WHERE eSal > ?", resultClass = Employee.class)
public class Employee {

	@Id
	@Column(name = "eId")
	private Integer empId;
	@Column(name = "eName")
	private String empName;
	@Column(name = "eSal")
	private Double empSalary;
	@Column(name = "eDeptNo")
	private Integer empDeptNo;

	public Employee() {
	}

	public Employee(Integer empId, String empName, Double empSalary, Integer empDeptNo) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
		this.empDeptNo = empDeptNo;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(Double empSalary) {
		this.empSalary = empSalary;
	}

	public Integer getEmpDeptNo() {
		return empDeptNo;
	}

	public void setEmpDeptNo(Integer empDeptNo) {
		this.empDeptNo = empDeptNo;
	}

	@Override
	public String toString() {
		return "EmployeeEntity [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + ", empDeptNo="
				+ empDeptNo + "]";
	}
}
