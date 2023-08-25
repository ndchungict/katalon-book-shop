package com.chungnd.utils

import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement
import com.kms.katalon.core.annotation.Keyword

public class DatabaseManger {
	private static Connection connection = null;

	/**
	 * Open and return a connection to oracle database
	 * @return an instance of connection
	 */

	@Keyword
	def connectOracleDB(String url, String port,String dbName,String dbUsername, String dbPassword) {

		String conn = "jdbc:oracle:thin:@" + url + ":" + port + "/" + dbName

		if(connection != null && !connection.isClosed()){
			connection.close()
		}

		connection = DriverManager.getConnection(conn, dbUsername, dbPassword)

		return connection
	}

	/**
	 * execute a SQL query on database
	 * @param queryString SQL query string
	 * @return a reference to returned data collection
	 */

	@Keyword
	def executeQuery(String queryString) {

		Statement stm = connection.createStatement()

		ResultSet rs = stm.executeQuery(queryString)

		return rs
	}

	def executeUpdate(String queryString) {

		Statement stm = connection.createStatement()

		int result = stm.executeUpdate(queryString)

		assert result >= 1
	}

	@Keyword
	def closeDatabaseConnection() {

		if(connection != null && !connection.isClosed()){
			connection.close()
		}

		connection = null
	}

	/**
	 * Execute non-query (usually INSERT/UPDATE/DELETE/COUNT/SUM...) on database
	 * @param queryString a SQL statement
	 * @return single value result of SQL statement
	 */

	@Keyword
	def execute(String queryString) {

		Statement stm = connection.createStatement()

		boolean result = stm.execute(queryString)

		return result
	}
}
