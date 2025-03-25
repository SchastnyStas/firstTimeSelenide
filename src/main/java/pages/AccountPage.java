package pages;

import static com.codeborne.selenide.Selenide.$x;

public class AccountPage extends BasePage {
    public static final String DATA_BY_FIELD_NAME_XPATH = "//span[@class='test-id__field-label' " +
            "and contains(text(), '%s')]/ancestor::records-record-layout-item//span[contains" +
            "(@class, 'test-id__field-value')]";

    public AccountPage() {
    }

    public String getFieldValueByName(String name) {
        return $x(String.format(DATA_BY_FIELD_NAME_XPATH, name)).getText();
    }
}

