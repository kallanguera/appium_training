package org.appiumtraining;

//https://github.com/appium/appium-uiautomator2-driver/blob/master/docs/android-mobile-gestures.md

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.rmi.Remote;
import java.util.HashMap;
import java.util.Map;

public class iOSGestures {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("ios");

        tap(driver, "Picker View");
        pickerWheel(driver);
    }

    public static void swipeGesture(AppiumDriver driver){
        WebElement element = driver.findElement(AppiumBy.
                iOSNsPredicateString("type == \"XCUIElementTypeTable\""));
        Map<String, Object> params = new HashMap<>();

        params.put("direction","up");
        params.put("elementId",((RemoteWebElement) element).getId());
        driver.executeScript("mobile: swipe", params);
    }

    public static void scrollGesture(AppiumDriver driver){
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "down");
        driver.executeScript("mobile: scroll", params);

        WebElement lastElement = driver.findElement(AppiumBy.
                accessibilityId("Activity Indicators"));
        params = new HashMap<>();

//        params.put("direction", "down");
        params.put("elementId", ((RemoteWebElement) lastElement).getId());
//        params.put("predicateString","label == \"Web View\"");
        params.put("toVisible", true);
        driver.executeScript("mobile: scroll", params);
    }

    //this method was created to use with Maps,
    // so you must to make sure on CreateDriverSession.java
    // that is set correctly params "bundleId":"com.apple.Maps"
    public static void pinchGesture(AppiumDriver driver) {
        driver.findElement(AppiumBy.accessibilityId("Fechar")).click();

        Map<String, Object> params1 = new HashMap<>();
        params1.put("scale", 20);
        params1.put("velocity", 2.2);
        driver.executeScript("mobile: pinch", params1);

        WebElement element = driver.findElement(AppiumBy.
                iOSClassChain("**/XCUIElementTypeOther[`name == \"ControlContainerViewController.OverlayView\"`][1]"));

        Map<String, Object> params2 = new HashMap<>();
        params2.put("elementId", ((RemoteWebElement) element).getId());
        params2.put("scale", 0.1);
        params2.put("velocity", -2.2);
        driver.executeScript("mobile: pinch", params2);
    }

    public static void touchAndHold(AppiumDriver driver){
        driver.findElement(AppiumBy.accessibilityId("Steppers")).click();

        WebElement element = driver.findElement(AppiumBy
                .iOSClassChain("**/XCUIElementTypeButton[`label == \"Increment\"`][1]"));

        Map<String, Object> params = new HashMap<>();
        params.put("elementId", ((RemoteWebElement) element).getId());
        params.put("duration", 5);
        driver.executeScript("mobile: touchAndHold", params);
    }

    public static void tap(AppiumDriver driver, String accessibilityId){
        WebElement element = driver.findElement(AppiumBy.accessibilityId(accessibilityId));

        Map<String, Object> params = new HashMap<>();
        params.put("elementId", ((RemoteWebElement)element).getId());
        params.put("x", 0);
        params.put("y", 0);
        driver.executeScript("mobile: tap", params);

    }

    private static void pickerWheel(AppiumDriver driver) {

        WebElement redPickerWheel = driver.findElement(AppiumBy
                .iOSNsPredicateString("label == \"Red color component value\""));
        Map<String, Object> params = new HashMap<>();
        params.put("order", "next");
        params.put("offset", 0.15);
        params.put("element", ((RemoteWebElement) redPickerWheel).getId());
        driver.executeScript("mobile: selectPickerWheelValue", params);
    }



}