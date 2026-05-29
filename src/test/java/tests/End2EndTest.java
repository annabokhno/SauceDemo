package tests;

import io.qameta.allure.*;
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
        loginStep.auth("standard_user", "secret_sauce");
        productsStep.addToCart("Sauce Labs Bolt T-Shirt");
        productsStep.openCart();
        cartStep.clickCheckout();
        checkoutStep.fillForm("Hanna", "Liasota", "12345");
        checkoutOverviewPage.clickFinishButton();
        assertEquals(completePage.getTitleCompletePage(), "Checkout: Complete!");
    }
}
