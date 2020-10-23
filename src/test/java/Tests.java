import junit.framework.Assert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Tests {
    public static WebDriver driver;
    private HowMuchDoYouGetPaidPage howMuchDoYouGetPaidPage = new HowMuchDoYouGetPaidPage(driver);
    private HowManyDoYouWorkPage howManyDoYouWorkPage = new HowManyDoYouWorkPage(driver);
    private OverStatePensionAge areYouOverTheAge = new OverStatePensionAge(driver);
    private BasePage homePage = new BasePage(driver);


    @BeforeClass
    public static void goToHomepage() {
        System.setProperty("webserver.safari.driver", "/usr/bin/safaridriver");
        driver = new SafariDriver();
        driver.get("https://www.tax.service.gov.uk/estimate-paye-take-home-pay/your-pay");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}

    //if period is hourly howoften=1, daily howoften=2, weekly :3 monthly: 4 annually: 5
    @Test
    public void enterSimpleData(){
        howMuchDoYouGetPaidPage.enterEarnings(1_000);
        howMuchDoYouGetPaidPage.enterPeriod(4);

        homePage.nextPage();
       // howManyDoYouWorkPage.enterHowMuchAWeek(4);
        areYouOverTheAge.overPension("true");
      homePage.nextPage();

     String myCurrentUrl= driver.getCurrentUrl();
     Assert.assertEquals("https://www.tax.service.gov.uk/estimate-paye-take-home-pay/tax-code", myCurrentUrl);
    }


    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }


}
