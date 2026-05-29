package steps;

import org.openqa.selenium.WebDriver;
import pages.ProductsPage;

public class ProductsStep {

    WebDriver driver;
    ProductsPage productsPage;

    public ProductsStep(WebDriver driver) {
        this.driver = driver;
        productsPage = new ProductsPage(driver);
    }

    public void shouldBeOpened() {
        productsPage.isPageOpened();
    }

    public void addToCart(String productName) {
        productsPage.addToCart(productName);
    }

    public void openCart() {
        productsPage.clickCart();
    }
}
