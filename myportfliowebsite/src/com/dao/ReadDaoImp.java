package com.dao;
import com.pojo.LoginDetails;
import com.pojo.Message;
import com.pojo.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



public class ReadDaoImp implements ReadDao {
	private String result;
	private LoginDetails l;
	
	ArrayList<Message> al = new ArrayList<Message>();
	ArrayList<Project> pl = new ArrayList<Project>();
	@SuppressWarnings("finally")
	@Override
	public ArrayList<Message> readAllMessage() {
		try {
			Connection con = ConnectionFactory.getConnection();
			String sql = "select * from myportfolio.message";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Message m = new Message();
				int sno = rs.getInt("sno");
				m.setSno(sno);
				
				String name = rs.getString("name");
				m.setName(name);
				
				String email = rs.getString("email");
				m.setEmail(email);
				
				String message = rs.getString("message");
				m.setMessage(message);
				
				al.add(m);
				
			}
		} catch (Exception e) {
			System.out.println("ReadDaoImp: readAllMessage->"+e);
		}
		finally {
			return al;
		}
		
	}
	@SuppressWarnings("finally")
	public String login(String userId, String password) {
		try {
			Connection con = ConnectionFactory.getConnection();
			String sql="select * from myportfolio.login where userId=? and password=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if (rs.next()) {
				result = "exist";
			}else {
				result="not exist";
			}
			
		} catch (Exception e) {
			System.out.println("readDaoImp: login->"+e);
			result="exp";
		}
		finally {
			return result;
		}
	}
	
	
	@SuppressWarnings("finally")
	@Override
	public LoginDetails getLoginDetails() {
		try {
			Connection con = ConnectionFactory.getConnection();
			String sql="select * from myportfolio.login";
			PreparedStatement ps = con.prepareStatement(sql);
		
			ResultSet rs=ps.executeQuery();
			rs.next();
			this.l =new LoginDetails(rs.getInt("sno"),rs.getString("userId"),rs.getString("password"));
			
		} catch (Exception e) {
			result="exp";
			System.out.println("ReadDaoImp: getLoginDetails->"+e);
		}
		finally {
			return l;
		}
		
	}
	@Override
	public ArrayList<Project> getProjectDetails() {
		try {
			Connection con = ConnectionFactory.getConnection();
			String sql="select * from myportfolio.project";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Project m = new Project(rs.getInt("sno"),rs.getString("fileName"));
				pl.add(m);
			}
		} catch (Exception e) {
			System.out.println("ReadDaoImp:getProjectDetails->"+e);
		}
		finally {
			return pl;
		}
	}
	
}

	
