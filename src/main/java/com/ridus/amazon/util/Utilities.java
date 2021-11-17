package com.ridus.amazon.util;

import com.ridus.amazon.driver.Driver;
import com.ridus.amazon.enums.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities extends Driver {

    public void elementToBeClickable(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Constants.TIME_TO_WAIT.getValue());
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public By updateElementLocator(By element, int elementName) {
        String updateIdentifier = element.toString();
        updateIdentifier = updateIdentifier.substring(updateIdentifier.indexOf("//"));
        updateIdentifier = String.format(updateIdentifier, elementName);
        return By.xpath(updateIdentifier);
    }
}
