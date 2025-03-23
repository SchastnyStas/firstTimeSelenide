package elements;

import static com.codeborne.selenide.Selenide.$x;

public class Dropdown {
    private static final String ACCOUNT_DROPDOWN_XPATH = "//*[contains(text(), '%s')]/ancestor::*[contains(@slot, 'inputField')]//button";
    private static final String ACCOUNT_DROPDOWN_OPTION_XPATH = "//*[contains(@title, '%s')]";

    String label;

    public Dropdown(String label) {

        this.label = label;
    }

    public void accountSelectOption(String option) {
        $x(String.format(ACCOUNT_DROPDOWN_XPATH, label)).click();
        $x(String.format(ACCOUNT_DROPDOWN_OPTION_XPATH, option)).click();
    }
}