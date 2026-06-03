package steps;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.CartPage;

@Log4j2
public class CartStep {

    WebDriver driver;
    CartPage cartPage;

    public CartStep(WebDriver driver) {
        this.driver = driver;
        cartPage = new CartPage(driver);
    }

    public void clickCheckout() {
        log.info("Clicking Checkout button in Cart");
        cartPage.clickCheckout();
    }
}
