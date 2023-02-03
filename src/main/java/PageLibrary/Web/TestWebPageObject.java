package PageLibrary.Web;


import Utilities.*;
import Configuration.Session;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;

public class TestWebPageObject {
    private WebDriverWait wait;
    private Session driver;
    HashMap<String, String> hs;
    private By searchBox = By.xpath("//input[contains(@name,'q')]");


    public TestWebPageObject(Session driver, int explicitWait) {
        this.driver = driver;
        wait = new WebDriverWait(driver.getWebDriver(), Duration.ofSeconds(explicitWait));
        PropertyReader pr= new PropertyReader(System.getProperty("env"));
        hs = pr.getPropertyAsHashMap();

    }


    public void launchURL() {
        driver.getWebDriver().get(hs.get("URL"));
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
        driver.getWebDriver().findElement(searchBox).sendKeys(text);
        driver.getWebDriver().findElement(searchBox).sendKeys(Keys.RETURN);
        try {
            //added case insensitive xpath to avoid any search issues
            String caseInsensitiveXpath = "//div/a[contains(translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'"+text.toLowerCase()+"' )]";

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(caseInsensitiveXpath)));
            elementExist = driver.getWebDriver().findElement(By.xpath(caseInsensitiveXpath));
        } catch (NoSuchElementException e) {

        }

        return elementExist;

    }


}
