package testCases;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.SearchResults;
import testBase.BaseClass;

import java.time.Duration;

public class TC04_searchWebDevelopmentCourseTest extends BaseClass {

    @Test
    public void searchWebDevelopmentCourseTest(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        logger.info("******Starting TC04_searchWebDevelopmentCourseTest******");

        HomePage hp = new HomePage(driver);
        hp.clickSearchBox();
        logger.info("Entering Web Development in search box");
        hp.sendKeysToSearchBox("Web Development");
        logger.info("Clicking on search button");
//        hp.clickSearchButton();
        Actions act = new Actions(driver);
        act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();

        // Assertion: Verify search results are displayed
        SearchResults sr = new SearchResults(driver);
        boolean resultDisplayed = sr.isSearchResultDisplayed(); // Assume this method exists in SearchResults page object
        Assert.assertTrue(resultDisplayed, "Search results for 'Web Development' were not displayed!");

        logger.info("******Ending TC04_searchWebDevelopmentCourseTest******");
    }
}
