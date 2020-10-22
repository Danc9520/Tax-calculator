import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HowMuchDoYouGetPaidPage extends BasePage {


    public HowMuchDoYouGetPaidPage(WebDriver driver) {
        super(driver);

    }

    public void enterEarnings(int amount) {
        driver.findElement(By.id("amount")).sendKeys(Integer.toString(amount));
    }

    public void enterPeriod(int howOften) {
        if (howOften == 1) {
            driver.findElement(By.cssSelector("#period")).click();
        } else {

            driver.findElement(By.cssSelector("#period-" + howOften)).click();

        }
        driver.findElement(By.cssSelector("#button-continue")).click();
    }


}