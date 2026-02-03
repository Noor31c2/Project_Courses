package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.SearchResults;
import testBase.BaseClass;

public class TC10_DisplayingFirstTwoCourses extends BaseClass {
    @Test
    public void filteringCoursesTest() {
        SearchResults sr = new SearchResults(driver);
        logger.info("******Starting TC10_FilteringCoursesTest******");

        sr.clickLanguageFilter();
        logger.info("Applying English language filter");
        sr.clickEnglishCheckbox();
        sr.clickLanguagesViewButton();

        sr.clickLevelFilter();
        logger.info("Applying Beginner level filter");
        sr.clickBeginnerCheckbox();
        sr.clickLevelViewButton();

        logger.info("Displaying first two courses after applying filters:");

        // Assertions
        Assert.assertTrue(sr.isSearchResultDisplayed(), "No courses displayed after applying filters!");
        Assert.assertTrue(sr.getCoursesCount() >= 2, "Less than two courses available after filtering!");

        String firstTitle = sr.getCourseTitle(0);
        String firstDuration = sr.getCourseDuration(0);
        String firstRating = sr.getCourseRating(0);

        System.out.println("First Course Title: " + firstTitle);
        System.out.println("First Course Duration is: " + firstDuration);
        System.out.println("First Course Rating: " + firstRating);

        Assert.assertFalse(firstTitle.isEmpty(), "First course title is empty!");
        Assert.assertFalse(firstDuration.isEmpty(), "First course duration is empty!");
        Assert.assertFalse(firstRating.isEmpty(), "First course rating is empty!");

        String secondTitle = sr.getCourseTitle(1);
        String secondDuration = sr.getCourseDuration(1);
        String secondRating = sr.getCourseRating(1);

        System.out.println("Second Course Title: " + secondTitle);
        System.out.println("Second Course Duration is: " + secondDuration);
        System.out.println("Second Course Rating: " + secondRating);

        Assert.assertFalse(secondTitle.isEmpty(), "Second course title is empty!");
        Assert.assertFalse(secondDuration.isEmpty(), "Second course duration is empty!");
        Assert.assertFalse(secondRating.isEmpty(), "Second course rating is empty!");

        logger.info("******Ending TC10_FilteringCoursesTest******");
    }
}
