package com.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {
    private  static Connection connect=null;
    private static Statement statement =null;
    private static PreparedStatement preparedStatement=null;
    private  static ResultSet resultSet=null;
    
    public static Statement getConnection() {
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    		try {
    			connect=DriverManager.getConnection("jdbc:mysql://localhost/gsb_frais?user=root&password=");
    			statement =connect.createStatement();
    			return statement;
    		}catch (SQLException e) {
    		e.printStackTrace();
    		}
    	}catch(ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    	  return null;
    }
    
    public static void closeConnection() {
    	try {
			connect.close();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

	}



