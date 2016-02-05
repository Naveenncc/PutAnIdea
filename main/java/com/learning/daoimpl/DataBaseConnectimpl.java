/*
 * This is the property of Mr.Naveen C C
 * The code may not be copied, translated or distributed
 * in any manner (electronic, web or printed) without the prior written
 * consent of Naveen C C, with the exception of properly-attributed
 * quotations and other "fair use" exemptions provided for under copyright law
 * Copyright © 2016 Naveen C C. All rights reserved.
 */
package com.learning.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The Class DataBaseConnectimpl handles connection with oracle database.
 */
public class DataBaseConnectimpl
{

	/**
	 * Connect data base.
	 *
	 * @return the connection
	 */
	public Connection connectDataBase()
	{
		try
		{

			Class.forName("oracle.jdbc.driver.OracleDriver");

		}
		catch (final ClassNotFoundException e)
		{

			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();

		}

		System.out.println("Oracle JDBC Driver Registered!");

		Connection connection = null;

		try
		{

			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl", "system", "admin");

		}
		catch (final SQLException e)
		{

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();

		}
		return connection;
	}
}
