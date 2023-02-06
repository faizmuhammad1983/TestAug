package Configuration;

import io.appium.java_client.AppiumFluentWait;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.appium.java_client.proxy.Helpers.createProxy;

import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Session {
    private Constants.Browser browserName;
    private Constants.MobileOS MobileOS;
    private WebDriver webDriver;
    private IOSDriver iosDriver;
    private AndroidDriver androidDriver;

    private WebDriverWait wait;

    private List<String> addArguments;
    private URL serverURL;
    private String appPath, deviceName;

    public Session(Constants.Browser browserName, List<String> arguments, int explicitWait) {
        this.browserName = browserName;
        this.addArguments = arguments;
        if (browserName.equals(Constants.Browser.CHROME)) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments(addArguments);
            WebDriver original = new ChromeDriver(options);
            CustomWebListener listener = new CustomWebListener();
            this.webDriver = new EventFiringDecorator(listener).decorate(original);
        } else if (browserName.equals(Constants.Browser.FIREFOX)) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments(addArguments);
            WebDriver original = new FirefoxDriver(options);
            CustomWebListener listener = new CustomWebListener();
            this.webDriver = new EventFiringDecorator(listener).decorate(original);
        }
        else {
            System.out.println("Wrong driver selected");
        }
        this.wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(explicitWait));
    }
    public Session(Constants.MobileOS mobileOS, URL serverURL, String appPath, String deviceName, int explicitWait) {
        this.MobileOS = mobileOS;
        this.serverURL = serverURL;
        this.appPath = appPath;
        this.deviceName = deviceName;
        if(mobileOS.equals(Constants.MobileOS.Android)){
            CustomMobileMethodListener listener = new CustomMobileMethodListener("AndroidDriver", this.deviceName);
            AndroidDriver decoratedDriver = createProxy(
                    AndroidDriver.class,
                    new Object[] {serverURL, new UiAutomator2Options().setDeviceName(deviceName).setApp(appPath)},
                    new Class[] {URL.class, Capabilities.class},
                    listener
            );
            this.androidDriver = decoratedDriver;
            this.wait = new WebDriverWait(this.androidDriver, Duration.ofSeconds(explicitWait));
        } else if(mobileOS.equals(Constants.MobileOS.iOS)){
            CustomMobileMethodListener listener = new CustomMobileMethodListener("iOSDriver", this.deviceName);
            IOSDriver decoratedDriver = createProxy(
                    IOSDriver.class,
                    new Object[] {serverURL, new XCUITestOptions().setDeviceName(deviceName).setApp(appPath)},
                    new Class[] {URL.class, Capabilities.class},
                    listener
            );
            this.iosDriver = decoratedDriver;
            this.wait = new WebDriverWait(this.iosDriver, Duration.ofSeconds(explicitWait));
        } else {
            System.out.println("Wrong mobile OS selected");
        }
    }

    public IOSDriver getIosDriver() {
        return iosDriver;
    }

    public AndroidDriver getAndroidDriver() {
        return androidDriver;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public WebDriverWait getWait() {
        return wait;
    }
}