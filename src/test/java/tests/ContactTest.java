package tests;

import objects.Account;
import objects.Contact;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class ContactTest extends BaseTest {

    Random random = new Random();

    @Test
    public void createContactTest() {

        SoftAssert softAssert = new SoftAssert();

        Account account = new Account(
                "account" + random.nextInt(50),
                "website",
                "Investor",
                "nothing",
                "802933131" + random.nextInt(50)
        );
        String accountName = account.getAccountName();
        Contact contact = new Contact(
                "Prof.",
                "V" + random.nextInt(100),
                "D" + random.nextInt(100),
                accountName,
                "8-029-321-58-5" + random.nextInt(100)
        );
        String contactFullName = contact.getFirstName() + " " + contact.getLastName();

        loginPage.openPage(LOGIN_URL).login(username, password);
        newAccountModalPage.openPage(NEW_ACCOUNT_MODAL_URL).createNewAccount(account);
        newContactModalPagePage.openPage(NEW_CONTACT_MODAL_URL).createNewContact(contact);
        contactListPage.openPage(CONTACT_LIST_URL);

        softAssert.assertEquals(contactListPage.getExistContactAccountName(accountName), accountName);
        softAssert.assertEquals(contactListPage.getExistContactName(contactFullName),
                contactFullName);
        softAssert.assertEquals(contactListPage.getExistPhoneNumberByAccountName(accountName),
                contact.getPhoneContact());
        softAssert.assertAll();
    }

    @Test
    public void checkContactCard() {
        SoftAssert softAssert = new SoftAssert();

        Account account = new Account(
                "account" + random.nextInt(100),
                "website",
                "Investor",
                "description",
                "802933131" + random.nextInt(100)
        );

        String accountName = account.getAccountName();
        Contact contact = new Contact(
                "Prof.",
                "V" + random.nextInt(100),
                "D" + random.nextInt(100),
                accountName,
                "8-029-321-58-5" + random.nextInt(100)
        );
        String contactFullName = contact.getFirstName() + " " + contact.getLastName();
        String contactSalutationFullName =
                contact.getSalutation() + " " + contact.getFirstName() + " " + contact.getLastName();


        loginPage.openPage(LOGIN_URL).login(username, password);
        newAccountModalPage.openPage(NEW_ACCOUNT_MODAL_URL).createNewAccount(account);
        accountListPage.openPage(ACCOUNT_LIST_URL);
        accountListPage.clickOnAccountName(accountName);

        newContactModalPagePage.openPage(NEW_CONTACT_MODAL_URL).createNewContact(contact);

        contactListPage.openPage(CONTACT_LIST_URL);
        contactListPage.clickOnAccountName(contactFullName);
        softAssert.assertEquals(contactPage.getContactFullName("Name"), contactSalutationFullName);
        softAssert.assertEquals(contactPage.getContactData("Phone"),
                contact.getPhoneContact());
        softAssert.assertAll();
    }
}
