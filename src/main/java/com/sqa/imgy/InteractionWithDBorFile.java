package com.sqa.imgy;

import java.sql.*;

public class InteractionWithDBorFile {

	/**
	 * @param fBID
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static int checkIfTableExists(String fBID) throws ClassNotFoundException, SQLException {
		int numOfRows;
		Class.forName("com.mysql.jdbc.Driver");
		Connection dbconn = DriverManager.getConnection("jdbc:mysql://localhost:8889/fbContactsD", "root", "root");
		Statement stmt = dbconn.createStatement();
		try {
			ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS total FROM " + fBID);
			numOfRows = rs.getInt(1);
			rs.close();
		} catch (Exception e) {
			numOfRows = 0;
		}
		stmt.close();
		dbconn.close();
		return numOfRows;

	}

	public static void createNewTable() {

	}

	public static void displayEntries() {

	}

	/**
	 * @return
	 */
	public static int findNumberOfEntries() {
		// TODO Auto-generated method stub
		return 0;
	}

	public static void returnTableData(int max) {
	}

	/**
	 * @param SQLStatement
	 * @param FBID
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 *
	 */
	public static void searchTable(String FBID, String SQLStatement, int maxView)
			throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		Connection dbconn = DriverManager.getConnection("jdbc:mysql://localhost:8889/fbContactsD", "root", "root");
		Statement stmt = dbconn.createStatement();
		// here's my sql statement
		ResultSet rs = stmt
				.executeQuery("select top " + maxView + " firstName, followingNames, phoneNumber from " + FBID);
		// rs.getMetaData().getColumnCount(); if you dont know how many
		while (rs.next()) {
			String[] contactData = new String[3]; // need to adjust based on #
													// of columns
			contactData[0] = rs.getString(1); // index of columns starting at 1
												// not 0
			contactData[1] = rs.getString(2);
			contactData[2] = rs.getString(2);
			String contactPrintString = buildStringForContact(contactData);
			System.out.println(contactPrintString);
		}
		rs.close();
		stmt.close();
		dbconn.close();

	}

	public static void writeToDBTable() {

	}

	/**
	 * @param contactData
	 * @return
	 */
	private static String buildStringForContact(String[] contactData) {
		// TODO Auto-generated method stub
		return null;
	}

	public void BasicTest() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection dbconn = DriverManager.getConnection("jdbc:mysql://localhost:8889/fbContactsD", "root", "root");
		// initiated connection to DB

		// specific to methods
		Statement stmt = dbconn.createStatement();
		// here's my sql statement
		ResultSet rs = stmt.executeQuery("select id, user, pass from tablename");
		// rs.getMetaData().getColumnCount(); if you dont know how many
		while (rs.next()) {
			// You can call by the name of the column or
			// String userID = rs.getString("id");
			String userName = rs.getString(2); // index of columns starting at 1
												// not 0
			String userPass = rs.getString(3);
			System.out.println("\tuser: " + userName + "\tpassword: " + userPass);
		}
		rs.close();
		stmt.close();
		// ends specific to methods

		// closes connnection
		dbconn.close();
	}

}
