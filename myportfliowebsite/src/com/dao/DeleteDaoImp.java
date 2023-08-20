package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import com.pojo.Message;

public class DeleteDaoImp implements DeleteDao {
	private String result;
	@Override
	public String deleteMessage(int sno) {
		try {
			Connection con = ConnectionFactory.getConnection();
			String sql="delete from myportfolio.message where sno=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, sno);
			int i = ps.executeUpdate();
			if(i==1) result ="deleted";
			
		} catch (Exception e) {
			System.out.println("DeleteDaoImp->"+e);
			result="exp";
		}
		
		finally {
			return result;
		}
		
	}
	@Override
	public String deleteProject(int sno) {
		try {
			Connection con = ConnectionFactory.getConnection();
			String sql="delete from myportfolio.project where sno=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, sno);
			int i = ps.executeUpdate();
			if(i==1) result ="deleted";
			
		} catch (Exception e) {
			System.out.println("DeleteDaoImp: deleteProject->"+e);
			result="exp";
		}
		
		finally {
			return result;
		}
	}



}
