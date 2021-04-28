package com.mt.generatepassport.repository;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import com.mt.generatepassport.exceptions.RepositoryException;

public class GetConnection {

	public static Connection getConnection() throws RepositoryException {
		
		Connection connection = null;
		
		try {
			Properties property = new Properties();
			FileInputStream fin = new FileInputStream("F:\\eclipse-wokspace\\generatepassport\\src\\main\\java\\com\\mt\\generatepassport\\connection.properties");
			property.load(fin);
			
			String connectionUrl = property.getProperty("connectionUrl");
			String driverClass = property.getProperty("driverClass");
			String userName = property.getProperty("username");
			String password = property.getProperty("password");
			
			Class.forName(driverClass);

			connection = DriverManager.getConnection(connectionUrl, userName, password);
			fin.close();
			
		}catch(Exception e) {
			throw new RepositoryException("Connection not build", e);
		}
		return connection;
	}
}
