package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage {

    private final By TITLE_OVERVIEW = By.xpath("//span[text() = 'Checkout: Overview']");
    private final By SUMMARY_INFO = By.cssSelector("[class='summary_info']");
    private final By FINISH_BUTTON = By.id("finish");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
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

    public void clickFinishButton() {
        driver.findElement(FINISH_BUTTON).click();
    }
}
