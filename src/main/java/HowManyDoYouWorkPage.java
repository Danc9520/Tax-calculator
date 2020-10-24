import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HowManyDoYouWorkPage extends HowMuchDoYouGetPaidPage {


    public HowManyDoYouWorkPage(WebDriver driver) {
        super(driver);
    }

    public void enterHowMuchAWeek(int hoursAWeek) {
        driver.findElement(By.id("how-many-a-week")).sendKeys(String.valueOf(hoursAWeek));

    }
    public void enterHowMuchADay(int hoursADay) {
        driver.findElement(By.id("how-many-a-day")).sendKeys(String.valueOf(hoursADay));

    }


}

