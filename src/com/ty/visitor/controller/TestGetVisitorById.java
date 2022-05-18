package com.ty.visitor.controller;

import com.ty.visitor.dao.VisitorDao;
import com.ty.visitor.dto.Visitor;
import com.ty.visitor.service.VisitorService;

public class TestGetVisitorById {
	public static void main(String[] args) {
		
		VisitorService service = new VisitorService();
		Visitor visitor = service.getVisitorById(1);
		System.out.println("ID is "+visitor.getId());
		System.out.println("Name is "+visitor.getName());
		System.out.println("Email is "+visitor.getEmail());
		System.out.println("Gender is "+visitor.getGender());
		System.out.println("Age is "+visitor.getAge());
		System.out.println("DOB is "+visitor.getDob());
		System.out.println("Vsisted Date Time is "+visitor.getVisitedDateTime());
		
	}
}
