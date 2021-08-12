package Configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;


public class WebSession {

    private Constants.Browser browserName;
    private boolean browserOption;
    private EventFiringWebDriver Driver;
   // private Logger log;


    public WebSession(Constants.Browser browserName, boolean browserOption) {
        this.browserName = browserName;
        this.browserOption = browserOption;
      //  this.log = Logger.getLogger("devpinoyLogger");

        if (browserName.equals(Constants.Browser.CHROME)) {

            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();

            if (browserOption) {
                options.addArguments("--headless", "--window-size=1920,1080", "--disable-gpu", "--disable-extensions", "--no-sandbox", "--incognito");
            }


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
