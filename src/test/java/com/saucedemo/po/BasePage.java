package com.saucedemo.po;

import com.saucedemo.util.Constant;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasePage {
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	
	public BasePage() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\java\\com\\saucedemo\\config.properties");
		prop.load(fis);
	}

	public static void setUp() 
	{	String browser = prop.getProperty("browser");
		try 
		{	if (browser.trim().equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\resources\\chromedriver.exe");
				HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
				chromePrefs.put("profile.default_content_settings.popups", 0);
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", chromePrefs);
				driver = new ChromeDriver(options);
			}
			if (browser.trim().equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\resources\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
		}catch (Exception e) 
		{	e.printStackTrace();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Constant.IMPLICITY_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Constant.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 30);
	}
		
	public static void quit() {
		driver.quit();
	}

}