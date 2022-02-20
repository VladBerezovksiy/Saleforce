package saleforce.tests;

import builders.ContactBuilder;
import model.ContactModel;
import org.testng.annotations.Test;
import saleforce.tests.base.BaseTest;
import utils.ModelUtils.ContactModelUtils;

public class AddContactTest extends BaseTest {

    ContactModel actualResult = ContactModelUtils.getDefaultContactModel();
    ContactModel expectedResult = ContactBuilder.defaultAccount().build();

    @Test(description = "Check added new Contact in Salesforce")
    public void addNewContactTest() {
        mainSteps
                .openSaleforceLoginPage()
                .loginWithValidCredits()
                .openContactPage()
                .createNewContact(actualResult)
                .validateContactCreated(expectedResult);
    }
}