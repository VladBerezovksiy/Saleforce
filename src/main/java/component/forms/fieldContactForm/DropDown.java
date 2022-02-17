package component.forms.fieldContactForm;

import component.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DropDown extends AbstractComponent {

    private static final String DROPDOWN_LOCATOR_PATTERN = "//label[contains(text(),'%s')]/ancestor::lightning-picklist//button";
    private static final String OPTION_LIST_PATTERN =
            "//lightning-base-combobox-item[contains(@data-value,'%s')]";
    private String label;
    private By dropDownLocator;

    public DropDown(WebDriver driver, String label) {
        super(driver);
        this.label = label;
        this.dropDownLocator = By.xpath(String.format(DROPDOWN_LOCATOR_PATTERN, label));
    }

    @Override
    public boolean isComponentDisplayed() {
        return driver.findElement(dropDownLocator).isDisplayed();
    }

    private void openOptionsPopup() {
        driver.findElement(dropDownLocator).click();
    }

    public void selectOption(String optionName) {
        openOptionsPopup();
        By optionLocator = By.xpath(String.format(OPTION_LIST_PATTERN, optionName));
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
        driver.findElement(optionLocator).click();
        explicitlyWait.until(ExpectedConditions.textToBePresentInElementLocated(dropDownLocator, optionName));
    }
}
