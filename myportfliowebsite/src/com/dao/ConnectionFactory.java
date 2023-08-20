package com.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.cj.jdbc.MysqlDataSource;

public class ConnectionFactory {
	private static Connection con;

	@SuppressWarnings("finally")
	public static Connection getConnection() throws Exception {
		// connection pool mechanism
		try {
			MysqlDataSource ds = new MysqlDataSource();

			// oracle data source

			ds.setUrl("jdbc:mysql://localhost:3306");
			ds.setUser("root");
			ds.setPassword("");

			con = ds.getConnection();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("connection" + e);
		} finally {
			return con;
		}
		

	}
}
