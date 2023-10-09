package com.saucedemo.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LogInPage extends BasePage {
	private By userNameInput = By.id("user-name");
	private By passwordInput = By.id("password");
	private By logInButton = By.xpath("//input[@id='login-button']");
	private By loginErrorMessage = By.xpath("//h3[@data-test='error']");
	
	public LogInPage() throws Exception {
	}
	
	public void setUserName(String userName) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(userNameInput));
		WebElement input = driver.findElement(userNameInput);
		input.clear();
		input.sendKeys(userName);
	}

	public void setPassword(String password) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
		WebElement input = driver.findElement(passwordInput);
		input.clear();
		input.sendKeys(password);
	}

	public void clickLogInButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(logInButton));
		driver.findElement(logInButton).click();
	}


	public String getLoginErrorMessage() 
	{	wait.until(ExpectedConditions.visibilityOfElementLocated(loginErrorMessage));
		return driver.findElement(loginErrorMessage).getText();
	}
	
}