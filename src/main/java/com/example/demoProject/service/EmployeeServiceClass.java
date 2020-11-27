package com.example.demoProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoProject.model.ApiResponse;
import com.example.demoProject.model.Employee;
import com.example.demoProject.repo.repoEmployee;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class EmployeeServiceClass {

	@Autowired repoEmployee repoEmployee;
	ObjectMapper mapper = new ObjectMapper();

	////////////////////////////////////////////////////////////////////////
	public ApiResponse getEmployee(int id) throws Exception
	{
		ApiResponse apiResponse= new ApiResponse();
		
		if(repoEmployee.existsById(id)==false)
		{
			apiResponse.setErrorMsg("There is no Employee with id --"+ id);
			apiResponse.setStatus("NO DATA FOUND");
		
		}
		else
		{
			apiResponse.setStatus("success");
			apiResponse.setEmployeedata(repoEmployee.findById(id).orElse(null));
		}
		
		return apiResponse;
	}
	
	
	/////////////////////////////////////////////////////////////////////
	public String saveEmployee(String payload) throws Exception
	{
		
		JsonNode actualObj = mapper.readTree(payload);
	    Employee employee= new Employee();
	    
	    JsonNode jsonNode1 = actualObj.get("id");
	    JsonNode jsonNode2 = actualObj.get("name");
	    JsonNode jsonNode3 = actualObj.get("role");
	    JsonNode jsonNode4 = actualObj.get("salary");
	    
		   if(repoEmployee.existsById(actualObj.get("id").intValue())==false)
		   {	    
	   employee.setId(jsonNode1.intValue());
	    employee.setName(jsonNode2.textValue());
	    employee.setRole(jsonNode3.textValue());
	    employee.setSalary(jsonNode4.asDouble());

	    repoEmployee.save(employee);
	 
	    return "                   One more  employee succesfully joined Paymonk Company   ";
		   }
		else
		{
		return " ERROR MESSAGE ------ There is already entry in database with ID -   "+actualObj.get("id").intValue();
		}
	}
	
	
	////////////////////////////////////update service//////////////////////////////////////////
	
 	
	public String updateEmployee(String payload) throws Exception
	{

		
		JsonNode actualObj = mapper.readTree(payload);
	    Employee employee= new Employee();
	    
	    JsonNode jsonNode1 = actualObj.get("id");
	    JsonNode jsonNode2 = actualObj.get("name");
	    JsonNode jsonNode3 = actualObj.get("role");
	    JsonNode jsonNode4 = actualObj.get("salary");
	    
		   if(repoEmployee.existsById(actualObj.get("id").intValue())==true)
		   {	    
	   employee.setId(jsonNode1.intValue());
	    employee.setName(jsonNode2.textValue());
	    employee.setRole(jsonNode3.textValue());
	    employee.setSalary(jsonNode4.asDouble());

	    repoEmployee.save(employee);
	 
	    return "                      Data is updated at ID -    "+actualObj.get("id").intValue();
		   }
		else
		{
		return " There is no data to update at ID   "+actualObj.get("id").intValue();
		}
	}
	
	/////////////////////////////////////////////////delete service///////////////////////////////////
	
 
	
	
	
	public String deleteOneEmployee(int id) throws Exception
	{
		
		if(repoEmployee.existsById(id)==false)
		{
			return "              ERROR MESSAGE-  There is no Employee data with ID - "+id+". Please enter some data";
		}
		else
		repoEmployee.deleteById(id);;
	     return "       Employees data with id -- "+id+" is deleted";

	}
	////////////////////
	
	
	
}
