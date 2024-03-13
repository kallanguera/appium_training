package org.appiumtraining;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class Waits {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        By alertViews = AppiumBy.accessibilityId("Alert Views1");
        By okayCancel = AppiumBy.accessibilityId("Okay / Cancel");

        driver.findElement(alertViews).click();
        driver.findElement(okayCancel).click();
    }
}
