package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import managers.PageObjectManager;
import managers.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pageObjects.BotsPage;
import pageObjects.LoginPage;
import selenium.Wait;

import java.io.ByteArrayInputStream;

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
        loginPage.navigateToLoginPage();
        loginPage.enterCredentials();
        loginPage.clickLogin();
    }

    @When("^The user click on the plus button$")
    public void the_user_click_on_the_plus_button() {
        botsPage = pageObjectManager.getBotsPage();
        Wait.untilPageLoadComplete(driver);
        botsPage.add_Bot();
    }

    @Then("^Validate that all Bot frameworks are displayed$")
    public void validate_that_all_Bot_frameworks_are_displayed() {
        Assert.assertTrue(botsPage.allBotsDisplayed());
        Allure.addAttachment("Image", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        webDriverManager.closeDriver();
    }

    @When("^The user specifies the Bot framework$")
    public void the_user_specifies_the_Bot_framework() {
        botsPage.clickON_MicrosoftBot();
        botsPage.click_FirstStepNext();
    }

    @When("^The user adds the Bot details$")
    public void the_user_adds_the_Bot_details() {
        botsPage.enter_msBotDetails();
        botsPage.click_SecondStepNext();
    }

    @When("^The user buys a number$")
    public void the_user_buys_a_number() throws InterruptedException {
        botsPage.select_Country();
        botsPage.select_State();
        botsPage.enter_City();
        botsPage.click_BuyNumberButton();
        Allure.addAttachment("Image", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        botsPage.click_ThirdStepNext();
        botsPage.click_SaveButton();
    }

    @Then("^The bot and number are added$")
    public void the_bot_and_number_are_added() {
        //botsPage.search_Bot();
        botsPage.click_MicrosoftBotTile();
        Allure.addAttachment("Image", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    @When("^The user deletes the bot and number$")
    public void the_user_deletes_the_bot_and_number() {
        botsPage.click_DeleteBotButton();
        botsPage.confirmBotNumberDeletion();
    }

    @Then("^The bot and number are successfully deleted$")
    public void the_bot_and_number_are_successfully_deleted() {
        System.out.println(botsPage.isAlertDisplayed());
        System.out.println("The alert text is" + botsPage.getAlertText());
        String expectedAlertText = "The bot has been deleted successfully";
        String actualAlertText = botsPage.getAlertText();
        Assert.assertEquals(expectedAlertText, actualAlertText);
        Allure.addAttachment("Image", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        webDriverManager.closeDriver();
    }
}
