package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends BasePage {

    public static final SelenideElement USERNAME_INPUT = $(By.id("username"));
    public static final SelenideElement PASSWORD_INPUT = $(By.id("password"));
    public static final SelenideElement LOGIN_INPUT = $(By.id("Login"));


    public LoginPage() {
    }

    public LoginPage openPage(String url) {
        open(url);
        return this;
    }

    public AccountListPage login(String username, String password) {
        USERNAME_INPUT.sendKeys(username);
        PASSWORD_INPUT.sendKeys(password);
        LOGIN_INPUT.click();
        return new AccountListPage();
    }
}
