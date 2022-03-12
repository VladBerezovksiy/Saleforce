package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SaleforceLoginPage extends BasePage {

    private static final String BASE_URL = "https://login.salesforce.com/";

    private static final By USERNAME_FIELD = By.id("username");
    private static final By PASSWORD_FIELD = By.id("password");
    private static final By LOGIN_BUTTON = By.id("Login");

    Logger log = LogManager.getLogger(ContactPage.class);

    public SaleforceLoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
    }

    public void authentication(String username, String password) {
        log.info("Insert [{}] into [{}] field", username,"username");
        driver.findElement(USERNAME_FIELD).sendKeys(username);
        log.info("Insert [{}] into [{}] field", password,"password");
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        log.info("Click [{}] button", "Login");
        driver.findElement(LOGIN_BUTTON).click();
    }

    @Override
    public BasePage openPage() {
        driver.get(BASE_URL);
        return this;
    }
}
