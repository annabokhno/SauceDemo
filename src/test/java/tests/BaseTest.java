package tests;

import io.qameta.allure.testng.AllureTestNg;
import listeners.TestListener;
import org.jspecify.annotations.NonNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;
import steps.CartStep;
import steps.CheckoutStep;
import steps.LoginStep;
import steps.ProductsStep;

import java.time.Duration;
import java.util.HashMap;

@Listeners({AllureTestNg.class, TestListener.class})
public class BaseTest {

    protected WebDriver driver;

    CartPage cartPage;
    CheckoutPage checkoutPage;
    CheckoutOverviewPage checkoutOverviewPage;
    CompletePage completePage;
    LoginPage loginPage;
    ProductsPage productsPage;
    LoginStep loginStep;
    ProductsStep productsStep;
    CheckoutStep checkoutStep;
    CartStep cartStep;


    @BeforeMethod(alwaysRun = true, description = "Настройка драйвера")
    @Parameters({"browser"})
    public void setup(@Optional("chrome") String browser, ITestContext iTestContext) {

        if (browser.equalsIgnoreCase("chrome")) {

            ChromeOptions options = getChromeOptions();

            driver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
            driver = new FirefoxDriver();
        }

        iTestContext.setAttribute("driver", driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        completePage = new CompletePage(driver);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        loginStep = new LoginStep(driver);
        productsStep = new ProductsStep(driver);
        checkoutStep = new CheckoutStep(driver);
        cartStep = new CartStep(driver);
    }

    private static @NonNull ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();

        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);

        options.setExperimentalOption("prefs", chromePrefs);

        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");
        options.addArguments("--headless");
        return options;
    }

    @AfterMethod(alwaysRun = true, description = "Закрытие браузера")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}