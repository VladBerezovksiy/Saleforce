package component.account;

import component.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactDetailsComponent extends AbstractComponent {

    private static final String CONTACT_TEXT_DATA_FIELD =
            "//records-record-layout-item//span[text()='%s']/ancestor::div[contains(@class,'label-stacked')]//lightning-formatted-%s\n";
    String label;
    String value;
    By textFieldLocator;

    public ContactDetailsComponent(WebDriver driver, String label, String value) {
        super(driver);
        this.label = label;
        this.value = value;
        this.textFieldLocator = By.xpath(String.format(CONTACT_TEXT_DATA_FIELD, label, value));
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
