package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class CheckoutOverviewPage extends BasePage {

    private final By TITLE_OVERVIEW = By.xpath("//span[text() = 'Checkout: Overview']");
    private final By SUMMARY_INFO = By.cssSelector("[class='summary_info']");
    private final By FINISH_BUTTON = By.id("finish");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CheckoutOverviewPage isPageOpened() {
        log.info("Checking that Checkout Overview Page is opened");
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE_OVERVIEW));
        return this;
    }

    @Override
    public CheckoutOverviewPage open() {
        log.warn("Attempted to open CheckoutOverviewPage directly – not allowed");
        throw new UnsupportedOperationException("CheckoutOverviewPage cannot be opened directly");
    }

    public void openCheckoutOverview() {
        driver.get(BASE_URL + "/checkout-step-two.html");
    }

    public String getTitleOverview() {
        return driver.findElement(TITLE_OVERVIEW).getText();
    }

    public String getSummaryInfo() {
        return driver.findElement(SUMMARY_INFO).getText();
    }

    @Step("Нажатие на кнопку Finish")
    public CompletePage clickFinishButton() {
        log.info("Clicking Finish button on Checkout Overview Page");
        driver.findElement(FINISH_BUTTON).click();
        return new CompletePage(driver);
    }
}
