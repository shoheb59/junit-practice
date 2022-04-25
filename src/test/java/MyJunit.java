import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyJunit {
    WebDriver driver;

    @Before
    public void setProperty()

    {
//        System.setProperty("webdriver.gecko.driver", "./src/test/resources/geckodriver.exe");
//        FirefoxOptions ops = new FirefoxOptions();
//        ops.addArguments("--headed");
//        driver = new FirefoxDriver(ops);//polymorphism - overridding holo childclass firefoxfriver, OPS - ta ekhne parameterized constructor hisae kaz krtese
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver.exe");
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--headed");
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }
    @Test
    public void getTitle()
    {
        driver.get("https://demoqa.com");
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals("ToolsQA",title);
    }

    @Test
    public void chekcIfImageExists()
    {
        driver.get("https://demoqa.com");
        WebElement image1 = driver.findElement(By.cssSelector("img"));
        Assert.assertTrue(String.valueOf(image1.isDisplayed()),true);
    }

    @Test
    public void writeSomthing()
    {
        driver.get("https://demoqa.com/text-box");
        //WebElement txtUname = driver.findElement(By.id("userName"));
        //txtUname.sendKeys("Hasnat Shoheb");

        List <WebElement> elements = driver.findElements(By.tagName("input"));

        elements.get(0).sendKeys("Hasnat");
        elements.get(1).sendKeys("hasnat@gmail.com");

        driver.findElement(By.id("submit")).click();



    }

    @Test
    public void clickButton()
    {
        driver.get("https://demoqa.com/buttons");
        List <WebElement>  element = driver.findElements(By.tagName("button"));
        element.get(3).click();

        Actions actions = new Actions(driver);
        actions.doubleClick(element.get(1)).perform();

        //Use contetClick for right click
        actions.contextClick(element.get(2)).perform();

        String doubleClick = driver.findElement(By.id("doubleClickMessage")).getText();
        String rightClick = driver.findElement(By.id("rightClickMessage")).getText();
        String dynamicClick = driver.findElement(By.id("ue626")).getText();

        Assert.assertTrue(doubleClick.contains("You have done a double click"));
        Assert.assertTrue(rightClick.contains("You have done a right click"));
        Assert.assertTrue(dynamicClick.contains("You have done a dynamic click"));




    }
    @After
    public void closeDriver()
    {
        //driver.close(); //Specific Tab jodi keta dita cy
        //driver.quit();
    }


}
