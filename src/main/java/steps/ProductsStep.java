package steps;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.ProductsPage;

@Log4j2
public class ProductsStep {

    WebDriver driver;
    ProductsPage productsPage;

    public ProductsStep(WebDriver driver) {
        this.driver = driver;
        productsPage = new ProductsPage(driver);
    }

    public void shouldBeOpened() {
        log.info("Checking that Products Page is opened");
        productsPage.isPageOpened();
    }

    public void addToCart(String productName) {
        log.info("Adding product '{}' to cart", productName);
        productsPage.addToCart(productName);
    }

    public void openCart() {
        log.info("Opening Cart from Products Page");
        productsPage.clickCart();
    }
}
