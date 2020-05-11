package com.ploutos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.ploutos.exception.BusinessException;

public class PloutosConnection {
	final static Logger L = Logger.getLogger(PloutosConnection.class);
	private static Connection c = null;
	
	private PloutosConnection() {
		
	}
	
	public static Connection getConnection() throws BusinessException, SQLException {
		String url = System.getenv("JURL");
		String username = System.getenv("JUSERNAME");
		String password = System.getenv("JPASSWORD");
		
		//TODO remove this before pushing

		
		c = DriverManager.getConnection(url, username, password);
		return c;
	}
	
	
}
