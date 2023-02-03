package com.Step.Definition;

import Configuration.Constants;
import Configuration.Session;
import PageLibrary.Mobile.TestMobileAppObject;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MobileTestSuite {
    private Session driver;
    private String appPath = "/Users/muhammad.faiz/Documents/Repositories/TestAug/src/test/resources/ApiDemos-debug.apk";
    private String deviceName = "FaizPhone";
    private TestMobileAppObject testMobileObject;


    @Before("@mobile")
    public void setup() throws MalformedURLException {
        driver = new Session(Constants.MobileOS.Android, new URL("http://localhost:4723"), appPath,deviceName);
        testMobileObject = new TestMobileAppObject(driver, 10);
    }

    @Given("Launch app and go to preference")
    public void navigateTheBrowserToURL() {
        testMobileObject.openPreferences();
    }

    @Then("End session")
    public void endSession(){
        driver.getMobileDriver().quit();
    }

//    @When("Search field is found")
//    public void objectWithAvailable() {
//        boolean result = testPageObject.findObjectByXpath();
//        assertTrue(result);
//    }

//    @Then("Search for {string} , fail if nothing comes up")
//    public void searchFor(String arg0) {
//        WebElement result = testPageObject.searchText(arg0);
//        assertTrue(result != null);
//
//    }

//
//    @After("@web or @same")
//    public void end() {
//        driver.getMobileDriver().quit();
//
//    }
//
//
//    @After("@other")
//    public void end1() {
//
//    }


}