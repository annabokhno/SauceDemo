package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    private final By FIRSTNAME_FIELD = By.id("first-name");
    private final By LASTNAME_FIELD = By.id("last-name");
    private final By ZIP_CODE_FIELD = By.id("postal-code");
    private final By CONTINUE_BUTTON = By.id("continue");
    private final By ERROR_CHECKOUT_MESSAGE = By.cssSelector("[data-test='error']");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void openCheckOut() {
        driver.get(BASE_URL + "/checkout-step-one.html");
    }

    @Step("Заполнение формы Checkout: '{first_name}','{last_name}' и zip код '{zip}'")
    public void fillOutTheForm(String first_name, String last_name, String zip) {
        driver.findElement(FIRSTNAME_FIELD).sendKeys(first_name);
        driver.findElement(LASTNAME_FIELD).sendKeys(last_name);
        driver.findElement(ZIP_CODE_FIELD).sendKeys(zip);
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public String getErrorCheckoutMessage() {
        return driver.findElement(ERROR_CHECKOUT_MESSAGE).getText();
    }
}
