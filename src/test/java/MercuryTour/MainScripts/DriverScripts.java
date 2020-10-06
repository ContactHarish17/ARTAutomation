package MercuryTour.MainScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class DriverScripts extends CommonFunctions{

    WebDriver driver;
    File file;

    @BeforeTest
    @Parameters({"BrowserName", "url"})
    public void setUp(String browserName, String url)
    {
        if(browserName.equalsIgnoreCase("chrome"))
        {
            file = new File("D:\\DevTools\\chromedriver\\chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
            driver = new ChromeDriver();
            driver.navigate().to(url);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }
        else if(browserName.equalsIgnoreCase("firefox"))
        {
            System.setProperty("webdriver.gecko.driver", "");
            driver = new FirefoxDriver();
            driver.navigate().to(url);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        }
    }



    public void waitForElementPresent(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }
}
