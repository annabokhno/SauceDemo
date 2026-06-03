package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CompletePage extends BasePage {

    private final By TITLE_COMPLETE_PAGE = By.xpath("//span[text() = 'Checkout: Complete!']");

    public CompletePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CompletePage isPageOpened() {
        log.info("Checking that Complete Page is opened");
        return this;
    }

    @Override
    public CompletePage open() {
        log.warn("Attempted to open Complete Page directly");
        throw new UnsupportedOperationException("CompletePage cannot be opened directly");
    }

    public String getTitleCompletePage() {
        return driver.findElement(TITLE_COMPLETE_PAGE).getText();
    }
}
