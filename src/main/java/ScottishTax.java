import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ScottishTax extends HowMuchDoYouGetPaidPage {

    public ScottishTax(WebDriver driver) {
        super(driver);
    }

    public void payScottishTax(String trueOrFalse) {
        driver.findElement(By.cssSelector("[value=" + trueOrFalse + "]")).click();

    }
}
