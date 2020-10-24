import org.openqa.selenium.*;


public class OverStatePensionAge extends HowMuchDoYouGetPaidPage {

    public OverStatePensionAge(WebDriver driver) {
        super(driver);
    }

    public void overPension(String trueOrFalse) {
        driver.findElement(By.cssSelector("[value=" + trueOrFalse + "]")).click();

    }
}
