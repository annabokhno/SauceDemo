package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class CheckoutPage extends BasePage {

    private final By FIRSTNAME_FIELD = By.id("first-name");
    private final By LASTNAME_FIELD = By.id("last-name");
    private final By ZIP_CODE_FIELD = By.id("postal-code");
    private final By CONTINUE_BUTTON = By.id("continue");
    private final By ERROR_CHECKOUT_MESSAGE = By.cssSelector("[data-test='error']");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CheckoutPage isPageOpened() {
        log.info("Checking that Checkout Page is opened");
        wait.until(ExpectedConditions.visibilityOfElementLocated(FIRSTNAME_FIELD));
        return this;
    }

    @Override
    public CheckoutPage open() {
        log.warn("Attempted to open Checkout Page directly");
        throw new UnsupportedOperationException("CheckoutPage cannot be opened directly");
    }

    public CheckoutPage openCheckOut() {
        log.info("Opening Checkout Page");
        driver.get(BASE_URL + "/checkout-step-one.html");
        return this;
    }

    @Step("Заполнение формы Checkout: '{first_name}','{last_name}' и zip код '{zip}'")
    public CheckoutPage fillOutTheForm(String first_name, String last_name, String zip) {
        driver.findElement(FIRSTNAME_FIELD).sendKeys(first_name);
        driver.findElement(LASTNAME_FIELD).sendKeys(last_name);
        driver.findElement(ZIP_CODE_FIELD).sendKeys(zip);
        driver.findElement(CONTINUE_BUTTON).click();
        return this;
    }

    public String getErrorCheckoutMessage() {
        return driver.findElement(ERROR_CHECKOUT_MESSAGE).getText();
    }
}
