package com.ridus.amazon.pageObject;

import com.ridus.amazon.enums.Locator;
import com.ridus.amazon.util.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RelatedProductsPage {

    public WebDriver driver;
    Utilities utilities = new Utilities();

    private final By goToCartButtonLocator = By.xpath(Locator.RELATED_PRODUCTS_ADDTOCART_BUTTON.getValue());

    public RelatedProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnCartButton() {
        utilities.elementToBeClickable(goToCartButtonLocator);
        driver.findElement(goToCartButtonLocator).click();
    }
}
