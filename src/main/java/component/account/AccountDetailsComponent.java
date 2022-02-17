package component.account;

import component.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountDetailsComponent extends AbstractComponent {

    private static final String ACCOUNT_TEXT_DATA_FIELD =
            "//div[contains(@class,'slds-tabs_card')]//span[text()='%s']/ancestor::div[contains(@class,'test-id__output-root')]//lightning-formatted-%s";
    String label;
    String value;
    By textFieldLocator;

    public AccountDetailsComponent(WebDriver driver, String label, String value) {
        super(driver);
        this.label = label;
        this.value = value;
        this.textFieldLocator = By.xpath(String.format(ACCOUNT_TEXT_DATA_FIELD, label, value));
    }

    @Override
    public boolean isComponentDisplayed() {
        try {
            explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(textFieldLocator));
        } catch (TimeoutException exception) {
            return false;
        }
        return true;
    }

    public String getValue() {
        return driver.findElement(textFieldLocator).getText();
    }
}
