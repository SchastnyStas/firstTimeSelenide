package pages;

import static com.codeborne.selenide.Selenide.$x;

public class ContactPage extends BasePage {
    public static final String DATA_BY_FIELD_NAME_XPATH = "//*[@class='slds-form']//*[contains" +
            "(text(), '%s')]";

    public static final String LIST_CONTACT_DATA_XPATH =
            DATA_BY_FIELD_NAME_XPATH + "/ancestor::records-record-layout-item//span[contains" +
                    "            (@class, 'test-id__field-value')]";

    public ContactPage() {
    }

    public String getContactFullName(String label) {
        return $x(String.format(LIST_CONTACT_DATA_XPATH, label)).getText();
    }

    public String getContactData(String label) {
        return $x(String.format(LIST_CONTACT_DATA_XPATH, label)).getText();
    }
}
