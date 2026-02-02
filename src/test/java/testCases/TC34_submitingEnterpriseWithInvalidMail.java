package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.ForEnterprise;
import testBase.BaseClass;

import static utilities.ExtentReportManager.test;

public class TC34_submitingEnterpriseWithInvalidMail extends BaseClass {
    @Test
    public void submitingEnterpriseWithInvalidMail() {
        logger.info("******Starting TC34_submitingEnterpriseWithInvalidMail******");
//        test.info("Starting test: submitingEnterpriseWithInvalidMail");
        ForEnterprise fe = new ForEnterprise(driver);
        logger.info("Filling For Enterprise form with invalid email");
        fe.clickForEnterpriseLink();
        fe.clickForEnterprisePageLink();
        fe.clickCourseraForCampusLogo();
//        String actualTitle = driver.getCurrentUrl();
//        String expectedTitle = "https://www.coursera.org/campus";
//        logger.info("Verifying page title");
//        Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match!");
        logger.info("Entering First Name");
        fe.enterFirstName("John");
        logger.info("Entering Last Name");
        fe.enterLastName("Doe");
        logger.info("Entering Invalid Email");
        fe.enterEmail("johnsmithgmail.com");
        logger.info("Entering Phone Number");
        fe.enterPhoneNo("9876543210");
        logger.info("Selecting Institution Type");
        fe.selectInstutionType("University/4 Year College");
        logger.info("Entering Institution Name");
        fe.enterInstutionName("ABC University");
        logger.info("Selecting Job Title");
        fe.selectJobTitle("Professor");
        logger.info("Selecting Department");
        fe.selectDepartment("Student Affairs");
        logger.info("Selecting Description");
        fe.selectDescription("Courses for myself");
        logger.info("Selecting Country");
        fe.selectCountry("India");
        logger.info("Selecting State");
        fe.selectState("Andhra Pradesh");
        logger.info("Submitting the form");
        fe.clickSubmitButton();
        logger.info("Verifying error message for invalid email");
        fe.getEmailErrorMessage();
        logger.info("Taking screenshot of the error message");
        fe.takeScreenShot();
        logger.info("******Ending TC34_submitingEnterpriseWithInvalidMail******");
//        test.info("Ended TC34_submitingEnterpriseWithInvalidMail");
    }
}
