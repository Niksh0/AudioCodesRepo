package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import managers.PageObjectManager;
import managers.WebDriverManager;
import org.openqa.selenium.WebDriver;
import pageObjects.BotsPage;
import pageObjects.LoginPage;

public class AddBotWithNumber {
    WebDriver driver;
    LoginPage loginPage;
    BotsPage botsPage;
    PageObjectManager pageObjectManager;
    WebDriverManager webDriverManager;

    @Given("^The user is logged in$")
    public void the_user_is_logged_in() {
        webDriverManager = new WebDriverManager();
        driver = webDriverManager.getDriver();
        pageObjectManager = new PageObjectManager(driver);
        loginPage = pageObjectManager.getLoginPage();
        loginPage.navigateTo_LoginPage();
        loginPage.enter_Credentials();
        loginPage.click_Login();
    }

    @When("^The user click on the plus button$")
    public void the_user_click_on_the_plus_button() {
        botsPage = pageObjectManager.getBotsPage();
        botsPage.add_Bot();
    }

    @When("^The user specifies the Bot framework$")
    public void the_user_specifies_the_Bot_framework() {

    }

    @When("^The user adds the Bot details$")
    public void the_user_adds_the_Bot_details() {

    }

    @When("^The user buys a number$")
    public void the_user_buys_a_number() {

    }

    @Then("^The bot and number are added$")
    public void the_bot_and_number_are_added() {

    }

    @When("^The user deletes the bot and number$")
    public void the_user_deletes_the_bot_and_number() {

    }

    @Then("^The bot and number are successfully deleted$")
    public void the_bot_and_number_are_successfully_deleted() {

    }


}
