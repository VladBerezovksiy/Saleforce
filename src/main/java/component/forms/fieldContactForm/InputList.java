package component.forms.fieldContactForm;

import component.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InputList extends AbstractComponent {

    private static final String INPUT_LIST_LOCATOR_PATTERN =
            "//label[contains(text(),'%s')]/ancestor::slot[@name='inputField']//input";
    private static final String OPTION_LIST_PATTERN =
            "//span[contains(@title,'%s')]/ancestor::li[contains(@class,'slds-listbox')]//span[contains(@class,'body')]";
    private String label;
    private By inputListLocator;

    public InputList(WebDriver driver, String label) {
        super(driver);
        this.label = label;
        this.inputListLocator = By.xpath(String.format(INPUT_LIST_LOCATOR_PATTERN, label));
    }

    @Override
    public boolean isComponentDisplayed() {
        try {
            explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(inputListLocator));
        } catch (TimeoutException exception) {
            return false;
        }
        return true;
    }

    private void openOptionsPopup() {
        driver.findElement(inputListLocator).click();
    }

    public void selectOption(String optionName) {
        openOptionsPopup();
        By optionLocator = By.xpath(String.format(OPTION_LIST_PATTERN, optionName));
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
        driver.findElement(optionLocator).click();
    }
}
