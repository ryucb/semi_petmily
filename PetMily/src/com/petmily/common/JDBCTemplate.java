package com.petmily.common;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;



public class JDBCTemplate {
	

	//Connection 객체 생성해서 반환하는 기능
	public static Connection getConnection() {
		Connection conn=null;
		try {
			Properties prop=new Properties();
			String path=JDBCTemplate.class.getResource("/sql/driver/driver.properties").getPath();
			System.out.println(path);
			prop.load(new FileReader(path));
			Class.forName(prop.getProperty("driver"));
			conn=DriverManager.getConnection(prop.getProperty("url"),
					prop.getProperty("user"),prop.getProperty("pw"));
			conn.setAutoCommit(false);
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		return conn;
		
	}
	
	// sql연결객체를 닫아주는 기능
	public static void close(Connection conn) {
		try {
			if(conn!=null && !conn.isClosed()) {
				conn.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rs) {
		try {
			if(rs!=null && !rs.isClosed()) {
				rs.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		try {
			if(stmt!=null && !stmt.isClosed()) {
				stmt.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void commit(Connection conn) {
		try {
			if(conn!=null && !conn.isClosed()) {
				conn.commit();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn) {
		try {
			if(conn!=null && !conn.isClosed()) {
				conn.rollback();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	

}
