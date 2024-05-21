package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class LoginPage {

	private Page page;

	// 1. String Locators - OR (Object Repository)

	private String emailId = "#input-email";
	private String passwordId = "#input-password";
	private String loginBtn = "input[value='Login']";
	private String forgotPwdLink = "//div[@class='form-group']//a[normalize-space()='Forgotten Password333']";
	private String logoutLink = "//a[@class='list-group-item'][normalize-space()='Logout']";

	// 2. page constructor

	public LoginPage(Page page) {

		this.page = page;

	}
	
	// 3. page actions/methods
	
	public String getLoginPageTitle() {
		
		return page.title();
		
	}
	
	public boolean isForgotPwdLinkExist() {
		
		return page.isVisible(forgotPwdLink);
		
	}
	
	public boolean doLogin(String appUserName, String appPassword) {
		
		System.out.println("App creds: " + appUserName + ":" + appPassword);
		page.fill(emailId, appUserName);
		page.fill(passwordId, appPassword);
		page.click(loginBtn);
		
		if(page.isVisible(logoutLink)) {
			
			System.out.println("user is logged in successfully...");
			return true;
			
		}else {
			
			return false;
			
		}
		
	}

}
