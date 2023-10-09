package com.saucedemo.step;

import com.saucedemo.po.BasePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import java.util.List;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class CommonSteps extends BasePage {
	public CommonSteps() throws Exception {
		super();
	}

	@Before
	public void invokeBrowser() {
		BasePage.setUp();
	}
	
	@After
	public void quitBrowser(Scenario scenario) {
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", "screenshot-After.png");
		BasePage.quit();
	}

	@AfterStep
	public void attachScreenShotAfterStep(Scenario scenario) {
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", "screenshot-AfterStep.png");
	}

	@BeforeStep
	public void attachScreenShotBeforeStep(Scenario scenario) {
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", "screenshot-BeforeStep.png");
	}

	@Given("the user go to page")
  	public void theUserGoToPage(DataTable dataTable) throws Exception {
    	List<List<String>> data = dataTable.asLists(String.class);
    	driver.navigate().to(data.get(0).get(0));
  	}
}