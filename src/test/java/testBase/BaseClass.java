package testBase;

import com.aventstack.extentreports.ExtentReports;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import utilities.ExtentReportManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class BaseClass {

    public static WebDriver driver;
    public static Logger logger;
    public Properties p;
    protected static ExtentReports extent;

    @BeforeSuite
    @Parameters({"os","browser"})
    public void setup(String os, String browser) throws IOException {
        //Loading config.properties file
        logger = LogManager.getLogger(this.getClass());

//        FileReader file = new FileReader("C:\\Users\\2457151\\IdeaProjects\\LocalMajorProject\\src\\test\\resources\\config.properties");
        FileReader file = new FileReader(System.getProperty("user.dir") + "/src/test/resources/config.properties");
        p=new Properties();
        p.load(file);

        switch(browser.toLowerCase()){
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                // Setup EdgeDriver
                driver = new EdgeDriver();
                break;
            case "firefox":
                // Setup FirefoxDriver
                driver = new FirefoxDriver();
                break;
            default:
                logger.error("Browser not supported: " + browser);
                System.out.println("Invalid browser! Supported browsers are: chrome, edge, firefox.");
                return;
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(p.getProperty("appURL"));
        driver.manage().window().maximize();


        logger.info("Extent report initialized.");

    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
        if(driver!=null){
            driver=null;
        }
    }

    public String captureScreen(String tname) throws IOException {

        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath=System.getProperty("user.dir")+"\\Screenshots\\FailedTestCasesScreenShots" + tname + "_" + timeStamp + ".png";
        File targetFile=new File(targetFilePath);

        sourceFile.renameTo(targetFile);

        return targetFilePath;

    }
}
