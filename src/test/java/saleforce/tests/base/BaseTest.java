package saleforce.tests.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import saleforce.steps.AccountsSteps;
import saleforce.steps.ContactsSteps;
import saleforce.steps.MainSteps;
import utils.CapabilitiesGenerator;
import utils.TestListener;

import java.io.File;
import java.util.HashMap;

@Listeners(TestListener.class)
public class BaseTest {

    protected WebDriver driver;
    protected MainSteps mainSteps;
    protected AccountsSteps accountsSteps;
    protected ContactsSteps contactsSteps;

    @BeforeMethod
    public void setup(ITestContext context) {
        driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        setDriverAttribute(context);
        mainSteps = new MainSteps(driver);
        accountsSteps = new AccountsSteps(driver);
        contactsSteps = new ContactsSteps(driver);
    }

    private void setDriverAttribute(ITestContext context) {
        String variable = "driver";
        System.out.println("Setting driver into context with variable name " + variable);
        context.setAttribute(variable, driver);
    }

    @AfterMethod(alwaysRun = true)
    public void teardown() {
        driver.quit();
    }
}
