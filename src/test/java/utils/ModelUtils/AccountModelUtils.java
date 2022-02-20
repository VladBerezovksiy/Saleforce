package utils.ModelUtils;

import model.AccountModel;

public class AccountModelUtils {

    public static AccountModel getDefaultAccountModel() {
        AccountModel accountModel = new AccountModel();
        accountModel.setAccountName("USERNAME");
        accountModel.setPhone("+380966192686");
        accountModel.setWebsite("teachmeskills.by");
        accountModel.setEmployees(10);
        accountModel.setType("Customer");
        accountModel.setIndustry("Banking");
        return accountModel;
    }
}
