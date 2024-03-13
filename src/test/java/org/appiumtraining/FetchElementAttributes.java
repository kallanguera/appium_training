package org.appiumtraining;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class FetchElementAttributes {
    public static void main(String[] args) throws Exception{
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");

        By accessibility = AppiumBy.accessibilityId("Accessibility");
        System.out.println("text: " + driver.findElement(accessibility).getText());
        System.out.println("text: " + driver.findElement(accessibility).getAttribute("text"));
        System.out.println("focused: " + driver.findElement(accessibility).getAttribute("focused"));
        System.out.println("checked: " + driver.findElement(accessibility).getAttribute("checked"));
        System.out.println("enabled: " + driver.findElement(accessibility).getAttribute("enabled"));
        System.out.println("selected: " + driver.findElement(accessibility).getAttribute("selected"));
        System.out.println("displayed: " + driver.findElement(accessibility).getAttribute("displayed"));
        System.out.println("clickable: " + driver.findElement(accessibility).getAttribute("clickable"));


        driver = CreateDriverSession.initializeDriver("iOS");

        By activityIndicators = AppiumBy.accessibilityId("Activity Indicators");
        System.out.println("text: " + driver.findElement(activityIndicators).getText());
        System.out.println("text: " + driver.findElement(activityIndicators).getAttribute("label"));
        System.out.println("focused: " + driver.findElement(activityIndicators).getAttribute("focused"));
        //System.out.println("checked: " + driver.findElement(activityIndicators).getAttribute("checked"));
        System.out.println("enabled: " + driver.findElement(activityIndicators).getAttribute("enabled"));
        System.out.println("selected: " + driver.findElement(activityIndicators).getAttribute("selected"));
        System.out.println("displayed: " + driver.findElement(activityIndicators).getAttribute("visible"));
        System.out.println("hittable: " + driver.findElement(activityIndicators).getAttribute("hittable"));

        System.out.println("displayed: " + driver.findElement(activityIndicators).isDisplayed());


    }
}
