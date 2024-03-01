package org.appiumtraining;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.seleniumhq.jetty9.util.resource.URLResource;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

public class StartDriverSession {
    public static void main(String[] args) throws URISyntaxException, MalformedURLException {
        String device = "ios";
        DesiredCapabilities caps = new DesiredCapabilities();
        URL url = new URI("http://0.0.0.0:4723").toURL();

        if(device.equals("android")){
            String appUrl = System.getProperty("user.dir")
                    + File.separator + "src"
                    + File.separator + "test"
                    + File.separator + "resources"
                    + File.separator + "ApiDemos-debug.apk";

            UiAutomator2Options options = new UiAutomator2Options()
                    .setDeviceName("Pixel6Pro")
                    .setAutomationName("UiAutomator2")
                    .setPlatformName("Android")
                    .setApp(appUrl)
                    .setAvd("Pixel6Pro")
                    .setAvdLaunchTimeout(Duration.ofMinutes(3))
                    .setAppWaitPackage("io.appium.android.apis") //used to wait for a package to be launched
                    .setAppActivity("io.appium.android.apis.accessibility.CustomViewAccessibilityActivity");

            AppiumDriver driver = new AppiumDriver(url, options);
        }
        else if (device.equals("ios")){
            String appUrl = System.getProperty("user.dir")
                    + File.separator + "src"
                    + File.separator + "test"
                    + File.separator + "resources"
                    + File.separator + "UIKitCatalog-iphonesimulator.app";

            caps.setCapability("platformName","iOS");
            caps.setCapability("deviceName","iPhone 14 Pro");
            caps.setCapability("automationName", "XCUITest");
            caps.setCapability("simulatorStartupTimeout", "180000"); //to initialize a simulator
            //caps.setCapability("udid","43F3BA20-00FB-4B1A-AEA2-6F13727BB069");
            caps.setCapability("app", appUrl);
            AppiumDriver driver = new AndroidDriver(url, caps);
        }
    }
}