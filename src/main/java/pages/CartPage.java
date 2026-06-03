package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

@Log4j2
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

    @Override
    public CartPage isPageOpened() {
        log.info("Checking Cart Page is opened");
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE_CART));
        return this;
    }

    @Step("Открытие страницы корзины")
    @Override
    public CartPage open() {
        log.info("Opening Cart Page");
        driver.get(BASE_URL + "/cart.html");
        return this;
    }

    public String getTitleCart() {
        return driver.findElement(TITLE_CART).getText();
    }

    @Step("Удаление товара '{product}' из корзины")
    public CartPage removeFromCart(String product) {
        log.info("Removing product '{}' from cart", product);
        driver.findElement(By.xpath(String.format(REMOVE_FROM_CART_PATTERN, product))).click();
        return this;
    }

    @Step("Нажатие кнопки Checkout")
    public CheckoutPage clickCheckout() {
        log.info("Clicking Checkout button");
        driver.findElement(CHECKOUT).click();
        return new CheckoutPage(driver);
    }

    @Step("Получение названия товара '{product}'")
    public String getProductName(String product) {
        log.info("Getting product name '{}'", product);
        return driver.findElement(By.xpath(String.format(PRODUCT_PATTERN, product))).getText();
    }

    @Step("Проверка, что товар '{product}' находится в корзине")
    public boolean isProductInCart(String product) {
        log.info("Checking product '{}' is present in cart", product);
        return driver.findElement(
                By.xpath(String.format("//*[@class='cart_item']//*[text()='%s']", product))
        ).isDisplayed();
    }

    @Step("Получение названия товара из корзины по индексу {index}")
    public String getProductNameFromCart(int index) {
        log.info("Getting product from cart by index {}", index);
        return driver.findElements(By.cssSelector(".inventory_item_name"))
                .get(index)
                .getText();
    }

    @Step("Получение списка всех товаров из корзины")
    public ArrayList<String> getProductName() {
        log.info("Getting all product names from cart");
        List<WebElement> allProductsElements = driver.findElements(By.cssSelector(".inventory_item_name"));
        ArrayList<String> names = new ArrayList<>();
        for (WebElement product : allProductsElements) {
            names.add(product.getText());
        }
        return names;
    }
}
