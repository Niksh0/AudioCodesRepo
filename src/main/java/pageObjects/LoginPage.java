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

    public void navigateTo_LoginPage () {
        driver.get(FileReaderManager.getInstance().getConfigFileReader().getApplicationUrl());
    }

    public void enter_Username(String userEmail) {
        username.clear();
        username.sendKeys(userEmail);
    }

    public void  enter_Password(String userPassword) {
        password.clear();
        password.sendKeys(userPassword);
    }

    public void click_Login() {
        loginButton.click();
        Wait.untilJqueryIsDone(driver);
    }

    public boolean isAlertDisplayed() {
        waitForElementToAppear(redAlert);
        return redAlert.isDisplayed();
    }

    public String getAlertText() {
        waitForElementToAppear(redAlert);
        return redAlert.getText();
    }

    public void enter_Credentials() {
        enter_Username("frttest@mailpoof.com");
        enter_Password("Aa!123456");
    }

    public void enter_InvalidCredentials() {
        enter_Username("frttest@mailpoof.com");
        enter_Password("Aa!1234561");
    }

    public void enter_NonexistentUserCredentials() {
        enter_Username("frttest1111@mailpoof.com");
        enter_Password("Aa!123456");
    }

}
