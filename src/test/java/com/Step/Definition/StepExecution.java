package com.Step.Definition;

import Configuration.Constants;
import Configuration.WebSession;
import PageLibrary.testPageObject;
import io.cucumber.java.After;
import io.cucumber.java.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import static org.junit.jupiter.api.Assertions.*;


public class StepExecution {
    private WebSession driver;
    testPageObject testPageObject;

    @Before("@other")
    public void setup2() {

    }

    @Before("@web or @same")
    public void setup() {
        driver = new WebSession(Constants.Browser.CHROME,true);
        testPageObject = new testPageObject(driver, 10);
    }

    @Given("Navigate the browser to application under test")
    public void navigateTheBrowserToURL() {
        testPageObject.launchURL();
    }


    @When("Search field is found")
    public void objectWithAvailable() {
        boolean result = testPageObject.findObjectByXpath();
        assertTrue(result);
    }

    @Then("Search for {string} , fail if nothing comes up")
    public void searchFor(String arg0) {
        WebElement result = testPageObject.searchText(arg0);
        assertTrue(result != null);

    }


    @After("@web or @same")
    public void end() {
        driver.getDriver().close();
        driver.getDriver().quit();

    }


    @After("@other")
    public void end1() {

    }


}