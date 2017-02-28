package com.sqa.imgy;

import java.util.concurrent.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;

public class InteractionWithFacebook {

	private String baseUrl;

	private WebDriver driver;

	private String password;

	private String username;

	public InteractionWithFacebook(String baseUrl, String username, String password) {
		super();
		this.username = username;
		this.password = password;
		this.baseUrl = baseUrl;
		this.setUpFirefox();

	}

	/**
	 * @return
	 *
	 */
	public String getFBID() {
		return "facebood id";
		// TODO Auto-generated method stub
	}

	/**
	 * @param maxToImport
	 *
	 */
	public void importFriends(int maxToImport) {
		boolean importMoreFriends = true;
		goToFriendsList();
		while (importMoreFriends) {
			importBatchOfFriends(maxToImport);
			importMoreFriends = askIfImportNextBatch();
		}
		boolean success = printImportStatus();
	}

	/**
	 *
	 */
	public void login() {
		// TODO Auto-generated method stub

	}

	public void setUpFirefox() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		this.driver.get(this.baseUrl);
	}

	/**
	 *
	 */
	public void tearDown() {
		this.logout();
		this.driver.quit();

	}

	/**
	 * @return
	 */
	private boolean askIfImportNextBatch() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 *
	 */
	private void getNoOfFriends() {
		// TODO Auto-generated method stub

	}

	/**
	 *
	 */
	private void goToFriendsList() {
		// TODO Auto-generated method stub

	}

	/**
	 * @param maxToImport
	 */
	private boolean importBatchOfFriends(int maxToImport) {
		// get total
		// while # of friends < total:
		// while visible
		// Each friend: get info, store to DB
		// info: name, city, dob, phone #, email, aim, skype
		// scroll to next section
		// return success or not
		return true;
	}

	/**
	 *
	 */
	private void logout() {
		// TODO Auto-generated method stub

	}

	/**
	 * @return
	 *
	 */
	private boolean printImportStatus() {
		return false;
		// TODO Auto-generated method stub

	}

	/**
	 *
	 */
	private void showMoreFriends() {
		// TODO Auto-generated method stub

	}

	/**
	 *
	 */
	private void storeFriendsInfoLoop() {
		InteractionWithDBorFile.writeToDBTable();
	}

}
