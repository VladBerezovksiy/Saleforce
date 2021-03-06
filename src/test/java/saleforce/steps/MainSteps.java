package saleforce.steps;

import component.button.menu.AccountsButton;
import component.button.menu.ContactsButton;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.AccountPage;
import pages.ContactPage;
import pages.HomePage;
import pages.SaleforceLoginPage;
import utils.PropertiesUtils;

public class MainSteps extends AbstractStep {

    private SaleforceLoginPage loginPage;
    private HomePage homePage;
    private AccountsButton accountsButton;
    private ContactsButton contactsButton;

    private static final String VALID_LOGIN = System.getProperty("login");
    private static final String VALID_PASSWORD = System.getProperty("password");

    public MainSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Open SaleForce page")
    public MainSteps openSaleforceLoginPage() {
        loginPage = new SaleforceLoginPage(driver);
        loginPage.openPage();
        validatePageIsLoaded(loginPage);
        return this;
    }

    @Step("Login in Account")
    public MainSteps loginWithValidCredits() {
        loginPage.authentication(
                PropertiesUtils.getEnv("valid_login"),
                PropertiesUtils.getEnv("valid_password")
        );
        homePage = new HomePage(driver);
        validatePageIsLoaded(homePage);
        return this;
    }

    @Step("Open Account Page")
    public AccountsSteps openAccountPage() {
        accountsButton = new AccountsButton(driver);
        Assert.assertTrue(
                accountsButton.isComponentDisplayed(),
                accountsButton.getClass().getSimpleName().concat(" not displayed")
        );
        accountsButton.click();
        validatePageIsLoaded(new AccountPage(driver));
        return new AccountsSteps(driver);
    }

    @Step("Open Contact page")
    public ContactsSteps openContactPage() {
        contactsButton = new ContactsButton(driver);
        Assert.assertTrue(
                contactsButton.isComponentDisplayed(),
                contactsButton.getClass().getSimpleName().concat(" not displayed")
        );
        contactsButton.click();
        validatePageIsLoaded(new ContactPage(driver));
        return new ContactsSteps(driver);
    }
}
