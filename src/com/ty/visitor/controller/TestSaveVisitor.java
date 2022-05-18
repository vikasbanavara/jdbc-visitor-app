package com.ty.visitor.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.ty.visitor.dao.VisitorDao;
import com.ty.visitor.dto.Visitor;
import com.ty.visitor.service.VisitorService;

public class TestSaveVisitor {
	public static void main(String[] args) {
		Visitor visitor = new Visitor();
		visitor.setId(7);
		visitor.setName("Virat");
		visitor.setEmail("virat@mail.com");
		visitor.setGender("male");
		visitor.setPhone(77115333l+"");
		visitor.setAge(24);
		visitor.setDob(LocalDate.now());
		visitor.setVisitedDateTime(LocalDateTime.now());
		
		VisitorService service = new VisitorService();
		
		int result = service.saveVisitor(visitor);
		if(result > 0) {
			System.out.println("Data saved");
		} else {
			System.out.println("Somthing went wrong");
		}
	}
}
