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
	 *
	 */
	public void getFBID() {
		// TODO Auto-generated method stub

	}

	/**
	 *
	 */
	public void importFriends() {
		// TODO Auto-generated method stub

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
	 *
	 */
	private void logout() {
		// TODO Auto-generated method stub

	}

}
