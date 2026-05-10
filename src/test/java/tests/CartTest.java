package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CartTest extends BaseTest {

    @Test
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

    //НЕ РАБОТАЕТ!
    @Test
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
}
