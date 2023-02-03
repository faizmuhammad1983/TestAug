package Configuration.Mobile;

import Configuration.Constants;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import java.net.URL;


public class MobileSession {
    private Constants.MobileOS MobileOS;
    private AndroidDriver androidDriver;
    private IOSDriver iosDriver;
    private URL serverURL;
    private String appPath;
    private String deviceName;

    public MobileSession(Constants.MobileOS mobileOS, URL serverURL, String appPath, String deviceName) {
        this.MobileOS = mobileOS;
        this.serverURL = serverURL;
        this.appPath = appPath;
        this.deviceName = deviceName;
        if(mobileOS.equals(Constants.MobileOS.Android)){
            UiAutomator2Options options = new UiAutomator2Options();
            options.setDeviceName(deviceName);
            options.setApp(appPath);
            this.androidDriver = new AndroidDriver(serverURL,options);
        } else if(mobileOS.equals(Constants.MobileOS.iOS)){
            XCUITestOptions options = new XCUITestOptions();
            options.setDeviceName(deviceName);
            options.setApp(appPath);
            this.iosDriver = new IOSDriver(serverURL,options);
        } else {
            System.out.println("Wrong mobile OS selected");
        }
    }

    public AndroidDriver getAndroidDriver() {
        return androidDriver;
    }

    public IOSDriver getIosDriver() {
        return iosDriver;
    }
}
