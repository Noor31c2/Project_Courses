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
        test.info("Starting test: submitingEnterpriseWithInvalidMail");

        ForEnterprise fe = new ForEnterprise(driver);
        logger.info("Filling For Enterprise form with invalid email");

        fe.clickForEnterpriseLink();
        fe.clickForEnterprisePageLink();
        fe.clickCourseraForCampusLogo();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.coursera.org/campus";
        logger.info("Verifying page URL");
        Assert.assertEquals(actualUrl, expectedUrl, "Page URL does not match!");

        fe.enterFirstName("John");
        fe.enterLastName("Doe");
        fe.enterEmail("johnsmithgmail.com"); // invalid email
        fe.enterPhoneNo("9876543210");
        fe.selectInstitutionType("University/4 Year College");
        fe.enterInstitutionName("ABC University");
        fe.selectJobTitle("Professor");
        fe.selectDepartment("Student Affairs");
        fe.selectDescription("Courses for myself");
        fe.selectCountry("India");
        fe.selectState("Andhra Pradesh");

        fe.clickSubmitButton();

        logger.info("Verifying error message for invalid email");
        String errorMessage = fe.getEmailErrorMessage();

        Assert.assertTrue(fe.isEmailErrorDisplayed(), "Email error message is not displayed!");
        Assert.assertNotNull(errorMessage, "Error message element not found!");
        Assert.assertFalse(errorMessage.isEmpty(), "Error message is empty!");
        Assert.assertTrue(errorMessage.toLowerCase().contains("valid email"),
                "Error message does not indicate invalid email!");

        logger.info("Taking screenshot of the error message");
        fe.takeScreenShot();

        logger.info("******Ending TC34_submitingEnterpriseWithInvalidMail******");
    }
}
