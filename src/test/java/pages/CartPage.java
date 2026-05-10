package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By TITLE_CART = By.xpath("//span[text() = 'Your Cart']");
    private final By CHECKOUT = By.cssSelector("[data-test = checkout]");
    private final String REMOVE_FROM_CART_PATTERN =
            "//*[text()='%s']//ancestor::div[@class='cart_item_label']//button[text()='Remove']";
    private final String PRODUCT_PATTERN =
            "//*[text()='%s']";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "/cart.html");
    }

    public String getTitleCart() {
        return driver.findElement(TITLE_CART).getText();
    }

    public void removeFromCart(String product) {
        driver.findElement(By.xpath(String.format(REMOVE_FROM_CART_PATTERN, product))).click();
    }

    public void clickCheckout() {
        driver.findElement(CHECKOUT).click();
    }

    public String getProductName(String product) {
        return driver.findElement(By.xpath(String.format(PRODUCT_PATTERN, product))).getText();
    }
}
