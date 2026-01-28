package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='search-autocomplete-input']")
    WebElement searchBox;

    public @FindBy(xpath = "//div[@class='cds-Search-actionButtons']/button")
    WebElement searchButton;



    public void clickSearchBox() {
        searchBox.click();
    }

    public void sendKeysToSearchBox(String query) {
        searchBox.sendKeys(query);
    }

    public void clickSearchButton() {
        searchButton.click();
    }
}
