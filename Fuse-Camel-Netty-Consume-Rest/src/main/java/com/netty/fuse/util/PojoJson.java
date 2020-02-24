package com.netty.fuse.util;

public class PojoJson {

	private String empId;

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	private String name;
	private String designation;
	private String salary;

	public PojoJson() {
	}

	public PojoJson(String access_token, int expires_in, int refresh_expires_in, String refresh_token, String scope) {

	}

	@Override
	public String toString() {
		return "Token [empId=" + empId + ", name=" + name + ", designation=" + designation + ", salary=" + salary + "]";
	}

}
