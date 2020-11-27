package com.example.demoProject.service;

public class Demo {
	
	public static void main(String sdag[])
	{
		
		
		String s="java is a plateform independante language";
		char a[]= s.toCharArray();
		int length= a.length;
		Demo.methos(s,length);
		
		
	
		
		
	}
	
	
	public static void methos(String s, int length)
	{
		 
		if(length>0) {
		char a[]= s.toCharArray();
		
		System.out.println(a[length]);
		   length =length-1;
		 
		 
		Demo.methos(s,length);
		}
		else
		{
	System.out.println("out of loop");
		
		}
	}

}
