import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;


import java.util.concurrent.TimeUnit;

public class Tests {
    public static WebDriver driver;
    private final HowMuchDoYouGetPaidPage howMuchDoYouGetPaidPage = new HowMuchDoYouGetPaidPage(driver);
    private final HowManyDoYouWorkPage howManyDoYouWorkPage = new HowManyDoYouWorkPage(driver);
    private final OverStatePensionAge areYouOverTheAge = new OverStatePensionAge(driver);
    private final BasePage basePage = new BasePage(driver);
    private final TaxCode taxCode = new TaxCode(driver);
    private final ScottishTax scottishTax = new ScottishTax(driver);


    @BeforeClass
    public static void goToHomepage() {
        System.setProperty("webserver.safari.driver", "/usr/bin/safaridriver");
        driver = new SafariDriver();
        driver.get("https://www.tax.service.gov.uk/estimate-paye-take-home-pay/your-pay");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    //if period is hourly howOften=1, daily howOften=2, weekly :3 monthly: 4 annually: 5
    @Test
    public void enterSimpleData() {
        howMuchDoYouGetPaidPage.enterEarnings("1000");
        howMuchDoYouGetPaidPage.enterPeriod(4);
        basePage.nextPage();
        areYouOverTheAge.overPension("true");
        basePage.nextPage();
        basePage.nextPage();
        scottishTax.payScottishTax("false");
        basePage.nextPage();
        basePage.getResults();
        String myCurrentUrl = driver.getCurrentUrl();
        org.junit.Assert.assertEquals("https://www.tax.service.gov.uk/estimate-paye-take-home-pay/your-results?", myCurrentUrl);
    }

    @Test
    public void incorrectDataInput() {
        howMuchDoYouGetPaidPage.enterEarnings("pizza");
        howMuchDoYouGetPaidPage.enterPeriod(4);
        basePage.nextPage();
        org.junit.Assert.assertTrue(basePage.elementIsVisible((driver.findElement(By.id("error-summary-title")))));

    }

    @Test
    public void tooManyHoursAWeek() {
        howMuchDoYouGetPaidPage.enterEarnings("1000");
        howMuchDoYouGetPaidPage.enterPeriod(1);
        basePage.nextPage();
        howManyDoYouWorkPage.enterHowMuchAWeek(5787);
        basePage.nextPage();
        org.junit.Assert.assertTrue(basePage.elementIsVisible((driver.findElement(By.id("how-many-a-week-error")))));

    }
        @Test
        public void tooManyHoursADay() {
            howMuchDoYouGetPaidPage.enterEarnings("1000");
            howMuchDoYouGetPaidPage.enterPeriod(2);
            basePage.nextPage();
            howManyDoYouWorkPage.enterHowMuchADay(5787);
            basePage.nextPage();

            org.junit.Assert.assertTrue(basePage.elementIsVisible((driver.findElement(By.id("how-many-a-day-error")))));

        }

        @Test
        public void taxCodeKnown() {
            howMuchDoYouGetPaidPage.enterEarnings("1000");
            howMuchDoYouGetPaidPage.enterPeriod(4);
            basePage.nextPage();
            areYouOverTheAge.overPension("true");
            basePage.nextPage();
            taxCode.whatIsYourTaxCode("1250l");
            org.junit.Assert.assertTrue(basePage.elementIsVisible((driver.findElement(By.id("button-get-results")))));
        }

        @Test
        public void taxCodeWrong() {
            howMuchDoYouGetPaidPage.enterEarnings("1000");
            howMuchDoYouGetPaidPage.enterPeriod(4);
            basePage.nextPage();
            areYouOverTheAge.overPension("true");
            basePage.nextPage();
            taxCode.whatIsYourTaxCode("Nope");
            basePage.nextPage();
            org.junit.Assert.assertTrue(basePage.elementIsVisible((driver.findElement(By.id("taxCode-error")))));

        }


        @AfterClass
        public static void quitDriver () {
            driver.quit();
        }


    }
