package steps;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CheckoutPage;

@Log4j2
public class CheckoutStep {

    WebDriver driver;
    CheckoutPage checkoutPage;

    public CheckoutStep(WebDriver driver) {
        this.driver = driver;
        checkoutPage = new CheckoutPage(driver);
    }

    public void openCheckout() {
        log.info("Opening Checkout Page");
        checkoutPage.openCheckOut();
        checkoutPage.isPageOpened();
    }

    public void fillForm(String firstName, String lastName, String zip) {
        log.info("Filling Checkout form with firstName='{}', lastName='{}', zip='{}'", firstName, lastName, zip);
        checkoutPage.fillOutTheForm(firstName, lastName, zip);
    }

    public void verifyError(String expectedError) {
        String actualError = checkoutPage.getErrorCheckoutMessage();
        log.info("Verifying checkout error. Expected: '{}', Actual: '{}'", expectedError, actualError);
        Assert.assertEquals(actualError, expectedError);
        if (!expectedError.equals(actualError)) {
            log.warn("Checkout error mismatch!");
        }
    }
}