package com.ridus.amazon.steps;

import com.ridus.amazon.driver.Driver;
import com.ridus.amazon.enums.Constants;
import com.ridus.amazon.pageObject.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class ItemsFromCartSteps extends Driver {

    HomePage homePage = new HomePage(driver);
    SearchResultPage searchResultPage = new SearchResultPage(driver);
    ProductDetailPage productDetailPage = new ProductDetailPage(driver);
    RelatedProductsPage relatedProductsPage = new RelatedProductsPage(driver);
    CartPage cartPage = new CartPage(driver);

    double expectedItemPrice = 0;
    int quantity = 0;

    @Given("the user searched for item {string}")
    public void the_user_searched_for_item(String keyword) {
        homePage.searchWithGivenKeyword(keyword);
        searchResultPage.selectFirstItem();
        expectedItemPrice = getItemPrice();
    }

    @When("the user add first item to cart with quantity {int}")
    public void the_user_add_first_item_to_cart_with_quantity(int itemQuantity) {
        productDetailPage.selectGivenQuantity(itemQuantity);
        productDetailPage.clickOnAddToCartButton();
        quantity = itemQuantity;
    }

    @And("go to cart page")
    public void go_to_cart_page() {
        relatedProductsPage.clickOnCartButton();
    }

    @And("change quantity of the item {int}")
    public void changeQuantityOfTheItem(int newQuantity) {
        cartPage.changeNewQuantity(newQuantity);
        quantity = newQuantity;
    }

    @Then("the user should see total price and quantity correctly")
    public void the_user_should_see_total_price_and_quantity_corectly() {
        Assertions.assertEquals(quantity, getTotalQuantity());
        Assertions.assertEquals((expectedItemPrice * quantity), getTotalItemPrice());
    }

    private double getItemPrice() {
        String itemPrice = productDetailPage.getItemPrice();
        return Double.parseDouble(itemPrice.substring(Constants.POSITION_TO_START.getValue()));
    }

    private double getTotalItemPrice() {
        String totalPrice = cartPage.getSubTotalPrice();
        return Double.parseDouble(totalPrice.substring(Constants.POSITION_TO_START.getValue()));
    }

    private int getTotalQuantity() {
        String totalQuantity = cartPage.getTotalQuantity();
        return Integer.parseInt(totalQuantity);
    }
}
