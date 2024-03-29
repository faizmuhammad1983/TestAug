package Web.Configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.List;


public class WebSession {

    private Constants.Browser browserName;

    private EventFiringWebDriver Driver;
   // private Logger log;

    private List<String> addArguments;


    public WebSession(Constants.Browser browserName, List<String> arguments) {
        this.browserName = browserName;

        this.addArguments = arguments;
      //  this.log = Logger.getLogger("devpinoyLogger");

        if (browserName.equals(Constants.Browser.CHROME)) {

            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments(addArguments);

            WebDriver webDriver = new ChromeDriver(options);
            this.Driver = new EventFiringWebDriver(webDriver);

            CustomWebDriverEvenListener listener = new CustomWebDriverEvenListener();
            Driver.register(listener);


        } else {
            System.out.println("wrong driver selected");

        }
    }

//
//    public Constants.Browser getBrowserName() {
//        return browserName;
//    }
//
//    public boolean getBrowserOption() {
//        return browserOption;
//    }


    public EventFiringWebDriver getDriver() {
        return Driver;
    }

//    public Logger getLog() {
//        return log;
//    }
}
