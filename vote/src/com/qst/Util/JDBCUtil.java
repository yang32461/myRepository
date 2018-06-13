package com.qst.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	private static String DRIVER="com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/vote?characterEncoding=utf-8";
	private static String USERNAME="root";
	private static String PASSWORD="qst";
	static Connection conn=null;

	public static Connection getConnection(){
		 try {
	    	 //获取驱动器
			Class.forName(DRIVER);
			//建立数据库连接
			 conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public static void close(ResultSet rs,Statement stat,Connection conn){
		try {
			if(rs !=null){
				rs.close();
			}
			if(stat != null){
				stat.close();
			}
			if(conn !=null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
