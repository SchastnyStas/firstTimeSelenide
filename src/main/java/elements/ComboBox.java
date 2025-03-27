package elements;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class ComboBox {

    private static final String COMBO_BOX = "//input[@class='slds-combobox__input slds-input']";
    private static final String COMBO_BOX_OPTION = "//label[contains(text(),'Account Name')]/ancestor::lightning-grouped-combobox[contains(@class,'slds-form-element')]//*[@title='%s']";


    public ComboBox() {

    }

    public void accountSelectOption(String option) {
        $x(String.format(COMBO_BOX)).shouldBe(Condition.visible, Duration.ofSeconds(15)).click();
        $x(String.format(COMBO_BOX_OPTION, option)).shouldBe(Condition.visible, Duration.ofSeconds(15)).click();
    }
}
