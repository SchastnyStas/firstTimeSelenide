package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.ComboBox;
import elements.Dropdown;
import elements.Input;
import objects.Contact;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class NewContactModalPage extends BasePage {


    public static final SelenideElement SAVE_BUTTON = $x("//*[@name = 'SaveEdit']");

    public static final SelenideElement SAVE_AND_NEW_BUTTON = $(By.id("SaveAndNew"));

    public static final SelenideElement CANCEL_BUTTON = $(By.id("CancelEdit"));




    public NewContactModalPage openPage(String url) {
       open(url);
        return this;
    }

    public void createNewContact(Contact contact) {
        new Dropdown("Salutation").accountSelectOption(contact.getSalutation());
        new Input("First Name").writeTextToInput(contact.getFirstName());
        new Input("Last Name").writeTextToInput(contact.getLastName());
        new ComboBox().accountSelectOption(contact.getAccountName());
        new Input("Phone").writeTextToInput(contact.getPhoneContact());
        new Button().clickButton(SAVE_BUTTON);
    }
}
