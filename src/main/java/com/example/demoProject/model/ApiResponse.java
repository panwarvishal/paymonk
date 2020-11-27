package com.example.demoProject.model;

import java.io.Serializable;

public class ApiResponse implements Serializable {

	 
	private String status;
	private String errorMsg;
	private Employee employeedata;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public Employee getEmployeedata() {
		return employeedata;
	}
	public void setEmployeedata(Employee employeedata) {
		this.employeedata = employeedata;
	}
	
	

	
	 
	
	
}
