package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.Part;

public class InsertImp implements Insert {
	private String result;
	
	@SuppressWarnings("finally")
	@Override
	public String saveMessage(String name, String email, String message) {
		try {
			Connection con = ConnectionFactory.getConnection();
			System.out.println(con);
			String sql = "insert into myportfolio.message (name,email,message) values (?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, message);
			
			int row = ps.executeUpdate();
			
			if (row == 1) this.result = "saved";    
		} catch (Exception e) {
			System.out.println("insertDaoImp : saveMessage->"+e);
		}
		finally {
			return result;
		}
		
	}

	public String saveProject(String fileName) {
		try {
			Connection con = ConnectionFactory.getConnection();
			System.out.println(con);
			String sql = "insert into myportfolio.project (fileName) values (?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, fileName);
			
			int row = ps.executeUpdate();
			
			if (row == 1) this.result = "saved";    
		} catch (Exception e) {
			System.out.println("insertDaoImp : saveProject->"+e);
			this.result="exp";
		}
		finally {
			return result;
		}
	}
	
}
