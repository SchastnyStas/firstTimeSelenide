package tests;

import com.codeborne.selenide.Configuration;
import constants.IConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class BaseTest implements ITestConstants, IConstants {
    WebDriver driver;
    AccountPage accountPage;
    AccountListPage accountListPage;
    HomePage homePage;
    LoginPage loginPage;
    NewAccountModalPage newAccountModalPage;
    ContactListPage contactListPage;
    NewContactModalPage newContactModalPagePage;
    ContactPage contactPage;

    public void initPage() {
        accountPage = new AccountPage();
        accountListPage = new AccountListPage();
        homePage = new HomePage();
        loginPage = new LoginPage();
        newAccountModalPage = new NewAccountModalPage();
        contactListPage = new ContactListPage();
        newContactModalPagePage = new NewContactModalPage();
        contactPage = new ContactPage();
    }

    @BeforeMethod
    public void initTest() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        options.addArguments("--disable-popup-blocking");
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.setExperimentalOption("prefs", prefs);
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        setWebDriver(driver);

        Configuration.browser = "chrome";
        Configuration.timeout = 15000;
        Configuration.headless = false;
        Configuration.browserSize = "1024x768";
        initPage();
    }

    @AfterMethod
    public void endTest() {
        getWebDriver().quit();
    }
}
