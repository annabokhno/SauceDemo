package steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CheckoutPage;

public class CheckoutStep {

    WebDriver driver;
    CheckoutPage checkoutPage;

    public CheckoutStep(WebDriver driver) {
        this.driver = driver;
        checkoutPage = new CheckoutPage(driver);
    }

    public void openCheckout() {
        checkoutPage.openCheckOut();
        checkoutPage.isPageOpened();
    }

    public void fillForm(String firstName, String lastName, String zip) {
        checkoutPage.fillOutTheForm(firstName, lastName, zip);
    }

    public void verifyError(String expectedError) {
        String actualError = checkoutPage.getErrorCheckoutMessage();
        Assert.assertEquals(actualError, expectedError);
    }
}