package saleforce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import saleforce.steps.AccountsSteps;
import saleforce.steps.ContactsSteps;
import saleforce.steps.MainSteps;

public class BaseTest {

    protected WebDriver driver;
    protected MainSteps mainSteps;
    protected AccountsSteps accountsSteps;
    protected ContactsSteps contactsSteps;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--ignore-popup-blocking");
        chromeOptions.addArguments("--ignore-certificate-errors");
        driver = new ChromeDriver(chromeOptions);
        mainSteps = new MainSteps(driver);
        accountsSteps = new AccountsSteps(driver);
        contactsSteps = new ContactsSteps(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void teardown(){
        driver.quit();
    }
}
