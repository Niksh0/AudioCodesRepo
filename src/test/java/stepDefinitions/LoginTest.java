package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import managers.PageObjectManager;
import managers.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.BotsPage;
import pageObjects.LoginPage;

public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;
    BotsPage botsPage;
    PageObjectManager pageObjectManager;
    WebDriverManager webDriverManager;

    @Given("User navigates to the login page")
    public void user_navigates_to_the_login_page() {
        webDriverManager = new WebDriverManager();
        driver = webDriverManager.getDriver();
        pageObjectManager = new PageObjectManager(driver);
        loginPage = pageObjectManager.getLoginPage();
        loginPage.navigateTo_LoginPage();
    }

    @When("User enters email and password")
    public void user_enters_email_and_password() {
        loginPage.enter_Credentials();
    }

    @And("User clicks on the login button")
    public void user_clicks_on_the_login_button() {
        loginPage.click_Login();
    }

    @Then("User is successfully logged in")
    public void user_is_successfuly_logged_in() {
        botsPage = pageObjectManager.getBotsPage();
        String expectedText = "Bots";
        String actualText = botsPage.botsPage_Title();
        Assert.assertEquals(expectedText, actualText);
        webDriverManager.closeDriver();
    }

    @When("^User enters invalid credentials$")
    public void user_enters_invalid_credentials() {
        loginPage.enter_InvalidCredentials();
    }

    @When("^User attempts to log in$")
    public void user_attempts_to_log_in() {
        loginPage.click_Login();
    }

    @Then("^User receives an error message$")
    public void user_receives_an_error_message() {
        String expectedAlertText = "Incorrect Credentials. failed";
        String actualAlertText = loginPage.getAlertText();
        Assert.assertEquals(expectedAlertText, actualAlertText);
        webDriverManager.closeDriver();
    }

    @When("^User enters nonexistent email$")
    public void user_enters_nonexistent_email() {
        loginPage.enter_NonexistentUserCredentials();
    }

    @When("^User tries to log in$")
    public void user_tries_to_log_in() {
        loginPage.click_Login();
    }

    @Then("^Error for nonexistent user is displayed$")
    public void error_for_nonexistent_user_is_displayed() {
        String expectedAlertText = "User does not exist.";
        String actualAlertText = loginPage.getAlertText();
        Assert.assertEquals(expectedAlertText, actualAlertText);
        webDriverManager.closeDriver();
    }
}
