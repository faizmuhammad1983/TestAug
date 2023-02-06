package PageLibrary.Mobile;


import Configuration.Session;
import Utilities.PropertyReader;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;

public class TestMobileAppObject {
    private WebDriverWait wait;
    private Session driver;
    HashMap<String, String> hs;
    private String preferenceButton = "//android.widget.TextView[@content-desc=\"Preference\"]";


    public TestMobileAppObject(Session driver) {
        this.driver = driver;
        wait = driver.getWait();
        PropertyReader pr= new PropertyReader(System.getProperty("env"));
        hs = pr.getPropertyAsHashMap();
    }

    public void openPreferences() {

        driver.getAndroidDriver().findElement(AppiumBy.xpath(preferenceButton)).click();
        //System.out.println(hs.get("URL"));
    }

//    public boolean findObjectByXpath() {
//        boolean isExists = true;
//        try {
//            wait.until(ExpectedConditions.presenceOfElementLocated(searchBox));
//        } catch (NoSuchElementException e) {
//            isExists = false;
//        }
//        return isExists;
//
//    }
//
//    public WebElement searchText(String text) {
//        WebElement elementExist = null;
//        driver.getWebDriver().findElement(searchBox).sendKeys(text);
//        driver.getWebDriver().findElement(searchBox).sendKeys(Keys.RETURN);
//        try {
//            //added case insensitive xpath to avoid any search issues
//            String caseInsensitiveXpath = "//div/a[contains(translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'"+text.toLowerCase()+"' )]";
//
//            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(caseInsensitiveXpath)));
//            elementExist = driver.getWebDriver().findElement(By.xpath(caseInsensitiveXpath));
//        } catch (NoSuchElementException e) {
//
//        }
//
//        return elementExist;
//
//    }


}
