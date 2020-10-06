package MercuryTour.MainScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunctions {


    DriverScripts driverScripts = new DriverScripts();



    public void enterText(WebElement element, String text)
    {

        driverScripts.waitForElementPresent(element);
        element.sendKeys(text);
    }

    public void clickButton(WebElement element)
    {
        driverScripts.waitForElementPresent(element);
        element.click();
    }

    public void selectOption(WebElement element,String optiontext)
    {
        Select soptions = new Select(element);
        soptions.selectByValue(optiontext);

    }

    public void scrollpage(int from, int to)
    {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driverScripts.driver;
        //scroll down by 500 points
        javascriptExecutor.executeScript("window.scrollBy(0,500)","");

        //scroll to the bottomt of the page
        javascriptExecutor.executeAsyncScript("window.scroll(0,document.body.scrollHeight)");

        //scroll to a paricular element
        WebElement about = driverScripts.driver.findElement(By.id("a-autoid-0-announce"));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", about);

        //Scroll horizontally
        javascriptExecutor.executeScript("window.scrollBy(1000,0)", "");
    }

}
