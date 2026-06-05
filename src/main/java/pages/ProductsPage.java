package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class ProductsPage extends BasePage {

    private final By TITLE = By.cssSelector("[data-test='title']");
    private final By CART = By.cssSelector("[data-test = shopping-cart-link]");
    private final String ADD_TO_CART_PATTERN =
            "//*[text()='%s']//ancestor::div[@class='inventory_item']//button[text()='Add to cart']";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ProductsPage open() {
        log.info("Opening Products Page");
        driver.get(BASE_URL + "/inventory.html");
        return this;
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    @Override
    public ProductsPage isPageOpened() {
        log.info("Checking that Products Page is opened");
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE));
        return this;
    }

    @Step("Добавление в корзину товара с именем: '{product}'")
    public ProductsPage addToCart(String product) {
        String dataTest = "add-to-cart-" + product.toLowerCase().replace(" ", "-");
        By button = By.cssSelector("[data-test='" + dataTest + "']");
        wait.until(ExpectedConditions.elementToBeClickable(button)).click();
        log.info("Added product '{}' to cart", product);
        return this;
    }

    @Step("Нажатие на кнопку Корзина")
    public CartPage clickCart() {
        log.info("Clicking Cart button");
        driver.findElement(CART).click();
        return new CartPage(driver);
    }
}
