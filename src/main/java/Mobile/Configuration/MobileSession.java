package Mobile.Configuration;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class MobileSession {
    @Test
    public void AppiumTest() throws MalformedURLException {

        AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File("//Users//muhammad.faiz//.nvm//versions//node//v14.19.1//lib//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("FaizPhone");
        options.setApp("//Users//muhammad.faiz//Documents//Repositories//SAF//src//test//java//learn//resources//ApiDemos-debug.apk");
        AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723"), options);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Preference\"]")).click();
        driver.quit();
        service.stop();

    }
}
