package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test(
            priority = 1,
            description = "Проверка логина с позитивным логином и паролем",
            testName = "Позитивный логин",
            groups = {"smoke", "login"}
    )
    @Owner("Bokhno A.M.")
    @Epic("Sauce Demo 1")
    @Feature("Log in")
    @Story("Log in with positive credential")
    @Description("Проверка логина с позитивным логином и паролем")
    @Severity(SeverityLevel.CRITICAL)
    @Flaky
    @Link(name = "Аналитика", url = "https://www.saucedemo.com/")
    @TmsLink("SD-T01")
    @Issue("BUG-01")
    public void checkLoginWithPositiveCred() {
        loginStep.auth(user, password);
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
    @Owner("Bokhno A.M.")
    @Epic("Sauce Demo 1")
    @Feature("Log in")
    @Story("Log in with empty user_name credential")
    @Severity(SeverityLevel.CRITICAL)
    public void chekLoginWithEmptyUserName() {
        loginStep.authWithNegativeCred("", password);
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username is required");
    }

    @Test(
            priority = 2,
            description = "Проверка логина с пустым паролем",
            testName = "Пустой пароль",
            groups = {"regression", "login"}
    )
    @Owner("Bokhno A.M.")
    @Epic("Sauce Demo 1")
    @Feature("Log in")
    @Story("Log in with empty password credential")
    @Severity(SeverityLevel.CRITICAL)
    public void chekLoginWithEmptyPassword() {
        loginStep.authWithNegativeCred(user, "");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Password is required",
                "SO BAAD");
    }

    @Test(
            priority = 2,
            description = "Проверка логина с негативным логином и паролем",
            testName = "Негативный логин",
            groups = {"smoke", "login"}
    )
    @Owner("Bokhno A.M.")
    @Epic("Sauce Demo 1")
    @Feature("Log in")
    @Story("Log in with negative credential")
    @Severity(SeverityLevel.CRITICAL)
    public void chekLoginWithNegativeCred() {
        loginPage.open()
                .loginWithNegativeCred("test", "test");
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
    @Owner("Bokhno A.M.")
    @Epic("Sauce Demo 1")
    @Feature("Log in")
    @Story("Negative parameterized login")
    @Severity(SeverityLevel.NORMAL)
    public void checkFillOutWitEmptyCred(String first_name, String last_name, String zip, String expectedError) {
        loginStep.auth(user, password);
        productsStep.addToCart("Sauce Labs Backpack");
        productsStep.openCart();
        cartStep.clickCheckout();
        checkoutStep.fillForm(first_name, last_name, zip);
        assertEquals(checkoutPage.getErrorCheckoutMessage(), expectedError);
    }
}