package com.axis.pms.productDao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtill {

	public static Connection getDBConnection() {
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String userName = "system";
		String passward = "Abhi1234";
		Connection con = null ;
		try {
			if(con == null) {
			//register the driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//make the connection 
			con = DriverManager.getConnection(url, userName, passward);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con ;
	}
}
