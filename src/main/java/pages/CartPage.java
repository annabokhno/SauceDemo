package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

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

    @Step("Открытие страницы корзины")
    public void open() {
        driver.get(BASE_URL + "/cart.html");
    }

    public String getTitleCart() {
        return driver.findElement(TITLE_CART).getText();
    }

    @Step("Удаление товара '{product}' из корзины")
    public void removeFromCart(String product) {
        driver.findElement(By.xpath(String.format(REMOVE_FROM_CART_PATTERN, product))).click();
    }

    @Step("Нажатие кнопки Checkout")
    public void clickCheckout() {
        driver.findElement(CHECKOUT).click();
    }

    @Step("Получение названия товара '{product}'")
    public String getProductName(String product) {
        return driver.findElement(By.xpath(String.format(PRODUCT_PATTERN, product))).getText();
    }

    @Step("Проверка, что товар '{product}' находится в корзине")
    public boolean isProductInCart(String product) {
        return driver.findElement(
                By.xpath(String.format("//*[@class='cart_item']//*[text()='%s']", product))
        ).isDisplayed();
    }

    @Step("Получение названия товара из корзины по индексу {index}")
    public String getProductNameFromCart(int index) {
        return driver.findElements(By.cssSelector(".inventory_item_name"))
                .get(index)
                .getText();
    }

    @Step("Получение списка всех товаров из корзины")
    public ArrayList<String> getProductName() {
        List<WebElement> allProductsElements = driver.findElements(By.cssSelector(".inventory_item_name"));
        ArrayList<String> names = new ArrayList<>();
        for (WebElement product : allProductsElements) {
            names.add(product.getText());
        }
        return names;
    }
}
