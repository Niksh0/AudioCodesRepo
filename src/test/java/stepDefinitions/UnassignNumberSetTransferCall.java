package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import managers.PageObjectManager;
import managers.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.BotsPage;
import pageObjects.LoginPage;
import pageObjects.NumbersPage;

public class UnassignNumberSetTransferCall {
    WebDriver driver;
    LoginPage loginPage;
    BotsPage botsPage;
    NumbersPage numbersPage;
    PageObjectManager pageObjectManager;
    WebDriverManager webDriverManager;

    @Given("^The user has logged in$")
    public void the_user_has_logged_in() {
        webDriverManager = new WebDriverManager();
        driver = webDriverManager.getDriver();
        pageObjectManager = new PageObjectManager(driver);
        loginPage = pageObjectManager.getLoginPage();
        loginPage.navigateToLoginPage();
        loginPage.enterCredentials();
        loginPage.clickLogin();
    }

    @When("^The user navigates to the Numbers page and selects a number$")
    public void the_user_navigates_to_the_Numbers_page_and_selects_a_number() {
        numbersPage = pageObjectManager.geNumbersPage();
        numbersPage.navigateToNumbersPage();
        numbersPage.clickTestNumber();
    }

    @When("^The user unassigns the number$")
    public void the_user_unassigns_the_number() {
        numbersPage.clickOnUnassignNumberButton();
        numbersPage.clickOnConfirmUnasignNumber();
        String expectedConfirmUnassignAlert = "The number has been unassigned successfully";
        String actualConfirmUnassignAlert = numbersPage.getUnassignAlertText();
        Assert.assertEquals(expectedConfirmUnassignAlert, actualConfirmUnassignAlert);
    }

    @When("^The user assigns it back to the Bot$")
    public void the_user_assigns_it_back_to_the_Bot() {
        numbersPage.clickTestNumber();
        numbersPage.clickAssignButton();
        numbersPage.selectBotToAssign();
    }

    @Then("^The user validates that the number is assigned to the Bot$")
    public void the_user_validates_that_the_number_is_assigned_to_the_Bot() {
        numbersPage.navigateToBotsPage();
        botsPage = pageObjectManager.getBotsPage();
        botsPage.clickOnMsBotTile();
        botsPage.isNumberDisplayed();
        String expectedNumberName = "FRT Test Number";
        String actualNumberName = botsPage.getNumberName();
        Assert.assertEquals(expectedNumberName, actualNumberName);
        webDriverManager.closeDriver();
    }

    @When("^The user specifies a transfer call numbers and updates$")
    public void the_user_specifies_a_transfer_call_numbers_and_updates() throws InterruptedException {
        numbersPage.enterTransferCallNumber();
        numbersPage.clickOnUpdateButton();
        String expectedUpdateAlert = "The update was successful";
        String actualUpdateAlert = numbersPage.getUpdateAlertText();
        Assert.assertEquals(expectedUpdateAlert, actualUpdateAlert);
    }

    @When("^The user turns off the Transfer call feature$")
    public void the_user_turns_off_the_Transfer_call_feature() throws InterruptedException {
        numbersPage.navigateToBotsPage();
        botsPage = pageObjectManager.getBotsPage();
        botsPage.clickOnMsBotTile();
        botsPage.clickOnTransferCallToggle();
        botsPage.clickOnApplyButton();
        //System.out.println("Is the progress bar displayed " + "" + botsPage.isProgressBarDisplayed());
        botsPage.navigateToNumbersPage();
    }

    @Then("^The transfer call field is hidden$")
    public void the_transfer_call_field_is_hidden() {
        numbersPage.clickTestNumber();
        Assert.assertFalse(numbersPage.isTransferCallNumberDisplayed());
    }

    @When("^The user turns on the Transfer call feature$")
    public void the_user_turns_on_the_Transfer_call_feature() throws InterruptedException {
        numbersPage.navigateToBotsPage();
        botsPage.clickOnMsBotTile();
        botsPage.clickOnTransferCallToggle();
        botsPage.clickOnApplyButton();
        botsPage.navigateToNumbersPage();
    }

    @Then("^The user clears the field and the number is updated$")
    public void the_user_clears_the_field_and_the_number_is_updated() throws InterruptedException {
        numbersPage.clickTestNumber();
        numbersPage.clearTransferCallField();
        numbersPage.updateAfterClear();
        String expectedUpdateAlert = "The update was successful";
        String actualUpdateAlert = numbersPage.getUpdateAlertText();
        Assert.assertEquals(expectedUpdateAlert, actualUpdateAlert);
        webDriverManager.closeDriver();
    }
}
