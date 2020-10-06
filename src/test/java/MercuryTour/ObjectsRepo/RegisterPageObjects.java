package MercuryTour.ObjectsRepo;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegisterPageObjects {

    final WebDriver driver;
    public RegisterPageObjects(WebDriver webdriver)
    {
        this.driver = webdriver;
    }


    @FindBy(xpath = "//*[text()=\"REGISTER\"]")
    public WebElement registerlink;

    @FindBy(css = "[name='firstName']")
    public WebElement firstname;

    @FindBy(css = "[name='lastName']")
    public WebElement lastname;

    @FindBy(css = "[name='phone']")
    public WebElement phone;

    @FindBy(css="[name='userName']")
    public WebElement email;

    @FindBy(css = "[name='address1']")
    public WebElement mailingaddress1;

    @FindBy(css="[name='address2']")
    public WebElement mailingaddrss2;

    @FindBy(css="[name='city']")
    public WebElement mailingcity;

    @FindBy(css="[name='state']")
    public WebElement mailingstate;

    @FindBy(css="[name='postalcode']")
    public WebElement mainingpostcode;

    @FindBy(css="[name='country']']")
    public WebElement malingcountry;

    @FindBy(css = "[name='email']")
    public WebElement username;

    @FindBy(css="[name='password']")
    public WebElement password;

    @FindBy(css="[name='confirmPassword']")
    public WebElement confirmpassword;

    @FindBy(css="[name='register']")
    public WebElement registerButton;
}
