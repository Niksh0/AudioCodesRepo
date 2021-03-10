package pageObjects;

import managers.FileReaderManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.Wait;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='username']")
    private WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement password;

    @FindBy(css = ".btn-primary")
    private WebElement loginButton;

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

    public void enter_Credentials() {
        enter_Username("giannina.zowie@twodrops.org");
        enter_Password("Aa!123456");
    }

}
