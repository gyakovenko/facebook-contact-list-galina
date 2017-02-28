package com.sqa.imgy;

public class ContactsListFromFacebookApp {

	public static void main(String[] args) {
		boolean needToWriteNewData = checkIfHasExistingContactList();
		if (!needToWriteNewData) {
			askUserImportViewSearch();
		} else {
			importHowMany();
		}

		// if no:
		// new driver
		// InteractionWithFacebook.import - pass max friends to add at a time or
		// auto set to 0 (no limit)
		// close driver

		// while using exit = false, continue to ask. when user enters "exit" or
		// "quit", quit app
		// ask user if want to try importing more from fb or want to view/search
		// list
		// if IMPORT InteractionWithFacebook.import - pass max
		// if VIEW: print whole list loop through if fields != "", then print
		// if SEARCH: prompt: enter last name or part of last name string
		// while search = true. if users enters "back to menu"
		// use regex to return all entries where following names include string
		// (Select SQL statement)
		// *later: how to deal with accented characters
		// print results then press enter to continue

		// exit
	}

	/**
	 *
	 */
	private static void askUserImportViewSearch() {
		boolean exit = false;
		// while (!exit){
		// Ask User what they want to do
		// call : importHowMany()
		// or: viewHowMany()}
		System.exit(0);

	}

	/**
	 * @return
	 */
	private static int askUserMaxToImport() {
		// TODO Auto-generated method stub
		return 0;
	}

	private static boolean checkIfHasExistingContactList() {
		boolean needToWriteNewData = true;
		boolean tableFound;
		int numOfEntries = 0;
		InteractionWithFacebook firstInteractionToCheckForContacts = new InteractionWithFacebook(
				"https://www.facebook.com/", "gyakovenko@yahoo.com", "1shaGalin@");
		firstInteractionToCheckForContacts.login();
		firstInteractionToCheckForContacts.getFBID();
		firstInteractionToCheckForContacts.tearDown();
		tableFound = InteractionWithDBorFile.checkIfTableExists();
		if (tableFound) {
			numOfEntries = InteractionWithDBorFile.findNumberOfEntries();
			informUserIfTablesFound(tableFound, numOfEntries);
		} else {
			informUserIfTablesFound(tableFound);
		}
		if (numOfEntries != 0) {
			needToWriteNewData = false;
		}
		return needToWriteNewData;

	}

	/**
	 *
	 */
	private static void importHowMany() {
		int maxToImport = askUserMaxToImport();
		InteractionWithFacebook importInteractionToCheckForContacts = new InteractionWithFacebook(
				"https://www.facebook.com/", "gyakovenko@yahoo.com", "1shaGalin@");
		importInteractionToCheckForContacts.importFriends(maxToImport);

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
	private static void searchForWhatString() {
		// TODO Auto-generated method stub
		askUserImportViewSearch();
	}

	/**
	 *
	 */
	private static void viewHowMany() {
		InteractionWithDBorFile.searchTable();
		askUserImportViewSearch();
	}

}
