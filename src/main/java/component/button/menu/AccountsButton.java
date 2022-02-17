package component.button.menu;

import org.openqa.selenium.WebDriver;

public class AccountsButton extends MenuButton {

    private static final String ACCOUNT_BUTTON_LABEL = "Accounts";

    public AccountsButton(WebDriver driver) {
        super(driver, ACCOUNT_BUTTON_LABEL);
    }
}
