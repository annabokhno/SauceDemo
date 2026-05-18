package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    WebDriverWait wait;
    public final String BASE_URL = "https://www.saucedemo.com/";

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //ЕСЛИ КНОПКА ПЕРЕКРЫТА НО ЕЕ НАДО НАЖАТЬ - ЧЕРЕЗ КОНСОЛЬ ДЕВ ТУЛС
    public void jsClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }


    public void waitForPageLoaded() {
        wait.until(driver ->
                ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete")
        );
    }
}
