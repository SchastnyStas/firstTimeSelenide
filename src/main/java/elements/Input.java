package elements;

import com.codeborne.selenide.Condition;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class Input {

    private static final String INPUT_XPATH = "//*[contains(text(), '%s')]/ancestor::div[contains(@part, 'input-text')]//input";
    private static final String TEXTAREA_XPATH = "//*[contains(text(), '%s')]/ancestor::*[contains(@slot, 'inputField')]//textarea";

    String label;

    public Input(String label) {

        this.label = label;
    }

    public void writeTextToInput(String text) {
        $x(String.format(INPUT_XPATH, label)).should(Condition.exist, Duration.ofSeconds(15))
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldBe(Condition.enabled, Duration.ofSeconds(15))
                .setValue(text);
    }

    public void writeTextToTextarea(String text) {
        $x(String.format(TEXTAREA_XPATH, label)).should(Condition.exist, Duration.ofSeconds(15))
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldBe(Condition.enabled, Duration.ofSeconds(15))
                .setValue(text);
    }
}
