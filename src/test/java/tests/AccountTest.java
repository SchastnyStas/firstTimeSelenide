package tests;

import objects.Account;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class AccountTest extends BaseTest {

    Random random = new Random();

    @Test
    public void createAccountTest() {
        SoftAssert softAssert = new SoftAssert();

        Account account = new Account(
                "account" + random.nextInt(100),
                "website",
                "Investor",
                "nothing",
                "802933131" + random.nextInt(100)
        );
        String accountName = account.getAccountName();

        loginPage.openPage(LOGIN_URL).login(username, password);
        newAccountModalPage.openPage(NEW_ACCOUNT_MODAL_URL).createNewAccount(account);
        accountListPage.openPage(ACCOUNT_LIST_URL);

        softAssert.assertEquals(accountListPage.getExistAccountName(accountName), accountName);
        softAssert.assertEquals(accountListPage.getExistPhoneNumberByAccountName(accountName),
                account.getPhone());
        softAssert.assertAll();
    }

    @Test
    public void checkAccountCard() {
        SoftAssert softAssert = new SoftAssert();

        Account account = new Account(
                "account" + random.nextInt(100),
                "website",
                "Investor",
                "description",
                "802933131" + random.nextInt(100)
        );

        String accountName = account.getAccountName();

        loginPage.openPage(LOGIN_URL).login(username, password);
        newAccountModalPage.openPage(NEW_ACCOUNT_MODAL_URL).createNewAccount(account);
        accountListPage.openPage(ACCOUNT_LIST_URL);
        accountListPage.clickOnAccountName(accountName);
        softAssert.assertEquals(accountPage.getFieldValueByName("Description"),
                account.getDescription());
        softAssert.assertEquals(accountPage.getFieldValueByName("Phone"),
                account.getPhone());
        softAssert.assertAll();
    }
}
