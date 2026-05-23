package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class End2EndTest extends BaseTest {

    @Test(
            priority = 1,
            description = "E2E сценарий",
            testName = "End-to-End",
            groups = {"smoke", "regression"}
    )
    @Owner("Bokhno A.M.")
    @Epic("Sauce Demo 1")
    @Feature("End-2-End")
    @Story("Happy path")
    @Severity(SeverityLevel.CRITICAL)
    public void endToEnd() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Bolt T-Shirt");
        productsPage.clickCart();
        cartPage.clickCheckout();
        checkoutPage.fillOutTheForm("Hanna", "Liasota", "12345");
        checkoutOverviewPage.clickFinishButton();
        assertEquals(completePage.getTitleCompletePage(), "Checkout: Complete!");
    }
}
