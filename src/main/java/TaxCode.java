import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TaxCode extends HowMuchDoYouGetPaidPage {


    public TaxCode(WebDriver driver) {
        super(driver);
    }

    public void whatIsYourTaxCode(String taxCode) {
        driver.findElement(By.id("taxCode")).sendKeys(taxCode);


    }
}


