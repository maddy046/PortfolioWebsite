package com.dao;

import java.sql.Connection;
import java.sql.Statement;

public class Create {
		public static boolean createDatabase() {
			try {
				Connection con = ConnectionFactory.getConnection();
				Statement st = con.createStatement();
				boolean execute = st.execute("create database myportfoliox");
				return execute;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}	
			
		}
		
		public static boolean createTable() {
			boolean execute= false;
			try {
				Connection con = ConnectionFactory.getConnection();
				Statement st = con.createStatement();
				String sql="create table myportfoliox.project(sn int primary key, filename varchar(50))";
				execute = st.execute(sql);
			} catch (Exception e) {
				System.out.println(e);
			}	
			finally {
				return execute;
			}
		}
		
		public static void distroy() {
			try {
				Connection con = ConnectionFactory.getConnection();
				Statement st = con.createStatement();
				String sql="drop database myportfoliox";
				st.execute(sql);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
}
