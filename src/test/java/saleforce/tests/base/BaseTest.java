package saleforce.tests.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import saleforce.steps.AccountsSteps;
import saleforce.steps.ContactsSteps;
import saleforce.steps.MainSteps;
import utils.CapabilitiesGenerator;
import utils.TestListener;

@Listeners(TestListener.class)
public class BaseTest {

    protected WebDriver driver;
    protected MainSteps mainSteps;
    protected AccountsSteps accountsSteps;
    protected ContactsSteps contactsSteps;

    @BeforeMethod
    public void setup(ITestContext iTestContext) {
        driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        setContextAttribute(iTestContext, "driver", driver);
        mainSteps = new MainSteps(driver);
        accountsSteps = new AccountsSteps(driver);
        contactsSteps = new ContactsSteps(driver);
    }

    private void setContextAttribute(ITestContext iTestContext, String attributeKey, Object attributeValue) {
        iTestContext.setAttribute(attributeKey, attributeValue);
    }

    @AfterMethod(alwaysRun = true)
    public void teardown() {
        driver.quit();
    }
}
