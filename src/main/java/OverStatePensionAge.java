import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class OverStatePensionAge extends HowMuchDoYouGetPaidPage {

    public OverStatePensionAge(WebDriver driver) {
        super(driver);
    }
        public void overPension(String trueOrFalse) {
                driver.findElement(By.id("[value]"+trueOrFalse));


  }
    }

