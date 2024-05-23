package week13;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

public class Main {
	private static Connection dbConnection;

	public static void main(String[] args) throws SQLException {
		//connect to the database
		final String DATABASE_URL = "jdbc:sqlserver://localhost;"
				+ "databaseName=PREMIERECO;integratedSecurity=true;encrypt=true;TrustServerCertificate=true";

		Savepoint savepoint0 = null; 
		try {
			dbConnection = DriverManager.getConnection(DATABASE_URL);

			dbConnection.setAutoCommit(false);
			System.out.println("connected successfully");
			System.out.println();

			System.out.println("Here is my whole database...");
			
			//send all the table names to get their data
			processTables(Arrays.asList("CUSTOMER", "EMPLOYEE", "ORDER_LINE", "ORDERS", "PART", "SALESREP"));

			//displaying the preparedstatement
			System.out.println("Watch how I use a PreparedStatement!");
			
			PreparedStatement pstmt =  dbConnection.prepareStatement("SELECT * FROM CUSTOMER WHERE REP_NUM > ?");
			pstmt.setInt(1, 20);
			ResultSet res = pstmt.executeQuery();
			
			while (res.next()) {
	            int rep = res.getInt("REP_NUM");
	            System.out.println(rep);
	        }
			
			System.out.println();
			
			//using savepoints and rollbacks
			System.out.println("Now I will show you how to use savepoints and rollback...");
			Statement stmt = dbConnection.createStatement();
			
			savepoint0 = dbConnection.setSavepoint("SavePoint0");
			
			String sql1 = "UPDATE PART SET UNITS_ON_HAND = 700 WHERE PART_NUM = 1";
			stmt.executeUpdate(sql1);
			
			String sql2 = "INSERT INTO ORDER_LINE values (1, 50, 7.90, 6657.9, '2024-02-27')";
			stmt.executeUpdate(sql2);
			dbConnection.commit();
			dbConnection.close();
			System.out.println("Query into the database worked");

		} catch (SQLException sqlE) {
			System.out.println("I am rolling back...");
			// If there is any error.
			dbConnection.rollback(savepoint0);
		}
	}

	private static void processTables(List<String> tables) throws SQLException {
		// call the gettabledata method for each indiv table
		for (String tableName : tables) {
			ResultSet res = getTableData(tableName);
			printTableData(res, tableName);
			System.out.println();
			res.close();
		}

	}

	private static ResultSet getTableData(String tableName) throws SQLException {
		// get all the table data into a result set
		Statement stmt = dbConnection.createStatement();
		String sql = "SELECT * FROM " + tableName;
		return stmt.executeQuery(sql);
	}

	private static void printTableData(ResultSet res, String tableName) throws SQLException {
		// print out all the info with resultsetmetadata
		ResultSetMetaData rsMeta = res.getMetaData();

		// print table name
		System.out.println("Table Name: " + tableName);

		// print column names and types
		int i = 1;
		while (i < rsMeta.getColumnCount() + 1) {
			System.out.println("Column Name: " + rsMeta.getColumnName(i));
			System.out.println("Column Type: " + rsMeta.getColumnTypeName(i));
			i++;
		}	

		//print out all the data in each table
		System.out.println("Table Data:");
		while (res.next()) {
			for (int i1 = 1; i1 < rsMeta.getColumnCount(); i1++) {
				System.out.print(res.getObject(i1) + " ");
			}
		}

		System.out.println();

	}
}
