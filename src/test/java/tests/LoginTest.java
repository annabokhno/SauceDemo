package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test(
            priority = 1,
            description = "Проверка логина с позитивным логином и паролем",
            testName = "Позитивный логин",
            groups = {"smoke", "login"}
    )
    public void checkLoginWithPositiveCred() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.isPageOpened();
        assertEquals(productsPage.getTitle(),
                "Products",
                "SO BAD");
    }

    @Test(
            priority = 2,
            description = "Проверка логина с пустым логином",
            testName = "Пустой логин",
            groups = {"regression", "login"}
    )
    public void chekLoginWithEmptyUserName() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username is required");
    }

    @Test(
            priority = 2,
            description = "Проверка логина с пустым паролем",
            testName = "Пустой пароль",
            groups = {"regression", "login"}
    )
    public void chekLoginWithEmptyPassword() {
        loginPage.open();
        loginPage.login("standard_user", "");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Password is required",
                "SO BAD");
    }

    @Test(
            priority = 2,
            description = "Проверка логина с негативным логином и паролем",
            testName = "Негативный логин",
            groups = {"smoke", "login"}
    )
    public void chekLoginWithNegativeCred() {
        loginPage.open();
        loginPage.login("test", "test");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "SO BAAD");
    }

    @DataProvider(name = "checkoutNegativeData")
    public Object[][] CheckoutData() {
        return new Object[][]{
                {"", "", "", "Error: First Name is required"},
                {"Hanna", "", "", "Error: Last Name is required"},
                {"", "Liasota", "", "Error: First Name is required"},
                {"", "", "123456", "Error: First Name is required"},
        };
    }

    @Test(
            dataProvider = "checkoutNegativeData",
            priority = 3,
            description = "Проверка логина с параметризированными негативными кредами",
            testName = "Негативный параметризированный логин",
            groups = {"smoke", "login"}
    )
    public void checkFillOutWitEmptyCred(String first_name, String last_name, String zip, String expectedError) {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        cartPage.clickCheckout();
        checkoutPage.fillOutTheForm(first_name, last_name, zip);
        assertEquals(checkoutPage.getErrorCheckoutMessage(), expectedError);
    }
}