package com.sqa.imgy;

import java.sql.*;

public class ContactsListFromFacebookApp {

	static String FBID;

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// How will the user name and password be passed in? It will need to be
		// passed in to checkIfHasExistingContactList()
		boolean needToWriteNewData = checkIfHasExistingContactList();
		if (!needToWriteNewData) {
			askUserImportViewSearch();
		} else {
			importHowMany();
		}
		System.exit(0);
		// if IMPORT InteractionWithFacebook.import - pass max
		// if VIEW: print whole list loop through if fields != "", then print
		// if SEARCH: prompt: enter last name or part of last name string
		// while search = true. if users enters "back to menu"
		// use regex to return all entries where following names include string
		// (Select SQL statement)
		// *later: how to deal with accented characters
		// print results then press enter to continue

	}

	/**
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 *
	 */
	private static void askUserImportViewSearch() throws ClassNotFoundException, SQLException {
		boolean exit = false;
		while (!exit) {
			// Ask User what they want to do and call one of these:
			importHowMany();
			viewHowMany();
			searchForContact();
		}
		// once exit = true - ends the method and goes back to main for exit
	}

	/**
	 * @return
	 */
	private static int askUserMaxToImport() {
		// TODO Auto-generated method stub
		return 0;
	}

	// How will the user name and password be passed in? It will need to be
	// passed in to checkIfHasExistingContactList()
	// temporarily hard-coded
	private static boolean checkIfHasExistingContactList() throws ClassNotFoundException, SQLException {
		boolean needToWriteNewData = true;
		int numOfEntries = 0;
		InteractionWithFacebook firstInteractionToCheckForContacts = new InteractionWithFacebook(
				"https://www.facebook.com/", "gyakovenko@yahoo.com", "1shaGalin@");
		firstInteractionToCheckForContacts.login();
		FBID = firstInteractionToCheckForContacts.getFBID();
		firstInteractionToCheckForContacts.tearDown();
		numOfEntries = InteractionWithDBorFile.checkIfTableExists(FBID);
		if (numOfEntries != 0) {
			needToWriteNewData = false;
		}
		return needToWriteNewData;

	}

	/**
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 *
	 */
	private static void importHowMany() throws ClassNotFoundException, SQLException {
		int maxToImport = askUserMaxToImport();
		InteractionWithFacebook importInteraction = new InteractionWithFacebook("https://www.facebook.com/",
				"gyakovenko@yahoo.com", "1shaGalin@");
		importInteraction.importFriends(maxToImport);

		askUserImportViewSearch();
	}

	private static void informUserIfTablesFound(boolean tableFound) {
		informUserIfTablesFound(tableFound, 0);
	}

	private static void informUserIfTablesFound(boolean tableFound, int numOfEntries) {
		if (!tableFound) {
			System.out.println("No existing Contact List found for this Facebook account.");
		} else {
			System.out.println("Contact List found for this account has " + numOfEntries + " entries");
		}

	}

	/**
	 *
	 */
	private static void searchForContact() {
		// TODO Auto-generated method stub

	}

	/**
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 *
	 */
	private static void searchForWhatString() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		askUserImportViewSearch();
	}

	/**
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 *
	 */
	private static void viewHowMany() throws ClassNotFoundException, SQLException {
		// ask user max how many to view
		int maxView = 10;
		InteractionWithDBorFile.searchTable("FBID", "SQL Statement", maxView);
		askUserImportViewSearch();
	}

}
