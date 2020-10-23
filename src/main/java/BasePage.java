import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {


    protected WebDriver driver;
    protected WebDriverWait wait;

    BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
    }

    public void nextPage() {
        WebElement element = driver.findElement(By.cssSelector("#button-continue"));
        element.click();
        // workaround bug with safari driver, the following is NOT my code!
        try {
            ((JavascriptExecutor) driver).executeScript("let elem = arguments[arguments.length - 1]; elem.click()", element);
        } catch (StaleElementReferenceException e) { return;
        }
    }

}




