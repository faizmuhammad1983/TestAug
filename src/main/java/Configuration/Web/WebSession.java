package Configuration.Web;

import Configuration.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;

import java.util.List;


public class WebSession {

    private Constants.Browser browserName;
    private WebDriver driver;
    private List<String> addArguments;

    public WebSession(Constants.Browser browserName, List<String> arguments) {
        this.browserName = browserName;
        this.addArguments = arguments;
        if (browserName.equals(Constants.Browser.CHROME)) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments(addArguments);
            this.driver = new ChromeDriver(options);
            CustomWebDriverListener listener = new CustomWebDriverListener();
            this.driver = new EventFiringDecorator(listener).decorate(this.driver);
        } else if (browserName.equals(Constants.Browser.FIREFOX)) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments(addArguments);
            this.driver = new FirefoxDriver(options);
            CustomWebDriverListener listener = new CustomWebDriverListener();
            this.driver = new EventFiringDecorator(listener).decorate(this.driver);
        }
        else {
            System.out.println("Wrong driver selected");
        }

    }

    public WebDriver getDriver() {
        return driver;
    }

}
