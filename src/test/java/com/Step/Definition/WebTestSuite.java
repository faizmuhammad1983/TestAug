package com.Step.Definition;

import Configuration.Constants;
import Configuration.Session;
import PageLibrary.Web.TestWebPageObject;
import io.cucumber.java.After;
import io.cucumber.java.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


public class WebTestSuite {
    private Session driver;
    private TestWebPageObject TestWebPageObject;

    @Before("@other")
    public void setup2() {

    }

    @Before("@web or @same")
    public void setup() {
        driver = new Session(Constants.Browser.CHROME, Arrays.asList("--headless", "--window-size=1920,1080", "--disable-gpu", "--disable-extensions", "--no-sandbox", "--incognito"), 10);
        TestWebPageObject = new TestWebPageObject(driver);
    }

    @Given("Navigate the browser to application under test")
    public void navigateTheBrowserToURL() {
        TestWebPageObject.launchURL();
    }


    @When("Search field is found")
    public void objectWithAvailable() {
        boolean result = TestWebPageObject.findObjectByXpath();
        assertTrue(result);
    }

    @Then("Search for {string} , fail if nothing comes up")
    public void searchFor(String arg0) {
        WebElement result = TestWebPageObject.searchText(arg0);
        assertTrue(result != null);

    }


    @After("@web or @same")
    public void end() {
        driver.getWebDriver().quit();

    }


    @After("@other")
    public void end1() {

    }


}