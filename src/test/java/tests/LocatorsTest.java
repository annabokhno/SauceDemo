package tests;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LocatorsTest extends BaseTest {

    @Test
    @Owner("Bokhno A.M.")
    @Epic("Sauce Demo 1")
    @Feature("Locators")
    @Severity(SeverityLevel.NORMAL)
    public void checkCart() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys(user);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.tagName("button"));
        driver.findElement(By.name("add-to-cart-sauce-labs-backpack"));
        driver.findElement(By.linkText("LinkedIn"));
        driver.findElement(By.partialLinkText("Faceb"));
        driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
        driver.findElement(By.xpath("//a[text()='All Items']"));
        driver.findElement(By.id("react-burger-cross-btn"));
        driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs')]")).click();
        driver.findElement(By.xpath("//button[text()='Add to cart']/ancestor::div[1]"));
        driver.findElement(By.xpath("//div[@class='inventory_details_container']//descendant::div"));
        driver.findElement(By.xpath("//div[@class='inventory_details_desc_container']//following::div[1]"));
        driver.findElement(By.xpath("//button[text()='Add to cart']/parent::div"));
        driver.findElement(By.xpath("//button[text()='Add to cart']/preceding::div"));
        driver.findElement(By.xpath("//button[@data-test='back-to-products' and contains(@class,'btn')]")).click();
        driver.findElement(By.cssSelector(".inventory_item_name"));
        driver.findElement(By.cssSelector(".inventory_item_label .inventory_item_name "));
        driver.findElement(By.cssSelector("#item_1_title_link")).click();
        driver.findElement(By.cssSelector("button"));
        driver.findElement(By.cssSelector("button.btn.btn_primary.btn_small.btn_inventory"));
        driver.findElement(By.cssSelector("[data-test='add-to-cart']"));
        driver.findElement(By.cssSelector("[class~='btn_primary']"));
        driver.findElement(By.cssSelector("[data-test|='inventory']"));
        driver.findElement(By.cssSelector("[data-test^='inventory']"));
        driver.findElement(By.cssSelector("[data-test$='price']"));
        driver.findElement(By.cssSelector("[data-test*='item']"));
    }

}
