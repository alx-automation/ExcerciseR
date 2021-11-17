package com.ridus.amazon.enums;

public enum Locator {
    HOMEPAGE_SEARCH_FIELD("twotabsearchtextbox"),
    HOMEPAGE_SEARCH_BUTTON("nav-search-submit-button"),
    SEARCH_RESULT_FIRST_ITEM("//div[@data-cel-widget='search_result_1']"),
    PRODUCT_DETAIL_QUANTITY("//div[@id='selectQuantity']//span[@class='a-button-inner']"),
    ITEM_QUANTITY_LOCATOR("//li/a[@id='quantity_1' and text()=%d]"),
    PRODUCT_DETAIL_PRICE("price_inside_buybox"),
    PRODUCT_DETAIL_ADD_BUTTON("add-to-cart-button"),
    RELATED_PRODUCTS_ADDTOCART_BUTTON("//span[@class='a-button-inner']/a[@id='hlb-view-cart-announce']"),
    CART_PAGE_SUBTOTAL("//span[@id='sc-subtotal-amount-activecart']/span"),
    CART_PAGE_QUANTITY("//span[@class='a-button-inner']//span[@class='a-dropdown-prompt']");

    String value;

    Locator(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
