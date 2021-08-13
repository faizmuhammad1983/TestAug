package com.Step.Definition;

import Configuration.Constants;
import Configuration.WebSession;
import PageLibrary.AllRecipeMainPage;
import io.cucumber.java.After;
import io.cucumber.java.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import static org.junit.jupiter.api.Assertions.*;


public class StepDefinitions {
    private WebSession driver;
    AllRecipeMainPage allRecipeMainPage;

    @Before("@other")
    public void setup2() {

    }

    @Before("@web")
    public void setup() {
        driver = new WebSession(Constants.Browser.CHROME,true);
        allRecipeMainPage = new AllRecipeMainPage(driver, 10);
    }

    @Given("Navigate the browser to application under test")
    public void navigateTheBrowserToURL() {
        allRecipeMainPage.launchURL();
    }


    @When("Search field is found")
    public void objectWithAvailable() {
        allRecipeMainPage.findObjectByXpath();
    }

    @Then("Search for {string} , fail if nothing comes up")
    public void searchFor(String arg0) {
        WebElement result = allRecipeMainPage.searchRecipe(arg0);
        assertTrue(result != null);

    }


    @After("@web")
    public void end() {
        driver.getDriver().close();
        driver.getDriver().quit();

    }


    @After("@other")
    public void end1() {

    }


}