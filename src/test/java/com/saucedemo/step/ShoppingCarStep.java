package com.saucedemo.step;

import com.saucedemo.po.LogInPage;
import com.saucedemo.po.ProductsPage;
import com.saucedemo.po.BasePage;
import com.saucedemo.po.CartPage;
import com.saucedemo.util.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import java.util.*;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertEquals;

public class ShoppingCarStep extends BasePage 
{	LogInPage logInPage; 
	ProductsPage productsPage;
	CartPage cartPage;

	public ShoppingCarStep(TestContext context) throws Exception {
	}

	@Then("verify products screen")
  	public void verifyProductsScreen(DataTable dataTable) throws Exception {
    	List<List<String>> data = dataTable.asLists(String.class);
		productsPage = new ProductsPage();
		String currentTitle = productsPage.getTitleLabel();
		String expectedTitle = data.get(0).get(0);
		assertEquals("Se esperaba el titulo "+expectedTitle+" pero se encontro "+currentTitle, expectedTitle, currentTitle);
		int currentNumberOfItems = productsPage.getNumberOfItems();
		int expectedNumberOfItems = 6;
		assertEquals("Se esperaban "+expectedNumberOfItems+" artículos pero se encontrarón "+currentNumberOfItems, expectedNumberOfItems, currentNumberOfItems);
		boolean currentIsTwitterLinkPresent = productsPage.isTwitterLinkPresent();
		assertEquals("Se esperaba enlace a Twitter pero no se encontro", true, currentIsTwitterLinkPresent);
		boolean currentIsFacebookLinkPresent = productsPage.isFacebookLinkPresent();
		assertEquals("Se esperaba enlace a Facebook pero no se encontro", true, currentIsFacebookLinkPresent);
		boolean currentIsLinkedInLinkPresent = productsPage.isLinkedInLinkPresent();
		assertEquals("Se esperaba enlace a Facebook pero no se encontro", true, currentIsLinkedInLinkPresent);
  	}

	@Then("verify added items counter")
  	public void verifyAddedItemsCounter() throws Exception {
		productsPage = new ProductsPage();
		List<WebElement> items = productsPage.getItems();
		String currentAddedItemsCounter = null;
		for (int i = 0; i < items.size(); i++)
		{	productsPage.clickAddToCartButton(items.get(i));
			currentAddedItemsCounter = productsPage.getAddedItemsCounter();
			assertEquals("Se esperaban "+(i+1)+" artículos pero se encontrarón "+currentAddedItemsCounter, Integer.toString(i+1), currentAddedItemsCounter);
        }
  	}

	@Then("add items to shopping cart")
  	public void addItemsToShoppingCart() throws Exception {
		productsPage = new ProductsPage();
		List<WebElement> items = productsPage.getItems();
		for (int i = 0; i < items.size(); i++)
		{	productsPage.clickAddToCartButton(items.get(i));
        }
  	}

	@Then("click shopping cart button")
  	public void clickShoppingCartButton() throws Exception {
		productsPage = new ProductsPage();
		productsPage.clickShoppingCartButton();
  	}

	@Then("verify items in shopping cart")
  	public void verifyItemsInShoppingCart(DataTable dataTable) throws Exception {
		List<List<String>> data = dataTable.asLists(String.class);
		String expectedItemName = null;
		String currentItemName = null;
		String currentItemDescription = null;
		String expectedItemDescription = null;
		String currentItemPrice = null;
		String expectedItemPrice = null;
		cartPage = new CartPage();
		List<WebElement> items = cartPage.getItems();
		for (int i = 0; i < items.size(); i++)
		{	currentItemName = cartPage.getItemName(items.get(i));
			expectedItemName = data.get(i).get(0);
			assertEquals("Se esperaba nombre del artículo "+expectedItemName+" pero se encontro "+currentItemName, expectedItemName, currentItemName);
			currentItemDescription = cartPage.getItemDescription(items.get(i));
			expectedItemDescription = data.get(i).get(1);
			assertEquals("Se esperaba descripción del artículo "+expectedItemDescription+" pero se encontro "+currentItemDescription, expectedItemDescription, currentItemDescription);
			currentItemPrice = cartPage.getItemPrice(items.get(i));
			expectedItemPrice = data.get(i).get(2);
			assertEquals("Se esperaba precio del artículo "+expectedItemPrice+" pero se encontro "+currentItemPrice, expectedItemPrice, expectedItemPrice);
        }
  	}

}