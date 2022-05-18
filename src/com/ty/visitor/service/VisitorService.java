package com.ty.visitor.service;

import com.ty.visitor.dto.Visitor;
import com.ty.visitor.util.AESAlgo;
import static com.ty.visitor.util.AppConstatnts.SECRETE_KEY;

import com.ty.visitor.dao.VisitorDao;

public class VisitorService {
	
	VisitorDao dao = new VisitorDao();
	
	public int saveVisitor(Visitor visitor) {
		String encName = AESAlgo.encrypt(visitor.getName(), SECRETE_KEY);
		String encEmail = AESAlgo.encrypt(visitor.getEmail(), SECRETE_KEY);
		String encPhone = AESAlgo.encrypt(visitor.getPhone()+"", SECRETE_KEY);
		visitor.setName(encName);
		visitor.setEmail(encEmail);
		visitor.setPhone(encPhone);
		return dao.saveVisitor(visitor);
	}
	
	public Visitor getVisitorById(int id) {
		
		Visitor visitor = dao.getVisitorById(id);
		String decName = AESAlgo.decrypt(visitor.getName(), SECRETE_KEY);
		String decEmail = AESAlgo.decrypt(visitor.getEmail(), SECRETE_KEY);
		String decPhone = AESAlgo.decrypt(visitor.getPhone(), SECRETE_KEY);
		
		visitor.setName(decName);
		visitor.setEmail(decEmail);
		visitor.setPhone(decPhone);
		return visitor;
	}
	
}
