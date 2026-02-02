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
    WebElement instutionType;

    @FindBy(xpath = "//input[@id='Company']")
    WebElement instutionName;

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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(courseraForCampus));
        courseraForCampus.click();
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

    public void selectInstutionType(String type) {
        new Select(instutionType).selectByValue(type);
    }

    public void enterInstutionName(String name) {
        instutionName.sendKeys(name);
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

    public void getEmailErrorMessage() {
        emailInput.click();
        String errorMsg = emailErrorMessage.getText();
        System.out.println();
        System.out.println(errorMsg);
    }

    public void takeScreenShot(){
        TakesScreenshot ts=(TakesScreenshot)driver;
        File tempimg=ts.getScreenshotAs(OutputType.FILE);
        File img=new File(System.getProperty("user.dir")+"\\Screenshots\\coursera.png");
        tempimg.renameTo(img);
    }
}
