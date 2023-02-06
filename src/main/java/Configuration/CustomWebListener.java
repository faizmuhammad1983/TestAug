package Configuration;

import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class CustomWebListener implements WebDriverListener {

    Logger log = Logger.getLogger("CustomSessionListener");
    public CustomWebListener() {
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
    @Override
    public void beforeClick(WebElement element) {
        WebDriverListener.super.beforeClick(element);
        log.info(element.toString()+"will be clicked");
    }
    @Override
    public void afterClick(WebElement element) {
        WebDriverListener.super.afterClick(element);
        log.info(element.toString()+"was clicked");
    }
}