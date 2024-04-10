package org.appiumtraining;

//https://github.com/appium/appium-uiautomator2-driver/blob/master/docs/android-mobile-gestures.md

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class iOSGestures {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("ios");

        slider(driver, "0.7", "Default");
        slider(driver, "0.3", "Custom");
        slider(driver, "0.85", "Min and Max Images");
        slider(driver, "0.19", "Tinted");
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

    /**
     * This method was created to use with Maps,
     * so you have to make sure on CreateDriverSession.java
     * that is set correctly params "bundleId":"com.apple.Maps"
     * to initialize the correct app
     *
     * @param driver AppiumDriver
     */
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

    private static void pickerWheel(AppiumDriver driver, String color, String order, Integer value) {
        driver.findElement(AppiumBy.accessibilityId("Picker View")).click();

        boolean flag = false;
        while(!flag){
            WebElement redPickerWheel = driver.findElement(AppiumBy
                    .iOSNsPredicateString("label == \""+ StringUtils.capitalize(color) +" color component value\""));
            Map<String, Object> params = new HashMap<>();
            params.put("order", order.toLowerCase());
            params.put("offset", 0.15);
            params.put("element", ((RemoteWebElement) redPickerWheel).getId());
            driver.executeScript("mobile: selectPickerWheelValue", params);
            if(redPickerWheel.getText().equals(value.toString())){
                flag = true;
            };
        }
    }


    /**
     * Slider method, is necessary set the percentage and the name of slider,
     * you can adapt it removing the switch logic using a proper locator.
     *
     * @param driver     AppiumDriver
     * @param percentage string with format "0.0" to select a percentage
     * @param sliderName valid slider names are: default, tinted, custom, images
     */
    private static void slider(AppiumDriver driver, String percentage, String sliderName){
        driver.findElement(AppiumBy.accessibilityId("Sliders")).click();
        List<WebElement> elements = driver.findElements(AppiumBy.xpath("//XCUIElementTypeSlider"));
        switch (sliderName.toLowerCase()){
            case "default":
                elements.getFirst().sendKeys(percentage);
                break;
            case "tinted":
                elements.get(1).sendKeys(percentage);
                break;
            case "custom":
                elements.get(2).sendKeys(percentage);
                break;
            case "images":
                elements.get(3).sendKeys(percentage);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + sliderName);
        }

    }
}