package com.ridus.amazon.pageObject;

import com.ridus.amazon.enums.Locator;
import com.ridus.amazon.util.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    public WebDriver driver;
    Utilities utilities = new Utilities();

    private final By subTotalLocator = By.xpath(Locator.CART_PAGE_SUBTOTAL.getValue());
    private final By quantityLocator = By.xpath(Locator.CART_PAGE_QUANTITY.getValue());
    private final By itemQuantityLocator = By.xpath(Locator.ITEM_QUANTITY_LOCATOR.getValue());

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getSubTotalPrice() {
        utilities.elementToBeClickable(subTotalLocator);
        return driver.findElement(subTotalLocator).getText();
    }

    public String getTotalQuantity() {
        utilities.elementToBeClickable(quantityLocator);
        return driver.findElement(quantityLocator).getText();
    }

    public void changeNewQuantity(int newQuantity) {
        utilities.elementToBeClickable(quantityLocator);
        driver.findElement(quantityLocator).click();

        By newQuantityLocator = utilities.updateElementLocator(itemQuantityLocator, newQuantity);

        utilities.elementToBeClickable(newQuantityLocator);
        driver.findElement(newQuantityLocator).click();
    }
}
