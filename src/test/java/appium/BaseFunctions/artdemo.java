package appium.BaseFunctions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.URL;

public class artdemo {

    DesiredCapabilities capabilities;
    AndroidDriver<MobileElement> androidDriver;
    AppiumDriverLocalService appiumDriverLocalService;
    AppiumServiceBuilder appiumServiceBuilder;


    @BeforeTest
    public void setUp() {
        try {
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            capabilities.setCapability(MobileCapabilityType.APP, "");
            capabilities.setCapability(MobileCapabilityType.UDID, "");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            capabilities.setCapability("appPackage", "");
            capabilities.setCapability("appActivity", "");
            androidDriver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @AfterTest
    public void tearDown()
    {
        androidDriver.quit();
        androidDriver.removeApp("");
    }



    public void startAppiumServer()
    {
        appiumServiceBuilder = new AppiumServiceBuilder();

        appiumDriverLocalService = AppiumDriverLocalService.buildDefaultService();
        appiumDriverLocalService.start();

        appiumDriverLocalService = AppiumDriverLocalService.buildService(appiumServiceBuilder);
        appiumDriverLocalService.start();

        appiumDriverLocalService = AppiumDriverLocalService.buildService(
                    new AppiumServiceBuilder()
                .usingDriverExecutable(new File(""))
                .withAppiumJS(new File(""))
                .usingPort(4755));
        appiumDriverLocalService.start();

    }

    public String appiumURL()
    {

        return appiumDriverLocalService.getUrl().toString();
    }

    public void stopAppiumServer()
    {
        appiumDriverLocalService.stop();
    }
}




