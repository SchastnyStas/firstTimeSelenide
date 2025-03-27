package elements;

import com.codeborne.selenide.Condition;


import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class Dropdown {
    private static final String ACCOUNT_DROPDOWN_XPATH = "//*[contains(text(), '%s')]/ancestor::*[contains(@slot, 'inputField')]//button";
    private static final String ACCOUNT_DROPDOWN_OPTION_XPATH = "//*[contains(@title, '%s')]";

    String label;

    public Dropdown(String label) {

        this.label = label;
    }

    public void accountSelectOption(String option) {
        $x(String.format(ACCOUNT_DROPDOWN_XPATH, label))
                .should(Condition.visible, Duration.ofSeconds(15))
                .should(Condition.enabled, Duration.ofSeconds(15)).click();
        $x(String.format(ACCOUNT_DROPDOWN_OPTION_XPATH, option))
                .should(Condition.visible, Duration.ofSeconds(15))
                .should(Condition.enabled, Duration.ofSeconds(15)).click();
    }
}