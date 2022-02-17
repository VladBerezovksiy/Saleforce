package builders;

import model.AccountModel;

public class AccountBuilder {

    AccountModel accountModel = new AccountModel();

    public static AccountBuilder newValues() {
        return new AccountBuilder();
    }

    public static AccountModel buildDefault() {
        AccountModel accountModel = new AccountModel();
        accountModel.setAccountName("USERNAME");
        accountModel.setPhone("+380966192686");
        accountModel.setWebsite("teachmeskills.by");
        accountModel.setEmployees(10);
        accountModel.setType("Customer");
        accountModel.setIndustry("Banking");
        return accountModel;
    }

    public static AccountBuilder defaultAccount() {
        AccountModel accountModel = new AccountModel();
        accountModel.setAccountName("USERNAME");
        accountModel.setPhone("+380966192686");
        accountModel.setWebsite("teachmeskills.by");
        accountModel.setEmployees(10);
        accountModel.setType("Customer");
        accountModel.setIndustry("Banking");
        return new AccountBuilder(accountModel);
    }

    public AccountBuilder() {
    }

    public AccountBuilder(AccountModel accountModel) {
        this.accountModel = accountModel;
    }

    public AccountBuilder setAccountName(String accountName) {
        this.accountModel.setAccountName(accountName);
        return this;
    }

    public AccountBuilder setPhone(String phone) {
        this.accountModel.setPhone(phone);
        return this;
    }

    public AccountBuilder setWebsite(String website) {
        this.accountModel.setWebsite(website);
        return this;
    }

    public AccountBuilder setEmployees(int employees) {
        this.accountModel.setEmployees(employees);
        return this;
    }

    public AccountBuilder setType(String type) {
        this.accountModel.setType(type);
        return this;
    }

    public AccountBuilder setIndustry(String industry) {
        this.accountModel.setIndustry(industry);
        return this;
    }

    public AccountModel build() {
        return accountModel;
    }
}
