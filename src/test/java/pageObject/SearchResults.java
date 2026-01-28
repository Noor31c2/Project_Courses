package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchResults extends BasePage {
    public SearchResults(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//div[text()='Language']")
    WebElement languageFilter;

    @FindBy(xpath = "//span[text()='English']")
    WebElement englishCheckbox;

    @FindBy(xpath = "//span[@class='cds-button-label' and text()='View']")
    WebElement languagesViewButton;

    @FindBy(xpath = "//div[text()='Level']")
    WebElement levelFilter;

    @FindBy(xpath = "//span[text()='Beginner']")
    WebElement beginnerCheckbox;

    @FindBy(xpath = "//span[@class='cds-button-label' and text()='View']")
    WebElement levelViewButton;

    @FindBy(xpath = "//h3[contains(@class,'cds-CommonCard-title')]")
    List<WebElement> courseTitles;

    @FindBy(xpath = "//span[@class='css-4s48ix']")
    List<WebElement> courseRatings;

    @FindBy(xpath = "//p[@class='css-vac8rf']/parent::div[@class='cds-CommonCard-metadata']")
    List<WebElement> courseDurations;


    public void clickLanguageFilter(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(languageFilter));
        languageFilter.click();
    }

    public void clickEnglishCheckbox(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(englishCheckbox));
        englishCheckbox.click();
    }

    public void clickLanguagesViewButton(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(languagesViewButton));
        languagesViewButton.click();
    }

    public void clickLevelFilter() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(levelFilter));
        levelFilter.click();
    }

    public void clickBeginnerCheckbox(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(beginnerCheckbox));
        beginnerCheckbox.click();
    }

    public void clickLevelViewButton(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(levelViewButton));
        levelViewButton.click();
    }

    public String getCourseTitle(int index) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfAllElements(courseTitles));
        return courseTitles.get(index).getText();
    }

    public String getCourseRating(int index) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfAllElements(courseRatings));
        return courseRatings.get(index).getText();
    }

    public String getCourseDuration(int index) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfAllElements(courseDurations));
        return courseDurations.get(index).getText().replaceAll(".*?(\\d.*)", "$1");
    }

    public int getCoursesCount() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfAllElements(courseTitles));
        return courseTitles.size();
    }

}
