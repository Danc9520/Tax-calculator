import junit.framework.Assert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Tests {
    private static WebDriver driver;
    private HowMuchDoYouGetPaidPage howMuchDoYouGetPaidPage = new HowMuchDoYouGetPaidPage(driver);
    private HowManyDoYouWorkPage howManyDoYouWorkPage = new HowManyDoYouWorkPage(driver);
    private OverStatePensionAge areYouOverTheAge = new OverStatePensionAge(driver);


    @BeforeClass
    public static void goToHomepage() {
        System.setProperty("webserver.safari.driver", "/usr/bin/safaridriver");
        driver = new SafariDriver();
        driver.get("https://www.tax.service.gov.uk/estimate-paye-take-home-pay/your-pay");
    }

    //if period is hourly howoften=1, daily howoften=2, weekly :3 monthly: 4 annually: 5
    @Test
    public void enterSimpleData() {
        howMuchDoYouGetPaidPage.enterEarnings(1_000);
        howMuchDoYouGetPaidPage.enterPeriod(2);
        howManyDoYouWorkPage.enterHowMuchAWeek(4);
        areYouOverTheAge.overPension("true");
        //   Assert.assertTrue(elementIsVisible(alertBox));
    }


    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }


}
