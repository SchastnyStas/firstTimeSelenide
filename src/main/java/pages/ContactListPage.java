package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class ContactListPage extends BasePage {
    public static final String TABLE_CONTACT_XPATH = "//table//tbody";
    public static final String CONTACT_NAME_FIELD_XPATH = TABLE_CONTACT_XPATH + "//a[contains" +
            "(@title, '%s')]";
    public static final String CONTACT_ACCOUNT_NAME_FIELD_XPATH = TABLE_CONTACT_XPATH + "//a" +
            "[contains(@title, '%s')]";
    public static final String PHONE_BY_CONTACT_NAME_XPATH = CONTACT_ACCOUNT_NAME_FIELD_XPATH +
            "/ancestor::tr//span[contains(@class, 'forceOutputPhone')]";
    public static final String CONTACT_OWNER_BY_ACCOUNT_XPATH = CONTACT_ACCOUNT_NAME_FIELD_XPATH +
            "/ancestor::tr//a[contains(@class, 'uiOutputText')]";

    public ContactListPage() {
    }

    public ContactListPage openPage(String url) {
        Selenide.open(url);
        return this;
    }

    public String getExistContactName(String contactName) {
        return $x(String.format(CONTACT_NAME_FIELD_XPATH, contactName)).getText();
    }

    public String getExistContactAccountName(String accountName) {
        return $x(String.format(CONTACT_ACCOUNT_NAME_FIELD_XPATH, accountName)).getText();
    }

    public String getExistPhoneNumberByAccountName(String accountName) {
        return $x(String.format(PHONE_BY_CONTACT_NAME_XPATH, accountName)).getText();
    }

    public ContactPage clickOnAccountName(String accountName) {
        $x(String.format(CONTACT_NAME_FIELD_XPATH, accountName)).shouldBe(Condition.visible).click();
        return new ContactPage();
    }
}
