package component.button.menu;

import org.openqa.selenium.WebDriver;

public class ContactsButton extends MenuButton{

    private static final String CONTACT_BUTTON_LABEL = "Contacts";

    public ContactsButton(WebDriver driver) {
        super(driver, CONTACT_BUTTON_LABEL);
    }
}
