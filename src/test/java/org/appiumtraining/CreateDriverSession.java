package org.appiumtraining;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

public class CreateDriverSession {
    public static AppiumDriver initializeDriver(String platformName) throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(CapabilityType.PLATFORM_NAME, platformName);
        caps.setCapability("newCommandTimeout",300);

        URL url = new URI("http://127.0.0.1:4723").toURL();
        String appUrl = "";
        switch(platformName.toLowerCase()) {
            case "android":
                appUrl = System.getProperty("user.dir")
                        + File.separator + "src"
                        + File.separator + "test"
                        + File.separator + "resources"
                        + File.separator + "ApiDemos-debug.apk";


                caps.setCapability("deviceName", "Pixel6Pro");
                caps.setCapability("automationName", "uiautomator2");
                caps.setCapability("platformName", platformName);
                //caps.setCapability("app",appUrl);
                caps.setCapability("avd","Pixel6Pro");
                //caps.setCapability("avdLaunchTimeout", Duration.ofMinutes(3));

                //caps.setCapability("appPackage", "io.appium.android.apis"); //used to wait for a package to be launched
                //caps.setCapability("appActivity", "io.appium.android.apis.accessibility.CustomViewAccessibilityActivity");

                /*Use these capabilities to open Maps*/
                caps.setCapability("appPackage","com.google.android.apps.maps");
                caps.setCapability("appActivity","com.google.android.maps.MapsActivity");

                /**
                 Use this capability to download ChromeDriver automatically
                 Using the command "appium --allow-insecure chromedriver_autodownload"
                 */
                caps.setCapability("browserName","Chrome");

                return new AndroidDriver(url, caps);

            case "ios":
                appUrl = System.getProperty("user.dir")
                        + File.separator + "src"
                        + File.separator + "test"
                        + File.separator + "resources"
                        + File.separator + "UIKitCatalog-iphonesimulator.app";

                caps.setCapability("platformName", platformName);
                caps.setCapability("deviceName", "iPhone 14 Pro");
                caps.setCapability("automationName", "XCUITest");
                caps.setCapability("simulatorStartupTimeout", "180000"); //to initialize a simulator
                caps.setCapability("app", appUrl);
                //caps.setCapability("bundleId","com.apple.Maps");

                //caps.setCapability("bundleId", "com.example.apple-samplecode.UICatalog");
                caps.setCapability("includeSafariInWebViews", true);
                caps.setCapability("webviewConnectTimeout","90000");

                return new IOSDriver(url, caps);

            default:
                throw new Exception("!!¡¡invalid device!!¡¡");
        }
    }
}