package tests;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CartTest extends BaseTest {

    @Test(
            priority = 1,
            description = "В корзине сохраняются выбранные товары",
            testName = "Проверка корзины",
            groups = {"smoke", "regression"}
    )
    @Owner("Bokhno A.M.")
    @Epic("Sauce Demo 1")
    @Feature("Cart")
    @Story("Add to cart")
    @Description("В корзине сохраняются выбранные товары")
    @Severity(SeverityLevel.CRITICAL)
    @Flaky
    @Link(name = "Аналитика", url = "https://www.saucedemo.com/")
    @TmsLink("SD-T01")
    @Issue("BUG-01")
    public void checkCart() {
        SoftAssert softAssert = new SoftAssert();
        loginStep.auth("standard_user", "secret_sauce");
        productsStep.shouldBeOpened();
        productsStep.addToCart("Sauce Labs Backpack");
        productsStep.addToCart("Sauce Labs Bike Light");
        productsStep.openCart();
        softAssert.assertEquals(cartPage.getProductName("Sauce Labs Backpack"), "Sauce Labs Backpack");
        softAssert.assertEquals(cartPage.getProductName("Sauce Labs Bike Light"), "Sauce Labs Bike Light");
        softAssert.assertAll();
    }

    @Test(
            priority = 2,
            description = "В корзине удаляются выбранные товары",
            testName = "Проверка удаления товаров в корзине",
            groups = {"regression"}
    )
    @Owner("Bokhno A.M.")
    @Epic("Sauce Demo 1")
    @Feature("Cart")
    @Story("Check remove item")
    @Severity(SeverityLevel.CRITICAL)
    public void checkRemoveItem() {
        SoftAssert softAssert = new SoftAssert();
        loginStep.auth("standard_user", "secret_sauce");
        productsStep.addToCart("Sauce Labs Backpack");
        productsStep.addToCart("Sauce Labs Bike Light");
        productsStep.openCart();
        cartPage.removeFromCart("Sauce Labs Backpack");
        softAssert.assertEquals(driver.findElements(By.xpath("//*[text()='Sauce Labs Backpack']")).size(), 0);
        softAssert.assertEquals(driver.findElements(By.xpath("//*[text()='Sauce Labs Bike Light']")).size(), 0);
        softAssert.assertAll();
    }

    @Test(enabled = false)
    public void checkCartTwo() {
        SoftAssert softAssert = new SoftAssert();
        loginPage.open()
                .login("standard_user", "secret_sauce")
                .addToCart("Sauce Labs Backpack")
                .addToCart("Sauce Labs Bike Light")
                .clickCart();
        softAssert.assertTrue(cartPage.isProductInCart("Sauce Labs Backpack"), "Baaaad");
        softAssert.assertEquals(cartPage.getProductNameFromCart(0), "Sauce Labs Backpack", "Baaaad");
        softAssert.assertTrue(cartPage.getProductName().contains("Sauce Labs Backpack"), "Baaaad");
        softAssert.assertAll();
    }
}
