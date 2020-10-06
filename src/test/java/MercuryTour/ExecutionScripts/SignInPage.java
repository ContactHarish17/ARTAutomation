package MercuryTour.ExecutionScripts;

import MercuryTour.MainScripts.DriverScripts;
import MercuryTour.ObjectsRepo.SignInPageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SignInPage extends DriverScripts {

    SignInPageObjects signInPageObjects;
    static WebDriver driver;

    public void initialiseobjects()
    {
        signInPageObjects = PageFactory.initElements(driver,SignInPageObjects.class);
    }


    @Test(priority = 1)
    public void testSiginIntoMercurySite()
    {
        clickButton(signInPageObjects.SignONLink);
        enterText(signInPageObjects.userName,"harish");
        enterText(signInPageObjects.password,"harish17");
        clickButton(signInPageObjects.siginbutton);

    }
}
