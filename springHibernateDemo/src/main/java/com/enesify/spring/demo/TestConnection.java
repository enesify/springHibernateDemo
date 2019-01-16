package com.enesify.spring.demo;

import java.lang.invoke.MethodHandles;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import oracle.jdbc.pool.OracleDataSource;

public class TestConnection {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	private static Connection con;

	public static void main(String[] args) throws SQLException {

		String oracleDbConnectionString = "jdbc:oracle:thin:@(DESCRIPTION = (ADDRESS = (PROTOCOL = TCP)(HOST = oradb-ao.thyteknik.local)(PORT = 1521))(CONNECT_DATA = (SERVER = default)(SERVICE_NAME = TEST)))";
		
		OracleDataSource oracleDataSource = new OracleDataSource();
        oracleDataSource.setURL(oracleDbConnectionString);
        oracleDataSource.setUser("ENES");
        oracleDataSource.setPassword("enes");
        
        
        try {
			con = oracleDataSource.getConnection();
			LOGGER.info("Connection established!");
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		
	
        
	}

}
