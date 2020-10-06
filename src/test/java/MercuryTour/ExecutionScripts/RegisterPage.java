package MercuryTour.ExecutionScripts;

import MercuryTour.MainScripts.DriverScripts;
import MercuryTour.ObjectsRepo.RegisterPageObjects;
import MercuryTour.TestData.RegisterData;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class RegisterPage extends DriverScripts {

    RegisterPageObjects registerPageObjects;
    static WebDriver driver;

    public void initialiseobjects()
    {

        registerPageObjects = PageFactory.initElements(driver,RegisterPageObjects.class);
    }

    @Test(priority = 1)
    public void testRegisterUser()
    {
        initialiseobjects();
        clickButton(registerPageObjects.registerlink);
        waitForElementPresent(registerPageObjects.firstname);
    }

    @Test(priority = 2)
    public void testEnterDetails()
    {
        clickButton(registerPageObjects.firstname);
        enterText(registerPageObjects.firstname, RegisterData.FirstName);
    }







}
