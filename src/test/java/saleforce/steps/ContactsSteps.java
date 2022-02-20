package saleforce.steps;

import component.account.ContactDetailsComponent;
import component.account.ContactDetailsOtherComponent;
import component.forms.CreateContactFormComponent;
import component.forms.fieldContactForm.DropDown;
import component.forms.fieldContactForm.Input;
import component.forms.fieldContactForm.InputList;
import io.qameta.allure.Step;
import model.ContactModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.ContactPage;

public class ContactsSteps extends AbstractStep {

    private ContactPage contactPage;

    public ContactsSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Create new Contact Form")
    public ContactsSteps createNewContact(ContactModel contactModel) {
        contactPage = new ContactPage(driver);
        contactPage.openNewAccountForm();
        CreateContactFormComponent form = new CreateContactFormComponent(driver);
        Assert.assertTrue(
                form.isComponentDisplayed(),
                form.getClass().getSimpleName().concat(" not displayed")
        );
        fillContactForm(contactModel);
        form.save();
        validatePageIsLoaded(contactPage);
        return this;
    }

    private void fillContactForm(ContactModel contactModel) {
        new DropDown(driver, "Salutation").selectOption(contactModel.getSalutation());
        new Input(driver, "First Name").insert(contactModel.getFirstName());
        new Input(driver, "Last Name").insert(contactModel.getLastName());
        new Input(driver, "Phone").insert(contactModel.getPhone());
        new InputList(driver, "Account Name").selectOption(contactModel.getAccountName());
    }

    @Step("Check value is valid")
    public void validateContactCreated(ContactModel expectedModel) {
        contactPage.openDetails();
        ContactModel actualModel = getActualContact();
        Assert.assertEquals(
                actualModel,
                expectedModel,
                String.format("Contact is not valid: %s", actualModel)
        );
    }

    private ContactModel getActualContact() {
        ContactModel contactModel = new ContactModel();
        contactModel.setPhone(new ContactDetailsComponent(driver, "Phone","phone").getValue());
        contactModel.setFullInitials(new ContactDetailsComponent(driver, "Name","name").getValue());
        contactModel.setAccountName(new ContactDetailsOtherComponent(driver, "Account Name").getValue());
        return contactModel;
    }
}
