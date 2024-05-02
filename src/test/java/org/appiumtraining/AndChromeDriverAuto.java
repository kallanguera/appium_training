package org.appiumtraining;

import io.appium.java_client.AppiumDriver;

public class AndChromeDriverAuto {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
        driver.get("https://byd.com");
    }
}
