package Configuration.Web;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.events.WebDriverListener;

public class CustomWebDriverListener implements WebDriverListener {


    Logger log = Logger.getLogger("devpinoyLogger");

    public CustomWebDriverListener() {
    }

    @Override
    public void beforeGet(WebDriver driver, String url) {
        WebDriverListener.super.beforeGet(driver, url);
        log.info(driver.toString() + ": Navigating to: "+url);
    }

    @Override
    public void afterGet(WebDriver driver, String url) {
        WebDriverListener.super.afterGet(driver, url);
        log.info(driver.toString() + ": successfully navigated to: "+url);
    }


}
