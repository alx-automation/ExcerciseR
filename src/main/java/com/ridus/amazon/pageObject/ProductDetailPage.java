package com.ridus.amazon.pageObject;

import com.ridus.amazon.enums.Locator;
import com.ridus.amazon.util.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage {

    public WebDriver driver;
    Utilities utilities = new Utilities();

    private final By priceLocator = By.id(Locator.PRODUCT_DETAIL_PRICE.getValue());
    private final By selectQuantityLocator = By.xpath(Locator.PRODUCT_DETAIL_QUANTITY.getValue());
    private final By itemQuantityLocator = By.xpath(Locator.ITEM_QUANTITY_LOCATOR.getValue());
    private final By addToCartButtonLocator = By.id(Locator.PRODUCT_DETAIL_ADD_BUTTON.getValue());

    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectGivenQuantity(int itemQuantity) {
        utilities.elementToBeClickable(selectQuantityLocator);
        driver.findElement(selectQuantityLocator).click();

        By newElement = utilities.updateElementLocator(this.itemQuantityLocator, itemQuantity);
        utilities.elementToBeClickable(newElement);
        driver.findElement(newElement).click();
    }

    public String getItemPrice() {
        utilities.elementToBeClickable(priceLocator);
        return driver.findElement(priceLocator).getText();
    }

    public void clickOnAddToCartButton() {
        utilities.elementToBeClickable(addToCartButtonLocator);
        driver.findElement(addToCartButtonLocator).click();
    }
}
