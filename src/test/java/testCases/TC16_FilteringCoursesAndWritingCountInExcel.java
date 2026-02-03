package testCases;

import org.testng.annotations.Test;
import pageObject.GettingCourseDetails;
import testBase.BaseClass;

import java.io.IOException;

public class TC16_FilteringCoursesAndWritingCountInExcel extends BaseClass {
    @Test
    public void writingInExcel() throws IOException {
        logger.info("******Starting TC16_FilteringCoursesAndWritingCountInExcel******");
        GettingCourseDetails gcd = new GettingCourseDetails(driver);

        logger.info("Clearing filters before writing");
        gcd.clickClearAllButton();

        logger.info("Writing language and level options with their course counts to Excel file");
        gcd.writeLanguageOptionsAndCount();

        logger.info("Verified options and counts successfully written to Excel");
        logger.info("******Ending TC16_FilteringCoursesAndWritingCountInExcel******");
    }
}
