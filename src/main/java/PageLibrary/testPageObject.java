package PageLibrary;


import Utilities.*;
import Web.Configuration.WebSession;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;

public class testPageObject {
    private WebDriverWait wait;
    private WebSession driver;
    HashMap<String, String> hs;
    private By searchBox = By.xpath("//input[contains(@name,'q')]");


    public testPageObject(WebSession driver, int explicitWait) {
        this.driver = driver;
        wait = new WebDriverWait(driver.getDriver(), explicitWait);
        PropertyReader pr= new PropertyReader(System.getProperty("env"));
        hs = pr.getPropertyAsHashMap();

    }


    public void launchURL() {
        driver.getDriver().get(hs.get("URL"));
        //System.out.println(hs.get("URL"));
    }

    public boolean findObjectByXpath() {
        boolean isExists = true;
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(searchBox));
        } catch (NoSuchElementException e) {
            isExists = false;
        }
        return isExists;

    }

    public WebElement searchText(String text) {
        WebElement elementExist = null;
        driver.getDriver().findElement(searchBox).sendKeys(text);
        driver.getDriver().findElement(searchBox).sendKeys(Keys.RETURN);
        try {
            //added case insensitive xpath to avoid any search issues
            String caseInsensitiveXpath = "//div/a[contains(translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'"+text.toLowerCase()+"' )]";

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(caseInsensitiveXpath)));
            elementExist = driver.getDriver().findElement(By.xpath(caseInsensitiveXpath));
        } catch (NoSuchElementException e) {

        }

        return elementExist;

    }


}
