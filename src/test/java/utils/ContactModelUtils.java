package utils;

import model.ContactModel;

public class ContactModelUtils {

    public static ContactModel getDefaultContactModel() {
        ContactModel contactModel = new ContactModel();
        contactModel.setSalutation("Mr.");
        contactModel.setFirstName("Vlad");
        contactModel.setLastName("Berezovksiy");
        contactModel.setPhone("+380966192686");
        contactModel.setAccountName("USERNAME");
        return contactModel;
    }
}
