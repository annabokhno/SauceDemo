package steps;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginStep {

    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;

    public LoginStep(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    public void auth(String user, String password) {
        loginPage.open()
                .isPageOpened()
                .login(user, password);
    }

    public void authWithStandardUser() {
        loginPage.open()
                .isPageOpened()
                .login("standard_user", "secret_sauce");
    }

    public void authWithNegativeCred(String user, String password) {
        loginPage.open()
                .isPageOpened()
                .loginWithNegativeCred(user, password);
    }
}
