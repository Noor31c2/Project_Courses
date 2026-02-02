package testCases;

import org.testng.annotations.Test;
import pageObject.SearchResults;
import testBase.BaseClass;

import static utilities.ExtentReportManager.test;

public class TC10_DisplayingFirstTwoCourses extends BaseClass {
    @Test
    public void filteringCoursesTest() {
        SearchResults sr = new SearchResults(driver);
        logger.info("******Starting TC10_FilteringCoursesTest******");
//        test.info("Starting TC10_FilteringCoursesTest");
        sr.clickLanguageFilter();
        logger.info("Applying English language filter");
        sr.clickEnglishCheckbox();
        sr.clickLanguagesViewButton();
        sr.clickLevelFilter();
        logger.info("Applying Beginner level filter");
        sr.clickBeginnerCheckbox();
        sr.clickLevelViewButton();
        logger.info("Displaying first two courses after applying filters:");
        System.out.println("First Course Title: " + sr.getCourseTitle(0));
        System.out.println("First Course Duration is: " + sr.getCourseDuration(0).replaceAll(".*?(\\d.*)", "$1"));
        System.out.println("First Course Rating: " + sr.getCourseRating(0));
        System.out.println();
        System.out.println("Second Course Title: " + sr.getCourseTitle(1));
        System.out.println("Second Course Duration is: " + sr.getCourseDuration(1).replaceAll(".*?(\\d.*)", "$1"));
        System.out.println("Second Course Rating: " + sr.getCourseRating(1));
        logger.info("******Ending TC10_FilteringCoursesTest******");
//        test.info("Ending TC10_FilteringCoursesTest");
    }

}
