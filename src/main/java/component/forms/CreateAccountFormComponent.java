package component.forms;

import component.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateAccountFormComponent extends AbstractComponent {

    private static final By HEADER = By.xpath("//h2[contains(.,'New Account')]");
    private static final By SAVE_BUTTON =
            By.xpath("//div[contains(@class,'forceRecordEditActions')]//button[contains(@class,'uiButton')]/span[text()='Save']");

    public CreateAccountFormComponent(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isComponentDisplayed() {
        try {
            explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(HEADER));
        } catch (TimeoutException exception) {
            return false;
        }
        return true;
    }

    public void save() {
        WebElement button = driver.findElement(SAVE_BUTTON);
        System.out.printf("%s button is displayed: %s\n", button.getClass().getSimpleName(), button.isDisplayed());
        System.out.printf("%s button is enabled: %s\n", button.getClass().getSimpleName(), button.isEnabled());
        button.click();
    }
}