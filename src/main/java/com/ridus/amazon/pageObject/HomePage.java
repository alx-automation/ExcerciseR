package com.ridus.amazon.pageObject;

import com.ridus.amazon.enums.Locator;
import com.ridus.amazon.util.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public WebDriver driver;
    Utilities utilities = new Utilities();

    private final By searchFieldLocator = By.id(Locator.HOMEPAGE_SEARCH_FIELD.getValue());
    private final By searchButton = By.id(Locator.HOMEPAGE_SEARCH_BUTTON.getValue());

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchWithGivenKeyword(String keyword) {
        utilities.elementToBeClickable(searchFieldLocator);
        driver.findElement(searchFieldLocator).sendKeys(keyword);
        driver.findElement(searchButton).click();
    }
}
