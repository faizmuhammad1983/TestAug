package Configuration;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import java.net.URL;
import java.util.List;

public class Session {
    private Constants.Browser browserName;
    private Constants.MobileOS MobileOS;
    private WebDriver webDriver, mobileDriver;
    private List<String> addArguments;
    private URL serverURL;
    private String appPath, deviceName;
    public Session(Constants.Browser browserName, List<String> arguments) {
        this.browserName = browserName;
        this.addArguments = arguments;
        if (browserName.equals(Constants.Browser.CHROME)) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments(addArguments);
            this.webDriver = new ChromeDriver(options);
            CustomSessionListener listener = new CustomSessionListener();
            this.webDriver = new EventFiringDecorator(listener).decorate(this.webDriver);
        } else if (browserName.equals(Constants.Browser.FIREFOX)) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments(addArguments);
            this.webDriver = new FirefoxDriver(options);
            CustomSessionListener listener = new CustomSessionListener();
            this.webDriver = new EventFiringDecorator(listener).decorate(this.webDriver);
        }
        else {
            System.out.println("Wrong driver selected");
        }
    }
    public Session(Constants.MobileOS mobileOS, URL serverURL, String appPath, String deviceName) {
        this.MobileOS = mobileOS;
        this.serverURL = serverURL;
        this.appPath = appPath;
        this.deviceName = deviceName;
        if(mobileOS.equals(Constants.MobileOS.Android)){
            UiAutomator2Options options = new UiAutomator2Options();
            options.setDeviceName(deviceName);
            options.setApp(appPath);
            WebDriver original = new AndroidDriver(serverURL,options);
            WebDriverListener listener = new CustomSessionListener();
            this.mobileDriver = new EventFiringDecorator(listener).decorate(original);
        } else if(mobileOS.equals(Constants.MobileOS.iOS)){
            XCUITestOptions options = new XCUITestOptions();
            options.setDeviceName(deviceName);
            options.setApp(appPath);
            WebDriver original = new IOSDriver(serverURL,options);
            WebDriverListener listener = new CustomSessionListener();
            this.mobileDriver = new EventFiringDecorator(listener).decorate(original);
        } else {
            System.out.println("Wrong mobile OS selected");
        }
    }
    public WebDriver getMobileDriver() { return mobileDriver; }
    public WebDriver getWebDriver() {
        return webDriver;
    }
}