package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompletePage extends BasePage {

    private final By TITLE_COMPLETE_PAGE = By.xpath("//span[text() = 'Checkout: Complete!']");

    public CompletePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CompletePage isPageOpened() {
        return this;
    }

    @Override
    public CompletePage open() {
        throw new UnsupportedOperationException("CompletePage cannot be opened directly");
    }

    public String getTitleCompletePage() {
        return driver.findElement(TITLE_COMPLETE_PAGE).getText();
    }
}
