package com.ridus.amazon.steps;

import com.ridus.amazon.driver.Driver;
import com.ridus.amazon.enums.Constants;
import com.ridus.amazon.pageObject.*;

public class ItemsFromCart extends Driver {

    HomePage homePage = new HomePage(driver);
    SearchResultPage searchResultPage = new SearchResultPage(driver);
    ProductDetailPage productDetailPage = new ProductDetailPage(driver);
    RelatedProductsPage relatedProductsPage = new RelatedProductsPage(driver);
    CartPage cartPage = new CartPage(driver);

    public void selectFirsItem(String keyword) {
        homePage.searchWithGivenKeyword(keyword);
        searchResultPage.selectFirstItem();
    }

    public Double getItemPrice() {
        String itemPrice = productDetailPage.getItemPrice();
        return Double.parseDouble(itemPrice.substring(Constants.POSITION_TO_START.getValue()));
    }

    public void addItemToCart(int itemQuantity) {
        productDetailPage.selectGivenQuantity(itemQuantity);
        productDetailPage.clickOnAddToCartButton();
    }

    public void goToCartPage() {
        relatedProductsPage.clickOnCartButton();
    }

    public Double getTotalItemPrice() {
        String totalPrice = cartPage.getSubTotalPrice();
        return Double.parseDouble(totalPrice.substring(Constants.POSITION_TO_START.getValue()));
    }

    public int getTotalQuantity() {
        String totalQuantity = cartPage.getTotalQuantity();
        return Integer.parseInt(totalQuantity);
    }

    public void changeQuantityOfItem(int newQuantity) {
        cartPage.changeNewQuantity(newQuantity);
    }
}
