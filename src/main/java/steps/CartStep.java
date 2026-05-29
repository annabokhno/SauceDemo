package steps;

import org.openqa.selenium.WebDriver;
import pages.CartPage;

public class CartStep {

    WebDriver driver;
    CartPage cartPage;

    public CartStep(WebDriver driver) {
        this.driver = driver;
        cartPage = new CartPage(driver);
    }

    public void clickCheckout() {
        cartPage.clickCheckout();
    }
}
