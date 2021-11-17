package com.ridus.amazon.tests;

import com.ridus.amazon.driver.Driver;
import com.ridus.amazon.enums.Constants;
import com.ridus.amazon.steps.ItemsFromCart;
import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ItemsFromCartTest {

    String keyword = "hats for men";
    final int quantity = Constants.ITEM_QUANTITY.getValue();

    static Driver driverInstance = new Driver();
    ItemsFromCart itemsFromCart = new ItemsFromCart();

    @BeforeAll
    public static void setUp() {
        driverInstance.createDriverInstance();
    }


    @Test
    @Description("Open cart and assert that the total price and quantity are correct")
    public void checkingTotalPriceAndQuantityFromCartPage() {
        itemsFromCart.selectFirsItem(keyword);
        Double expectedItemPrice = itemsFromCart.getItemPrice();
        itemsFromCart.addItemToCart(quantity);
        itemsFromCart.goToCartPage();

        Assertions.assertEquals(quantity, itemsFromCart.getTotalQuantity());
        Assertions.assertEquals((expectedItemPrice * quantity), itemsFromCart.getTotalItemPrice());
    }

    @Test
    @Description("Reduce the quantity from 2 to 1 in Cart for the item selected")
    public void checkingNewTotalPriceAndQuantityFromCartPage() {
        int newQuantity = Constants.NEW_ITEM_QUANTITY.getValue();
        itemsFromCart.selectFirsItem(keyword);
        Double expectedItemPrice = itemsFromCart.getItemPrice();
        itemsFromCart.addItemToCart(quantity);
        itemsFromCart.goToCartPage();
        itemsFromCart.changeQuantityOfItem(newQuantity);

        Assertions.assertEquals(newQuantity, itemsFromCart.getTotalQuantity());
        Assertions.assertEquals(expectedItemPrice, itemsFromCart.getTotalItemPrice());
    }

    @AfterAll
    public static void cleanDriverInstances() {
        driverInstance.deleteDriverInstance();
    }
}
