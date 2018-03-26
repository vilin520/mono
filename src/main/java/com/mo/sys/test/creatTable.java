package com.mo.sys.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class creatTable {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");
//		String url = "jdbc:mysql://localhost:3306/mono?useUnicode=true&characterEncoding=utf-8";
//		Connection conn = DriverManager.getConnection(url, "root", "123");
//		Statement stat = conn.createStatement();
		
//		stat.executeUpdate("create database hello");
//		stat.close();
//		conn.close();
		String url = "jdbc:mysql://localhost:3306/hello?useUnicode=true&characterEncoding=utf-8";
		Connection conn = DriverManager.getConnection(url, "root", "123"); 
	    Statement stat = conn.createStatement();
	    
//	    stat.executeUpdate("create table test(id int, name varchar(80))");
//	    stat.executeUpdate("insert into test values(1, '张三')"); 
//	    stat.executeUpdate("insert into test values(2, '李四')");
	    ResultSet result = stat.executeQuery("select * from test");  
	    while (result.next()) 
	    { 
	      System.out.println(result.getInt("id") + " " + result.getString("name")); 
	    } 
	       
	    
	    result.close(); 
	    stat.close(); 
	    conn.close(); 
	}

}
