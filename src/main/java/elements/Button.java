package elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Button {


    public Button() {

    }

    public void clickButton(SelenideElement webElement) {
        webElement.click();
    }
}
