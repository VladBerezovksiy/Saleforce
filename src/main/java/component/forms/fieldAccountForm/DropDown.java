package component.forms.fieldAccountForm;

import component.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DropDown extends AbstractComponent {

    private static final String DROPDOWN_LOCATOR_PATTERN =
            "//span[@id and contains(.,'%s')]/ancestor::div[contains(@class,'uiInput')]//div[@data-aura-class='uiPopupTrigger']";
    private static final String OPTION_LIST_PATTERN =
            "//div[@aria-labelledby='%s']//li[contains(.,'%s')]";
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

    private String getLabelID() {
        return driver.findElement(dropDownLocator).getAttribute("id");
    }

    public void selectOption(String optionName) {
        openOptionsPopup();
        By optionLocator = By.xpath(String.format(OPTION_LIST_PATTERN, getLabelID(), optionName));
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
        driver.findElement(optionLocator).click();
        explicitlyWait.until(ExpectedConditions.textToBePresentInElementLocated(dropDownLocator, optionName));
    }
}
