package testCases;

import org.testng.annotations.Test;
import pageObject.GettingCourseDetails;
import testBase.BaseClass;

import java.io.IOException;

import static utilities.ExtentReportManager.test;

public class TC16_FilteringCoursesAndWritingCountInExcel extends BaseClass {
    @Test
    public void writingInExcel() throws IOException {
        logger.info("******Starting TC16_FilteringCoursesAndWritingCountInExcel******");
//        test.info("Starting TC16_FilteringCoursesAndWritingCountInExcel");
        GettingCourseDetails gcd = new GettingCourseDetails(driver);
        logger.info("Writing language options and their course counts to Excel file");
        gcd.clickClearAllButton();
        gcd.WriteLanguageOptionsAndCount();
        logger.info("******Ending TC16_FilteringCoursesAndWritingCountInExcel******");
//        test.info("Ending TC16_FilteringCoursesAndWritingCountInExcel");

    }
}
