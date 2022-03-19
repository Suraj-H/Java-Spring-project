package com.mikadosolutions.training.spring.di;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
// import org.springframework.beans.factory.annotation.Required;

public class MyDataSource {
	String driverName;
	String jdbcUrl;
	String username;
	String password;
	Properties properties;
	Connection connection;

	//@Required
	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}

	public String getJdbcUrl() {
		return jdbcUrl;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public Connection getConnection() {
		if (properties != null) {
			try {
				Class.forName((String) properties.get("driverName"));
				connection = DriverManager.getConnection((String) properties.get("jdbcUrl"), (String) properties.get("username"), (String) properties.get("password"));
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

			return connection;
		}
		else {
			try {
				Class.forName(getDriverName());
				connection = DriverManager.getConnection(getJdbcUrl(), getUsername(), getPassword());
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

			return connection;
		}
	}
}