package seleniumtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class homepage {

    WebDriver driver;
    File file;


    @BeforeTest
    public void setUp()
    {

            file = new File("D:\\DevTools\\chromedriver\\chromedriver.exe");
            System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
            driver = new ChromeDriver();
    }

    @Test(priority = 1)
    public void testOpenURl()
    {
        driver.navigate().to("https://www.unilogcorp.com/");
        driver.manage().window().fullscreen();
        WebDriverWait wait = new WebDriverWait(driver,60);
        By textmysore = By.xpath("//*[@id=\"text-4\"]/div/text()[2]");

      //  new WebDriverWait(chromed, pageLoadTimeout).until(
        //        webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

      //  wait.until(ExpectedConditions.presenceOfElementLocated(textmysore));
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

    }


    @Test(priority = 2)
    public void testNumberofLinksOnHomePage()
    {
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("the number of links are "+ links.size());
        for(int i=0;i<links.size();i++)
        {
            System.out.println("the links are :"+ links.get(i).getAttribute("href"));
        }

    }

    @Test(priority = 3)
    public void testCheckBrokenLinks()
    {
        HttpURLConnection httpURLConnection;
        int responsecode = 200;
        String url = "";

        List<WebElement> links = driver.findElements(By.tagName("a"));
        Iterator<WebElement> it = links.iterator();
        while(it.hasNext())
        {
            url = it.next().getAttribute("href");
        }
        if(url == null || url.isEmpty())
        {
            System.out.println("the url isn't proper");
        }

        try {
            httpURLConnection = (HttpURLConnection)( new URL(url).openConnection());
            httpURLConnection.setRequestMethod("HEAD");
            httpURLConnection.connect();
            responsecode = httpURLConnection.getResponseCode();
            if(responsecode >= 400)
            {
                System.out.println(url + "the links are broken");
            }else
            {
                System.out.println(url + "the links are valid");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test(priority = 4)
    public void testNumberofImagesonHomePage()
    {
        List<WebElement> images = driver.findElements(By.tagName("img"));
        System.out.println("the number of images are " + images.size());
        for(int i=0;i<images.size();i++)
        {
            System.out.println("the images are "+ images.get(i).getAttribute("src"));
        }
    }

    @AfterTest
    public void tearDown()
    {

        driver.close();
    }
}
