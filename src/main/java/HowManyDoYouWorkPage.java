import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HowManyDoYouWorkPage extends HowMuchDoYouGetPaidPage {


    public HowManyDoYouWorkPage(WebDriver driver) {
        super(driver);
    }

    public void enterHowMuchAWeek(int days) {
        driver.findElement(By.id("how-many-a-week")).sendKeys();

    }

    public void enterHowMuchADay(int hours) {
        driver.findElement(By.id("how-many-a-day")).sendKeys();

    }


}

