package org.appiumtraining;

//https://github.com/appium/appium-uiautomator2-driver/blob/master/docs/android-mobile-gestures.md

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class AndroidGestures {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");

        clickSkip(driver);

        WebElement mapScrollView = driver.findElement(AppiumBy.id("com.google.android.apps.maps:id/home_bottom_sheet_container"));
        dragAndDropGesture(driver, mapScrollView, 1130,1567, 680, 830);

        pitchOpenGesture(driver);
        pitchOpenGesture(driver);
        Thread.sleep(2000);
        pitchCloseGesture(driver);
    }
    public static void longClickGesture(AppiumDriver driver){
        By views = AppiumBy.accessibilityId("Views");
        By dragAndDrop = AppiumBy.accessibilityId("Drag and Drop");
        By dragDot = AppiumBy.id("io.appium.android.apis:id/drag_dot_1");

        driver.findElement(views).click();
        driver.findElement(dragAndDrop).click();

        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "x", 217,
                "y", 659,
                "duration", 1000
        ));

    }

    public static void clickGesture(AppiumDriver driver){
        WebElement element = driver.findElement(AppiumBy.accessibilityId("Views"));

        driver.executeScript("mobile: clickGesture", ImmutableMap.of(
                "elementId",((RemoteWebElement) element).getId()
        ));
    }

    public static void dragAndDropGesture(AppiumDriver driver){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement element = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));

        driver.executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", 840,
                "endY", 1350
        ));
    }

    public static void dragAndDropGesture(AppiumDriver driver, WebElement element, int startX, int startY, int endX, int endY) throws InterruptedException {
        Thread.sleep(1000);
        driver.executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "startX", startX,
                "startY", startY,
                "endX", endX,
                "endY", endY
        ));
    }

    public static void pitchOpenGesture(AppiumDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        driver.executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
                "left", 300,
                "top", 1000,
                "width", 400,
                "height", 400,
                "percent", 0.8
        ));
    }

    public static void clickSkip(AppiumDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"SKIP\"]")).click();
        Thread.sleep(5000);
    }

    public static void pitchCloseGesture(AppiumDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        driver.executeScript("mobile: pinchCloseGesture", ImmutableMap.of(
                "left", 200,
                "top", 470,
                "width", 600,
                "height", 600,
                "percent", 0.9
        ));
    }
}