package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import managers.PageObjectManager;
import managers.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.BillingPage;
import pageObjects.BotsPage;
import pageObjects.LoginPage;
import selenium.Wait;

public class AddCreditTest {
    WebDriver driver;
    LoginPage loginPage;
    BotsPage botsPage;
    BillingPage billingPage;
    PageObjectManager pageObjectManager;
    WebDriverManager webDriverManager;

    @Given("^The user logs in$")
    public void the_user_logs_in() {
        webDriverManager = new WebDriverManager();
        driver = webDriverManager.getDriver();
        pageObjectManager = new PageObjectManager(driver);
        loginPage = pageObjectManager.getLoginPage();
        loginPage.navigateToLoginPage();
        loginPage.enterCredentials();
        loginPage.clickLogin();
    }

    @When("^The user navigates to the Biling page$")
    public void the_user_navigates_to_the_Biling_page() {
        botsPage = pageObjectManager.getBotsPage();
        Wait.untilPageLoadComplete(driver);
        botsPage.navigateToBillingPage();
    }

    @When("^The user selects to add credit$")
    public void the_user_selects_to_add_credit() {
        billingPage = pageObjectManager.getBillingPage();
        billingPage.clickOnAddCreditButton();
    }

    @When("^The user fills in the card details$")
    public void the_user_fills_in_the_card_details() {
        billingPage.enterCardDetails();
    }

    @When("^The user clicks on the Pay now button$")
    public void the_user_clicks_on_the_Pay_now_button() {
        billingPage.clickOnPayNowButton();
    }

    @Then("^The payment is completed successfully$")
    public void the_payment_is_completed_successfully() {
        String actualText = billingPage.getConfirmationMessageText();
        String expectedText = "The wallet was successfully updated! BlueSnap: 3-D Secure is unavailable for this card";
        Assert.assertEquals(expectedText, actualText);
        webDriverManager.closeDriver();
    }

    @When("^The user fills in the 3Ds card details$")
    public void the_user_fills_in_the_3Ds_card_details() {
        billingPage.enter3dsCardDetails();
    }

    @When("^The user enters the 3D secure password$")
    public void the_user_enters_the_3D_secure_password() {
        billingPage.enterPassword();
    }

    @Then("^The 3D payment is completed successfully$")
    public void the_3D_payment_is_completed_successfully() {
        String actualText = billingPage.getConfirmationMessageText();
        String expectedText = "The wallet was successfully updated! BlueSnap: 3-D Secure authentication was successful";
        Assert.assertEquals(expectedText, actualText);
        webDriverManager.closeDriver();
    }

    @Then("^Validate that all billing rates are correct$")
    public void validate_that_all_billing_rates_are_correct() {
        System.out.println(billingPage.getIncomingRatesPerMinute());
        Assert.assertTrue(billingPage.getIncomingRatesPerMinute().contains("0.01"));
        webDriverManager.closeDriver();
    }
}
