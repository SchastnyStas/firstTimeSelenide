package elements;

import static com.codeborne.selenide.Selenide.$x;

public class Input {

    private static final String INPUT_XPATH = "//*[contains(text(), '%s')]/ancestor::div[contains(@part, 'input-text')]//input";
    private static final String TEXTAREA_XPATH = "//*[contains(text(), '%s')]/ancestor::*[contains(@slot, 'inputField')]//textarea";

    String label;

    public Input(String label) {

        this.label = label;
    }

    public void writeTextToInput(String text) {
        $x(String.format(INPUT_XPATH, label)).setValue(text);
    }

    public void writeTextToTextarea(String text) {
        $x(String.format(TEXTAREA_XPATH, label)).setValue(text);
    }
}
