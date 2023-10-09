package com.saucedemo.step;

import com.saucedemo.po.LogInPage;
import com.saucedemo.po.ProductsPage;
import com.saucedemo.po.BasePage;
import com.saucedemo.util.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import java.util.*;
import static org.junit.Assert.assertEquals;

public class LogInStep extends BasePage 
{	private TestContext testContext = null;
	LogInPage logInPage; 
	ProductsPage productPage;

	public LogInStep(TestContext context) throws Exception {
		testContext = context;
		testContext.getMap().put("username", "standard_user");
		testContext.getMap().put("password", "secret_sauce");
	}

	@Given("log in")
	public void logIn(DataTable dataTable) throws Exception 
	{	List<List<String>> data = dataTable.asLists(String.class);
		String user = data.get(0).get(0);
		String password = data.get(1).get(0);
		logInPage= new LogInPage();
		logInPage.setUserName(user);
		logInPage.setPassword(password);
		logInPage.clickLogInButton();
	}

	@Then("verify user blocked login")
  	public void verifyProductsScreen(DataTable dataTable) throws Exception {
    	List<List<String>> data = dataTable.asLists(String.class);
		logInPage= new LogInPage();
		String currentLoginErrorMessage = logInPage.getLoginErrorMessage();
		String expectedLoginErrorMessage = data.get(0).get(0);
		assertEquals("Se esperaba el mensaje de error "+expectedLoginErrorMessage+" pero se encontro "+currentLoginErrorMessage, expectedLoginErrorMessage, currentLoginErrorMessage);
  	}
}