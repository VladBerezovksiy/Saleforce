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
import utils.TestListener;

import java.io.File;
import java.util.HashMap;

@Listeners(TestListener.class)
public class BaseTest {

    protected WebDriver driver;
    protected MainSteps mainSteps;
    protected AccountsSteps accountsSteps;
    protected ContactsSteps contactsSteps;

    public static final File RESOURCE_PATH_FILE = new File("src/test/resources");
    public static final String ABSOLUTE_RESOURCE_PATH = RESOURCE_PATH_FILE.getAbsolutePath();

    @BeforeMethod
    public void setup(ITestContext context) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--ignore-popup-blocking");
        chromeOptions.addArguments("--ignore-certificate-errors");

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory", ABSOLUTE_RESOURCE_PATH);
        chromeOptions.setExperimentalOption("prefs", chromePrefs);

        driver = new ChromeDriver(chromeOptions);
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
