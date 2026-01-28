package pageObject;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class GettingCourseDetails extends BasePage {

    public GettingCourseDetails(WebDriver driver){
        super(driver);
    }


    @FindBy(xpath = "//div[@class='sticky-filter-bar css-wbivlq']/button[2]/span[text()='Clear all']")
    WebElement clearAllButton;

    @FindBy(xpath = "//div[@class='css-1oiads2']/button/div[text()='Language']")
    WebElement languageFiltersButton;

    @FindBy(xpath = "//span[@class='cds-checkboxAndRadio-labelContent css-tvqrra']/span")
    List<WebElement> languageOptions;

    @FindBy(xpath = "//span[@class='cds-checkboxAndRadio-labelContent css-tvqrra']//span[@class='css-s63saa']")
    List<WebElement> languageOptionsCount;

    @FindBy(xpath = "//div[text()='Level']")
    WebElement levelFiltersButton;

    @FindBy(xpath = "//span[@class='cds-checkboxAndRadio-labelContent css-tvqrra']")
    List<WebElement> levelOptions;

    @FindBy(xpath = "//span[@class='cds-checkboxAndRadio-labelContent css-tvqrra']//span[@class='css-s63saa']")
    List<WebElement> levelOptionsCount;

    @FindBy(xpath = "//div[@class='css-f06sfw']/div/div/div/button/span[text()='View']")
    WebElement viewCoursesLevelButton;

    @FindBy(xpath = "//div[@class='css-f06sfw']/div/div/div/button/span[text()='View']")
    WebElement viewCoursesLanguageButton;

    public void clickClearAllButton(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(clearAllButton));
        clearAllButton.click();
    }

    public void clickLanguageFiltersButton(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(languageFiltersButton));
        languageFiltersButton.click();
    }

    public void clickLevelFiltersButton(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(levelFiltersButton));
        levelFiltersButton.click();
    }

    public void WriteLanguageOptionsAndCount() throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Courses Details");

        int rowNum = 0;

        Row headerRow = sheet.createRow(rowNum++);
        headerRow.createCell(0).setCellValue("Levels");
        headerRow.createCell(1).setCellValue("Counts");

//        levelFiltersButton.click();

        clickLevelFiltersButton();

        for(int i=0;i<levelOptions.size();i++){
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(levelOptions.get(i).getText().replaceAll("\\(.*", ""));
            row.createCell(1).setCellValue(levelOptionsCount.get(i).getText());
        }

        viewCoursesLevelButton.click();

        rowNum++; // Blank row for separation

//        languageFiltersButton.click();
        clickLanguageFiltersButton();
        Row langHeaderRow = sheet.createRow(rowNum++);
        langHeaderRow.createCell(0).setCellValue("Languages");
        langHeaderRow.createCell(1).setCellValue("Counts");

        for(int i=0;i<languageOptions.size();i++){
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(languageOptions.get(i).getText().replaceAll("\\(.*", ""));
            row.createCell(1).setCellValue(languageOptionsCount.get(i).getText());
        }

        for (int i = 0; i < 3; i++) {
            sheet.autoSizeColumn(i);
        }

        try(FileOutputStream fo = new FileOutputStream(System.getProperty("user.dir")+"\\Testdata\\"+"CoursesDetails.xlsx")){
            workbook.write(fo);
        }
        workbook.close();

        viewCoursesLanguageButton.click();
    }


}
