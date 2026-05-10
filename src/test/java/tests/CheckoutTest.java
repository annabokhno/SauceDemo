package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkFillOutWithPositiveCred() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        cartPage.clickCheckout();
        checkoutPage.fillOutTheForm("Hanna", "Liasota", "12345");
        Assert.assertEquals(checkoutOverviewPage.getTitleOverview(), "Checkout: Overview", "SO BAD");
    }

    @Test
    public void checkFillOutWitEmptyCred() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        cartPage.clickCheckout();
        checkoutPage.fillOutTheForm("", "", "");
        Assert.assertEquals(checkoutPage.getErrorCheckoutMessage(), "Error: First Name is required");
    }

    @Test
    public void checkFinishButton() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        cartPage.clickCheckout();
        checkoutPage.fillOutTheForm("Hanna", "Liasota", "12345");
        Assert.assertTrue(checkoutOverviewPage.getSummaryInfo().contains("Payment Information"));
        checkoutOverviewPage.clickFinishButton();
    }
}
