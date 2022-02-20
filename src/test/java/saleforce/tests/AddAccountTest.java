package saleforce.tests;

import builders.AccountBuilder;
import model.AccountModel;
import org.testng.annotations.Test;
import saleforce.tests.base.BaseTest;
import utils.ModelUtils.AccountModelUtils;

public class AddAccountTest extends BaseTest {

    AccountModel testAccount = AccountModelUtils.getDefaultAccountModel();
    AccountModel testAccount2 = AccountBuilder
            .defaultAccount()
            .setPhone("+380966192687")
            .build();

    @Test(description = "Check added new Account in Salesforce")
    public void addNewAccountTest() {
        mainSteps
                .openSaleforceLoginPage()
                .loginWithValidCredits()
                .openAccountPage()
                .createNewAccount(testAccount)
                .validateAccountCreated(testAccount);
    }

    /*private AccountModel buildTestAccount() {
        return AccountBuilder.newValues()
                .setAccountName("USERNAME")
                .setPhone("+380966192686")
                .setWebsite("teachmeskills.by")
                .setEmployees(10)
                .setType("Customer")
                .setIndustry("Banking")
                .build();
    }*/

    /*private AccountModel getTestAccount() {
        AccountModel accountModel = new AccountModel();
        accountModel.setAccountName("USERNAME");
        accountModel.setPhone("+380966192686");
        accountModel.setWebsite("teachmeskills.by");
        accountModel.setEmployees(10);
        accountModel.setType("Customer");
        accountModel.setIndustry("Banking");
        return accountModel;
    }*/
}
