package MercuryTour.ObjectsRepo;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePageObject
{
    WebDriver driver;



    public void BasePageObject(WebDriver webdriver)
    {
        this.driver = webdriver;
        PageFactory.initElements(webdriver,this);
    }
}
