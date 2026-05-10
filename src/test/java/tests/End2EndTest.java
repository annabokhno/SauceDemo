package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class End2EndTest extends BaseTest {

    @Test
    public void endToEnd() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Bolt T-Shirt");
        productsPage.clickCart();
        cartPage.clickCheckout();
        checkoutPage.fillOutTheForm("Hanna", "Liasota", "12345");
        checkoutOverviewPage.clickFinishButton();
        Assert.assertEquals(completePage.getTitleCompletePage(), "Checkout: Complete!");
    }
}
