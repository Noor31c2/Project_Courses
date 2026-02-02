package testCases;

import org.apache.logging.log4j.core.net.Priority;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.SearchResults;
import testBase.BaseClass;

import java.time.Duration;

import static utilities.ExtentReportManager.test;

public class TC04_searchWebDevelopmentCourseTest extends BaseClass {

    @Test
    public void searchWebDevelopmentCourseTest(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        logger.info("******Starting TC04_searchWebDevelopmentCourseTest******");
//        test.info("Searching for Web Development course");
        HomePage hp = new HomePage(driver);
        hp.clickSearchBox();
        logger.info("Entering Web Development in search box");
        hp.sendKeysToSearchBox("Web Development");
        logger.info("Clicking on search button");
//        hp.clickSearchButton();
        Actions act=new Actions(driver);
        act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
        logger.info("******Ending TC04_searchWebDevelopmentCourseTest******");
//        test.info("Ended TC04_searchWebDevelopmentCourseTest");
    }

}
