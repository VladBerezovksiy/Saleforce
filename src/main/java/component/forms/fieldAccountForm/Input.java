package component.forms.fieldAccountForm;

import component.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class Input extends AbstractComponent {

    private static final String INPUT_LOCATOR_PATTERN =
            "//label[contains(.,'%s')]/ancestor::div[contains(@class,'uiInput')]//input";
    private String label;
    private By inputLocator;

    public Input(WebDriver driver, String label) {
        super(driver);
        this.label = label;
        this.inputLocator = By.xpath(String.format(INPUT_LOCATOR_PATTERN, label));
    }

    @Override
    public boolean isComponentDisplayed() {
        try {
            explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(inputLocator));
        } catch (TimeoutException exception) {
            return false;
        }
        return true;
    }

    public void insert(String text) {
        driver.findElement(inputLocator).sendKeys(text);
    }
}
