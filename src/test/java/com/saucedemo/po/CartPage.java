package com.saucedemo.po;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {
	private By items = By.xpath("//div[@class='cart_item']");
	private By itemName = By.xpath("div[2]/a/div");
	private By itemDescription = By.xpath("div[2]/div");
	private By itemPrice = By.xpath("div[2]/div[2]/div");
	
	public CartPage() throws Exception {
	}

	public boolean findProductByName(String value) throws Exception {
		By productTitle = By.xpath("//td[text()='"+value+"']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle));
		return value.equals(driver.findElement(productTitle).getText());
	}
	
	public List<WebElement> getItems() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(items));
		return driver.findElements(items);
	}

	public String getItemName(WebElement element) 
	{	return element.findElement(itemName).getText();
	}

	public String getItemDescription(WebElement element) 
	{	return element.findElement(itemDescription).getText();
	}

	public String getItemPrice(WebElement element) 
	{	return element.findElement(itemPrice).getText();
	}
}