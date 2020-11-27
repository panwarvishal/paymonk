package com.example.demoProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoProject.model.ApiResponse;
import com.example.demoProject.model.Employee;
import com.example.demoProject.repo.repoEmployee;
import com.example.demoProject.service.Demo;
import com.example.demoProject.service.EmployeeServiceClass;


@RestController
public class AllControllerClass {
	
	@Autowired EmployeeServiceClass employeeServiceClass;
	@Autowired repoEmployee repo;
	
////////////////////////////////////////////////------ Save API-----/////////////////////////////////////////////////////////
	
	
	@PostMapping("/saveData")
	public String savedataMethod(@RequestBody String payload )  throws Exception {
		return employeeServiceClass.saveEmployee(payload);
	                       
	}

////////////////////////////////////////////////------ Delete APIs-----/////////////////////////////////////////////////////////
		@DeleteMapping("/deleteData/{id}")
	public String deleteEmployeeMethod(@PathVariable("id") int id)throws Exception
	{
			 return		employeeServiceClass.deleteOneEmployee(id);
     
      
	}
	 
	
	////////////////////////////////////////////////------ Get APIs-----/////////////////////////////////////////////////////////
	
	  @GetMapping("/getData")
		public  List<Employee>  getAllEmpDataMethod()throws Exception
		{
		  
		   	  
		  
			 return repo.findAll();
		}
	  
	  @GetMapping("/getData/{id}")
			public   ApiResponse  getEmpDataMethod(@PathVariable("id") int id)throws Exception
			{
				 return employeeServiceClass.getEmployee(id) ;
			}
		  
	  
	  
////////////////////////////////////////////////------ Update APIs-----/////////////////////////////////////////////////////////
			@PutMapping("/updateData")
	public String updatedataMethod(@RequestBody String payload )  throws Exception
	{
		return employeeServiceClass.updateEmployee(payload);
  	}
	
	
	 
	  
			public static void methos(String s, int length)
			{
				 
				if(length>0) {
				char a[]= s.toCharArray();
				
				System.out.println(a[length-1]);
				   length =length-1;
				 
				 
				Demo.methos(s,length);
				}
				else
				{
			System.out.println("out of loop");
				
				}
			}
	
	
	
	
}
