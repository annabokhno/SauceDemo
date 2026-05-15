package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CartTest extends BaseTest {

    @Test(
            priority = 1,
            description = "В корзине сохраняются выбранные товары",
            testName = "Проверка корзины",
            groups = {"smoke", "regression"}
    )
    public void checkCart() {
        SoftAssert softAssert = new SoftAssert();
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.clickCart();
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
    public void checkRemoveItem() {
        SoftAssert softAssert = new SoftAssert();
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.clickCart();
        cartPage.removeFromCart("Sauce Labs Backpack");
        cartPage.removeFromCart("Sauce Labs Bike Light");
        softAssert.assertEquals(driver.findElements(By.xpath("//*[text()='Sauce Labs Backpack']")).size(), 0);
        softAssert.assertEquals(driver.findElements(By.xpath("//*[text()='Sauce Labs Bike Light']")).size(), 0);
        softAssert.assertAll();
    }

    @Test(enabled = false)
    public void checkCartTwo() {
        SoftAssert softAssert = new SoftAssert();
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.clickCart();

        assertTrue(cartPage.isProductInCart("Sauce Labs Backpack"), "Baaaad");
        assertEquals(cartPage.getProductNameFromCart(0), "Sauce Labs Backpack", "Baaaad");
        assertTrue(cartPage.getProductName().contains("Sauce Labs Backpack"), "Baaaad");
    }
}
