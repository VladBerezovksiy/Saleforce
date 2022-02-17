package builders;

import model.ContactModel;

public class ContactBuilder {

    ContactModel contactModel = new ContactModel();

    public static ContactBuilder newValue() {
        return new ContactBuilder();
    }

    public static ContactModel buildDefault() {
        ContactModel contactModel = new ContactModel();
        contactModel.setSalutation("Mr.");
        contactModel.setFirstName("Vlad");
        contactModel.setLastName("Berezovksiy");
        contactModel.setPhone("+380966192686");
        contactModel.setAccountName("USERNAME");
        return contactModel;
    }

    public static ContactBuilder defaultAccount() {
        ContactModel contactModel = new ContactModel();
        contactModel.setFullInitials("Mr. Vlad Berezovksiy");
        contactModel.setPhone("+380966192686");
        contactModel.setAccountName("USERNAME");
        return new ContactBuilder(contactModel);
    }

    public ContactBuilder() {
    }

    public ContactBuilder(ContactModel contactModel) {
        this.contactModel = contactModel;
    }

    public ContactBuilder setSalutation(String salutation) {
        this.contactModel.setSalutation(salutation);
        return this;
    }

    public ContactBuilder setFirstName(String firstName){
        this.contactModel.setFirstName(firstName);
        return this;
    }

    public ContactBuilder setLastName(String lastName){
        this.contactModel.setLastName(lastName);
        return this;
    }

    public ContactBuilder setPhone(String phone) {
        this.contactModel.setPhone(phone);
        return this;
    }

    public ContactBuilder setAccountName(String accountName) {
        this.contactModel.setAccountName(accountName);
        return this;
    }

    public ContactModel build() {
        return contactModel;
    }
}
