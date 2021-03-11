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

public class SuccessfulLoginSteps {
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
}
