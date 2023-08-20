package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateDaoImp implements UpdateDao {
	private String result;
	@Override
	public String updateCredentials(String userId, String password) {
		try {
			Connection con = ConnectionFactory.getConnection();
			String sql="update myportfolio.login set userid=? , password=? where sno=1";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, password);
			
			int row = ps.executeUpdate();
			if (row==1) {
				result="updated";
			}
		} catch (Exception e) {
			System.out.println("UpdateDaoImp: updateCredentials"+e);
			result="exp";
		}
		
		finally {
			return result;
		}
		
	}
	
}
