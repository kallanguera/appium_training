package org.appiumtraining;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;

import static org.openqa.selenium.support.PageFactory.*;

public class DifferentWayOfDefiningElements {
    @AndroidFindBy (xpath = "//*[@text=\"Accessibility\"]")
    @iOSXCUITFindBy (accessibility = "Activity Indicators")
    private static WebElement myElement3;

    public DifferentWayOfDefiningElements(AppiumDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
        printElementText(driver);

        driver = CreateDriverSession.initializeDriver("iOS");
        printElementText(driver);


    }

    public static void printElementText(AppiumDriver driver){
        DifferentWayOfDefiningElements differentWayOfDefiningElements = new DifferentWayOfDefiningElements(driver);
        System.out.println(myElement3.getText());
    }
}
