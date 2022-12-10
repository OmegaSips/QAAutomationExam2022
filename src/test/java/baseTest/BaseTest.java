package baseTest;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.Homepage;
import pages.MakeanAppoAnotherTryPage;
import pages.ConfirmationPage;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static WebDriver driver;
    protected Homepage homePage;
    protected MakeanAppoAnotherTryPage MakeAppoinstance;
    protected ConfirmationPage ConfirmationInstance;
    public static String driver_path = "chromedriver.exe";


    String BASEURL = "https://katalon-demo-cura.herokuapp.com/";


    @BeforeSuite
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver(options);
        // this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(BASEURL);
        driver.getTitle();
    }

    @BeforeMethod
    public void setup1() {

        homePage = new Homepage(driver);
        MakeAppoinstance = new MakeanAppoAnotherTryPage(driver);
        ConfirmationInstance = new ConfirmationPage(driver);
    }



    @AfterMethod
    public void captureScreenShots(ITestResult testResult) {

        if (ITestResult.FAILURE == testResult.getStatus()) {

            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            //this path is where it will save the screenshot we have captured of the results
            File destination = new File(System.getProperty("user.dir") +
                    "/resources/screenshot/Failed/" + testResult.getName() + "_" + testResult.getStartMillis() + ".png");

            try {
                FileHandler.copy(source, destination);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            //this path is where it will save the screenshot we have captured of the results
            File destination = new File(System.getProperty("user.dir") +
                    "/resources/screenshot/Passed/" + testResult.getName() + "_" + testResult.getStartMillis() + ".png");

            try {
                FileHandler.copy(source, destination);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @AfterSuite()
    public void tearDown() {
              driver.quit();

    }
}
