package com.ridus.amazon.pageObject;

import com.ridus.amazon.enums.Locator;
import com.ridus.amazon.util.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {

    public WebDriver driver;
    Utilities utilities = new Utilities();

    private final By firstItemLocator = By.xpath(Locator.SEARCH_RESULT_FIRST_ITEM.getValue());

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectFirstItem() {
        utilities.elementToBeClickable(firstItemLocator);
        driver.findElement(firstItemLocator).click();
    }
}
