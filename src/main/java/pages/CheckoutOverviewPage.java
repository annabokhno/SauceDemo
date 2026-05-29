package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutOverviewPage extends BasePage {

    private final By TITLE_OVERVIEW = By.xpath("//span[text() = 'Checkout: Overview']");
    private final By SUMMARY_INFO = By.cssSelector("[class='summary_info']");
    private final By FINISH_BUTTON = By.id("finish");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CheckoutOverviewPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE_OVERVIEW));
        return this;
    }

    @Override
    public CheckoutOverviewPage open() {
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
        driver.findElement(FINISH_BUTTON).click();
        return new CompletePage(driver);
    }
}
