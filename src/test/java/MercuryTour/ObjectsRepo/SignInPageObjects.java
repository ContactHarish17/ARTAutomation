package MercuryTour.ObjectsRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPageObjects  {

    final WebDriver driver;


    public SignInPageObjects(WebDriver webdriver)
    {
       this.driver = webdriver;
    }

    @FindBy(css = "input[name='userName']")
    public WebElement userName;

    @FindBy(css = "[name=\"password\"]")
    public WebElement password;

    @FindBy(css = "[name=\"login\"][type=\"image\"]")
    public WebElement siginbutton;

    @FindBy(linkText = "SIGN-ON")
    public WebElement SignONLink;

    @FindBy(xpath = "//*[text()=\"SIGN-ON\"]")
    public WebElement SignOn;


}