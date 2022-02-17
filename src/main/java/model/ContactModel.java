package model;

import java.util.Objects;

public class ContactModel {

    String Salutation;
    String FirstName;
    String LastName;
    String Phone;
    String AccountName;
    String FullInitials;

    public ContactModel() {}

    public String getSalutation() {
        return Salutation;
    }

    public void setSalutation(String salutation) {
        Salutation = salutation;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getAccountName() {
        return AccountName;
    }

    public void setAccountName(String accountName) {
        AccountName = accountName;
    }

    public String getFullInitials() {
        return FullInitials;
    }

    public void setFullInitials(String fullInitials) {
        FullInitials = fullInitials;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactModel that = (ContactModel) o;
        return Objects.equals(Salutation, that.Salutation) && Objects.equals(FirstName, that.FirstName) && Objects.equals(LastName, that.LastName) && Objects.equals(Phone, that.Phone) && Objects.equals(AccountName, that.AccountName) && Objects.equals(FullInitials, that.FullInitials);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Salutation, FirstName, LastName, Phone, AccountName, FullInitials);
    }

    @Override
    public String toString() {
        return "ContactModel{" +
                "Salutation='" + Salutation + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Phone='" + Phone + '\'' +
                ", AccountName='" + AccountName + '\'' +
                ", FullInitials='" + FullInitials + '\'' +
                '}';
    }
}
