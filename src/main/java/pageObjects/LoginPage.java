package pageObjects;

import managers.FileReaderManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.Wait;

public class LoginPage extends BasePage {
    //WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='username']")
    private WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement password;

    @FindBy(css = ".btn-primary")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@role='alert']")
    private WebElement redAlert;

    public void navigateToLoginPage () {
        driver.get(FileReaderManager.getInstance().getConfigFileReader().getApplicationUrl());
    }

    public void enterUsername(String userEmail) {
        username.clear();
        username.sendKeys(userEmail);
    }

    public void  enterPassword(String userPassword) {
        password.clear();
        password.sendKeys(userPassword);
    }

    public void clickLogin()  {
        loginButton.click();
    }

    public boolean isAlertDisplayed() {
        waitForElementToAppear(redAlert);
        return redAlert.isDisplayed();
    }

    public String getAlertText() {
        waitForElementToAppear(redAlert);
        return redAlert.getText();
    }

    public void enterCredentials() {
        enterUsername("mock-telnyx-frt@mailpoof.com");
        enterPassword("Aa!123456");
    }

    public void enterInvalidCredentials() {
        enterUsername("frttest@mailpoof.com");
        enterPassword("Aa!1234561");
    }

    public void enterNonexistentUserCredentials() {
        enterUsername("frttest1111@mailpoof.com");
        enterPassword("Aa!123456");
    }

    public void enterAdminCredentials() {
        enterUsername("admin@pnc.com");
        enterPassword("q`[RRMSM00%Th5t");
    }

}
