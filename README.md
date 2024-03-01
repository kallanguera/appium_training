# Appium Training with Java and Maven

This project consists in a basic structure that is used for training and getting better comprehension about Appium automation testing configurations for Android and iOS, using Java as main language and Maven as package manager.

## Requirements:
- Java 21
- Appium
- Maven

### Launch Android Emulator automatically

The capabilities _avd_ and _avdLaunchTimeout_ are used together to initialize an Android emulator based on avd name.

An example below using **UiAutomator2**:
```java
UiAutomator2Options options = new UiAutomator2Options()
    .setDeviceName("Pixel6Pro")
    .setAutomationName("UiAutomator2")
    .setPlatformName("Android")
    .setApp(appUrl)
    .setAvd("Pixel6Pro")
    .setAvdLaunchTimeout(Duration.ofMinutes(3))
```

### Launch iPhone Simulator automatically

The capability _simulatorStartupTimeout_ is used to initialize an iPhone simulator when it is not started yet.

```java
DesiredCapabilities caps = new DesiredCapabilities();
caps.setCapability("platformName","iOS");
caps.setCapability("deviceName","iPhone 14 Pro");
caps.setCapability("automationName", "XCUITest");
caps.setCapability("simulatorStartupTimeout", "180000"); //to initialize a simulator
caps.setCapability("app", appUrl);
```