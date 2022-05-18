package com.ty.visitor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.ty.visitor.dto.Visitor;
import com.ty.visitor.util.AESAlgo;
import com.ty.visitor.util.ConnectionObject;
import static com.ty.visitor.util.AppConstatnts.SECRETE_KEY;

public class VisitorDao {
	
	public int saveVisitor(Visitor visitor) {
		int resultCount = 0;
		String sql = "INSERT INTO visitor VALUES(?,?,?,?,?,?,?,?)";
		Connection connection = ConnectionObject.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, visitor.getId());
			preparedStatement.setString(2, visitor.getName());
			preparedStatement.setString(3, visitor.getEmail());
			preparedStatement.setString(4, visitor.getPhone()+"");
			preparedStatement.setInt(5, visitor.getAge());
			preparedStatement.setString(6, visitor.getGender());
			preparedStatement.setString(7, visitor.getDob().toString());
			preparedStatement.setString(8, visitor.getVisitedDateTime().toString());
			resultCount = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return resultCount;
	}
	
	public Visitor getVisitorById(int id) {
		String sql = "SELECT * FROM visitor WHERE id = ?";
		Connection connection = ConnectionObject.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				Visitor visitor = new Visitor();
				visitor.setId(resultSet.getInt(1));
				visitor.setName(resultSet.getString(2));
				visitor.setEmail(resultSet.getString(3));
				visitor.setPhone(resultSet.getString(4));
				visitor.setAge(resultSet.getInt(5));
				visitor.setGender(resultSet.getString(6));
				
				DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String date = resultSet.getString(7);
				LocalDate dob = LocalDate.parse(date, dateTimeFormatter);
				visitor.setDob(dob);
				
				dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				String dateTime = resultSet.getString(8);
				LocalDateTime localDateTime = LocalDateTime.parse(dateTime, dateTimeFormatter);
				visitor.setVisitedDateTime(localDateTime);
				
				
				return visitor;
			} else {
				return null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<Visitor> getAllVisitor() {
		return null;
	}
	
	public List<Visitor> getVisitorByDate() {
		return null;
	}
	
	public List<Visitor> getVisitorByAgeRange(int startAge,int endAge) {
		return null;
	}
	
}
