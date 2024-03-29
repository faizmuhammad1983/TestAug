package Web.Configuration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.apache.log4j.Logger;

public class CustomWebDriverEvenListener implements WebDriverEventListener {

    Logger log = Logger.getLogger("devpinoyLogger");

    public CustomWebDriverEvenListener() {
    }

    @Override
    public void beforeAlertAccept(WebDriver driver) {

    }

    @Override
    public void afterAlertAccept(WebDriver driver) {

    }

    @Override
    public void afterAlertDismiss(WebDriver driver) {

    }

    @Override
    public void beforeAlertDismiss(WebDriver driver) {

    }

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        log.info(driver.toString() + ": opening URL: " + url);


    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        log.info(driver.toString() + ": successfully navigated to URL: " + url);
    }

    @Override
    public void beforeNavigateBack(WebDriver driver) {
        log.info(driver.toString() + ": trying to navigate back");
    }

    @Override
    public void afterNavigateBack(WebDriver driver) {
        log.info(driver.toString() + ": successfully navigated back");

    }

    @Override
    public void beforeNavigateForward(WebDriver driver) {
        log.info(driver.toString() + ": trying to navigate forward");
    }

    @Override
    public void afterNavigateForward(WebDriver driver) {
        log.info(driver.toString() + ": successfully navigated forward");
    }

    @Override
    public void beforeNavigateRefresh(WebDriver driver) {
        log.info(driver.toString() + ": trying to refresh");
    }

    @Override
    public void afterNavigateRefresh(WebDriver driver) {
        log.info(driver.toString() + ": successfully refreshed");
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {

    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {

    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {

    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {

    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

    }

    @Override
    public void beforeScript(String script, WebDriver driver) {

    }

    @Override
    public void afterScript(String script, WebDriver driver) {

    }

    @Override
    public void beforeSwitchToWindow(String windowName, WebDriver driver) {

    }

    @Override
    public void afterSwitchToWindow(String windowName, WebDriver driver) {

    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {

    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> target) {

    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {

    }

    @Override
    public void beforeGetText(WebElement element, WebDriver driver) {

    }

    @Override
    public void afterGetText(WebElement element, WebDriver driver, String text) {

    }
}
