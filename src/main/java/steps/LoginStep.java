package steps;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProductsPage;

@Log4j2
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
        log.info("Authenticating with username '{}'", user);
        loginPage.open()
                .isPageOpened()
                .login(user, password);
    }

    public void authWithNegativeCred(String user, String password) {
        log.info("Attempting login with negative credentials for user '{}'", user);
        loginPage.open()
                .isPageOpened()
                .loginWithNegativeCred(user, password);
    }
}
