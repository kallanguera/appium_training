package org.appiumtraining;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class iOSPredicateString {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");

        By myElement1 = AppiumBy.iOSNsPredicateString("type == \"XCUIElementTypeStaticText\" AND name CONTAINS \"Activity Indicators\"");
        System.out.println(driver.findElement(myElement1).getText());

        WebElement myElement = driver.findElement(AppiumBy.name("Activity Indicators"));
        System.out.println(myElement.getText());
    }
}
