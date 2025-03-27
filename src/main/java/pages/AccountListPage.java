package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class AccountListPage extends BasePage {
    public static final String TABLE_XPATH = "//table";
    public static final String ACCOUNT_NAME_FIELD_XPATH = TABLE_XPATH + "//a[contains" +
            "(@title, '%s')]";
    public static final String PHONE_BY_ACCOUNT_NAME_XPATH = ACCOUNT_NAME_FIELD_XPATH +
            "/ancestor::tr//span[contains(@class, 'forceOutputPhone')]";

    public AccountListPage() {
        super();
    }

    public AccountListPage openPage(String url) {
        open(url);
        return this;
    }

    public String getExistAccountName(String accountName) {
        return $x(String.format(ACCOUNT_NAME_FIELD_XPATH, accountName)).getText();
    }

    public String getExistPhoneNumberByAccountName(String accountName) {
        return $x(String.format(PHONE_BY_ACCOUNT_NAME_XPATH, accountName)).getText();
    }

    public AccountPage clickOnAccountName(String accountName) {
        $x(String.format(ACCOUNT_NAME_FIELD_XPATH, accountName)).shouldBe(Condition.clickable).click();
        return new AccountPage();
    }
}
