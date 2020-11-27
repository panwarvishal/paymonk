package com.example.demoProject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="EmployeeDemo")
public class Employee {
 
		@Id
		//@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int Id;
		private String name;
		private String role;
		private double salary;
				
	 
	 
		public int getId() {
			return Id;
		}
		public void setId(int id) {
			Id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public double getSalary() {
			return salary;
		}
		public void setSalary(double salary) {
			this.salary = salary;
		}
		
		
	 
		@Override
		public String toString() {
			return "Employee [Id=" + Id + ", name=" + name + ", role=" + role + ", salary=" + salary + "]";
		}
		public Employee() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
	 
}
