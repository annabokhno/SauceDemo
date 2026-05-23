package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CheckoutTest extends BaseTest {

    @Test(
            priority = 1,
            description = "Заполнение Checkout формы с позитивными данными",
            testName = "Положительная проверка Checkout формы",
            groups = {"smoke", "regression"}
    )
    @Owner("Bokhno A.M.")
    @Epic("Sauce Demo 1")
    @Feature("Checkout")
    @Story("Filling out the form with positive data")
    @Severity(SeverityLevel.CRITICAL)
    public void checkFillOutWithPositiveCred() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        cartPage.clickCheckout();
        checkoutPage.fillOutTheForm("Hanna", "Liasota", "12345");
        assertEquals(checkoutOverviewPage.getTitleOverview(), "Checkout: Overview", "SO BAD");
    }

    @DataProvider(name = "параметризированный тест для проверки формы Checkout с негативными данными")
    public Object[][] CheckoutData() {
        return new Object[][]{
                {"", "", ""},
                {"Hanna", "", ""},
                {"", "Liasota", ""},
                {"", "", "123456"},
        };
    }

    @Test(
            priority = 2,
            dataProvider = "параметризированный тест для проверки формы Checkout с негативными данными",
            description = "Заполнение Checkout формы с пустыми данными",
            testName = "Проверка Checkout формы с пустыми данными",
            groups = {"smoke", "regression"}
    )
    @Owner("Bokhno A.M.")
    @Epic("Sauce Demo 1")
    @Feature("Checkout")
    @Story("Filling out the form with empty data")
    @Severity(SeverityLevel.CRITICAL)
    public void checkFillOutWitEmptyCred(String first_name, String last_name, String zip) {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        cartPage.clickCheckout();
        checkoutPage.fillOutTheForm("", "", "");
        assertEquals(checkoutPage.getErrorCheckoutMessage(), "Error: First Name is required");
    }

    @Test(
            priority = 3,
            description = "Проверка кнопки Finish",
            testName = "Проверка кнопки Finish",
            groups = {"smoke", "regression"}
    )
    @Owner("Bokhno A.M.")
    @Epic("Sauce Demo 1")
    @Feature("Checkout")
    @Story("Testing the Finish button")
    @Severity(SeverityLevel.CRITICAL)
    public void checkFinishButton() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        cartPage.clickCheckout();
        checkoutPage.fillOutTheForm("Hanna", "Liasota", "12345");
        assertTrue(checkoutOverviewPage.getSummaryInfo().contains("Payment Information"));
        checkoutOverviewPage.clickFinishButton();
    }
}
