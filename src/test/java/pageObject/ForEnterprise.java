package pageObject;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class ForEnterprise extends BasePage {
    public ForEnterprise(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='For Enterprise']")
    WebElement forEnterpriseLink;

    @FindBy(xpath = "//a[@href='https://www.coursera.org/campus']")
    WebElement forEnterprisePageLink;

    @FindBy(xpath = "//div[@class='css-108l157']/a/img")
    WebElement courseraForCampus;

    @FindBy(xpath = "//input[@id='FirstName']")
    WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='LastName']")
    WebElement lastNameInput;

    @FindBy(xpath = "//input[@id='Email']")
    WebElement emailInput;

    @FindBy(xpath = "//input[@id='Phone']")
    WebElement phoneInput;

    @FindBy(xpath = "//select[@id='Institution_Type__c']")
    WebElement institutionType;

    @FindBy(xpath = "//input[@id='Company']")
    WebElement institutionName;

    @FindBy(xpath = "//select[@id='Title']")
    WebElement jobTitle;

    @FindBy(xpath = "//select[@id='Department']")
    WebElement department;

    @FindBy(xpath = "//select[@id='Self_Reported_Needs__c']")
    WebElement description;

    @FindBy(xpath = "//select[@id='Country']")
    WebElement country;

    @FindBy(xpath = "//select[@id='State']")
    WebElement state;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;

    @FindBy(xpath = "//div[@id='ValidMsgEmail']")
    WebElement emailErrorMessage;

    public void clickForEnterpriseLink() {
        forEnterpriseLink.click();
    }

    public void clickForEnterprisePageLink() {
        forEnterprisePageLink.click();
    }

    public void clickCourseraForCampusLogo() {
        waitForElement(courseraForCampus).click();
    }

    public void enterFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void enterPhoneNo(String phoneNo) {
        phoneInput.sendKeys(phoneNo);
    }

    public void selectInstitutionType(String type) {
        new Select(institutionType).selectByValue(type);
    }

    public void enterInstitutionName(String name) {
        institutionName.sendKeys(name);
    }

    public void selectJobTitle(String title) {
        new Select(jobTitle).selectByValue(title);
    }

    public void selectDepartment(String dept) {
        new Select(department).selectByValue(dept);
    }

    public void selectDescription(String desc) {
        new Select(description).selectByValue(desc);
    }

    public void selectCountry(String countryName) {
        new Select(country).selectByValue(countryName);
    }

    public void selectState(String stateName) {
        new Select(state).selectByVisibleText(stateName);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public String getEmailErrorMessage() {
        return waitForElement(emailErrorMessage).getText().trim();
    }

    public boolean isEmailErrorDisplayed() {
        try {
            return waitForElement(emailErrorMessage).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void takeScreenShot() {
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String targetFilePath = System.getProperty("user.dir") + "\\Screenshots\\" + timeStamp + "_coursera.png";
        File targetFile = new File(targetFilePath);
        try {
            Files.copy(sourceFile.toPath(), targetFile.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private WebElement waitForElement(WebElement element) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(element));
    }
}
