package com.saucedemo.po;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {
	private By addToCarButton = By.xpath("//a[text()='Add to cart']");
	private By titleLabel = By.xpath("//div[@class='header_secondary_container']/span");
	private By items = By.xpath("//div[@class='inventory_item']");
	private By twitter = By.xpath("//li[@class='social_twitter']");
	private By facebook = By.xpath("//li[@class='social_facebook']");
	private By linkedin = By.xpath("//li[@class='social_linkedin']");
	private By addToCartButton = By.xpath("div[2]/div[2]/button");
	private By shoppingToCartButton = By.xpath("//a[@class='shopping_cart_link']");
	private By addedItemsCounter = By.xpath("//span[@class='shopping_cart_badge']");
	
	public ProductsPage() throws Exception {
	}

	public String getTitleLabel() 
	{	wait.until(ExpectedConditions.visibilityOfElementLocated(titleLabel));
		return driver.findElement(titleLabel).getText();
	}

	public ProductsPage clickAddToCarButton() throws Exception {
		wait.until(ExpectedConditions.visibilityOfElementLocated(addToCarButton));
		driver.findElement(addToCarButton).click();
		return this;
	}

	public int getNumberOfItems() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(items));
		return driver.findElements(items).size();
	}


	public String getAddedItemsCounter() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(addedItemsCounter));
		return driver.findElement(addedItemsCounter).getText();
	}

	public List<WebElement> getItems() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(items));
		return driver.findElements(items);
	}

	public void clickAddToCartButton(WebElement element) 
	{	element.findElement(addToCartButton).click();
	}

	public void clickShoppingCartButton() 
	{	wait.until(ExpectedConditions.visibilityOfElementLocated(shoppingToCartButton));
		driver.findElement(shoppingToCartButton).click();
	}

	public boolean isTwitterLinkPresent() {
		Boolean elementFound = null;
		try
		{	wait.until(ExpectedConditions.visibilityOfElementLocated(twitter));
			elementFound = true;
		}catch(Exception e)
		{	elementFound = false;
		}
		return elementFound;
	}

	public boolean isFacebookLinkPresent() {
		Boolean elementFound = null;
		try
		{	wait.until(ExpectedConditions.visibilityOfElementLocated(facebook));
			elementFound = true;
		}catch(Exception e)
		{	elementFound = false;
		}
		return elementFound;
	}

	public boolean isLinkedInLinkPresent() {
		Boolean elementFound = null;
		try
		{	wait.until(ExpectedConditions.visibilityOfElementLocated(linkedin));
			elementFound = true;
		}catch(Exception e)
		{	elementFound = false;
		}
		return elementFound;
	}

}