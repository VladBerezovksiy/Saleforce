package saleforce;

import builders.ContactBuilder;
import model.ContactModel;
import org.testng.annotations.Test;
import utils.ContactModelUtils;

public class AddContactTest extends BaseTest {

    ContactModel actualResult = ContactModelUtils.getDefaultContactModel();
    ContactModel expectedResult = ContactBuilder.defaultAccount().build();

    @Test
    public void addNewContactTest() {
        mainSteps
                .openSaleforceLoginPage()
                .loginWithValidCredits()
                .openContactPage()
                .createNewContact(actualResult)
                .validateContactCreated(expectedResult);
    }
}