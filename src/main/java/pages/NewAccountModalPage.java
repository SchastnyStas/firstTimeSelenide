package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Dropdown;
import elements.Input;
import objects.Account;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class NewAccountModalPage extends BasePage {

    public static final SelenideElement SAVE_BUTTON = $x("//*[@name = 'SaveEdit']");

    public static final SelenideElement SAVE_AND_NEW_BUTTON = $(By.id("SaveAndNew"));

    public static final SelenideElement CANCEL_BUTTON = $(By.id("CancelEdit"));


    public NewAccountModalPage() {
    }

    public NewAccountModalPage openPage(String url) {
        open(url);
        return this;
    }

    public void createNewAccount(Account account) {
        new Input("Account Name").writeTextToInput(account.getAccountName());
        new Input("Website").writeTextToInput(account.getWebSite());
        new Dropdown("Type").accountSelectOption(account.getType());
        new Input("Description").writeTextToTextarea(account.getDescription());
        new Input("Phone").writeTextToInput(account.getPhone());
        new Button().clickButton(SAVE_BUTTON);
    }
}
