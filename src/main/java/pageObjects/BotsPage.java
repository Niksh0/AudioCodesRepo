package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import selenium.Wait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BotsPage extends BasePage{

    public BotsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "navbar-brand")
    private WebElement pageTitle;

    @FindBy(xpath = "//button/i")
    private WebElement addBotButton;

    @FindBy(xpath = "//div[1]/span[. = 'Microsoft Bot Framework']")
    private WebElement microsoftBot;

    @FindBy(xpath = "//div[1]/span[. = 'Dialogflow ES']")
    private WebElement dialogflowEsBot;

    @FindBy(xpath = "//div[1]/span[. = 'Dialogflow CX']")
    private WebElement dialogflowCxBot;

    @FindBy(xpath = "//div[2]/div[1]/div//span[. = 'AudioCodes Bot API']")
    private WebElement audioCodesBot;

    @FindBy(xpath = "//span[2][. = 'Cognigy']")
    private WebElement cognigyBot;

    @FindBy(xpath = "//span[3][. = 'RASA']")
    private WebElement rasaBot;

    @FindBy(xpath = "//span[. = 'Kore.AI']")
    private WebElement koreAiBot;

    @FindBy(xpath = "//span[. = 'Inbenta']")
    private WebElement inbentaBot;

    @FindBy(xpath = "//span[6][. = 'Haptik']")
    private WebElement haptikBot;

    @FindBy(xpath = "//span[7][. = 'CoCoHub']")
    private WebElement cocohubBpt;

    @FindBy(xpath = "//div[1]/div[2]/div/button[. = 'Next']")
    private WebElement firstStepNext;

    @FindBy(xpath = "(//input[@name='agentName'])")
    private WebElement botNameInput;

    @FindBy(xpath = "(//input[@name='botSecretKey'])")
    private WebElement secretKeyInput;

    @FindBy(xpath = "//div[2]/div[2]/div/button[. = 'Next']")
    private WebElement secondStepNext;

    @FindBy(xpath = "(//input[@data-test='controlled-select-input'])[1]")
    private WebElement countryDropdown;

    @FindBy(xpath = "//li[@data-test='controlled-select-option']")
    private List<WebElement> countryList;

    @FindBy(xpath = "(//input[@data-test='controlled-select-input'])[3]")
    private WebElement stateDropdown;

    @FindBy(xpath = "//li[@data-test='controlled-select-option']")
    private List<WebElement> stateList;

    @FindBy(xpath = "(//input[@name='cityPattern'])")
    private WebElement cityName;

    @FindBy(xpath = "//button[. = 'Add number']")
    private WebElement buyNumberButton;

    @FindBy(className = "numbers-wizard-number-created-wrapper")
    private WebElement numberConfirmation;

    @FindBy(xpath = "//div[3]/button[. = 'Next']")
    private WebElement thirdStepNext;

    @FindBy(xpath = "//*[contains(text(),'Save and Close')]")
    private WebElement saveButton;

    @FindBy(xpath = "//*[contains(text(),'FRT Test')]")
    private WebElement microsoftBotTile;

    @FindBy(xpath = "//button[. = 'Delete bot']")
    private WebElement deleteBotButton;

    @FindBy(xpath = "(//input[@name='botName'])")
    private WebElement botNameField;

    @FindBy(xpath = "//label[. = concat('Delete bot', \"'\", 's phone numbers')]")
    private WebElement confirmNumberDeletion;

    @FindBy(xpath = "//*[contains(text(),'OK')]")
    private WebElement confirmBotDeletion;

    @FindBy(xpath = "//div[@role='alert']")
    private WebElement greenAlert;

    @FindBy(xpath = "//*[contains(text(),'MS Test')]")
    private WebElement msTestBotTile;

    @FindBy(xpath = "//td[. = 'FRT Test Number']")
    private WebElement testNumberInTable;

    @FindBy(xpath = "(//span[@class='lever'])[5]")
    private WebElement transferCallToggle;

    @FindBy(xpath = "//button[. = 'Apply']")
    private WebElement applyButton;

    @FindBy(xpath = "//span/span[. = 'Numbers']")
    private WebElement numbersPage;

    @FindBy(xpath = "(//div[@role='progressbar'])")
    private WebElement progressBar;

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchField;

    @FindBy(xpath = "//span/span[. = 'Billing']")
    private WebElement billingPage;


    public String botsPage_Title() {
        return pageTitle.getText();
    }

    public void add_Bot() {
        addBotButton.click();
    }

    public boolean allBotsDisplayed() {
        waitForElementToAppear(microsoftBot);
        return microsoftBot.isDisplayed() && dialogflowEsBot.isDisplayed() &&  dialogflowCxBot.isDisplayed() && audioCodesBot.isDisplayed() && cognigyBot.isDisplayed() && rasaBot.isDisplayed() && koreAiBot.isDisplayed() && inbentaBot.isDisplayed() && haptikBot.isDisplayed() && cocohubBpt.isDisplayed();
    }

    public void clickON_MicrosoftBot() {
        waitForElementToAppear(microsoftBot);
        microsoftBot.click();
    }

    public void click_FirstStepNext() {
        firstStepNext.click();
    }

    public void enter_BotName(String msBotName) {
        botNameInput.clear();
        botNameInput.sendKeys(msBotName);
    }

    public void enter_SecretKey(String msSecretKey) {
        secretKeyInput.clear();
        secretKeyInput.sendKeys(msSecretKey);
    }

    public void click_SecondStepNext() {
        waitForElementToBeClickable(secondStepNext);
        secondStepNext.click();
    }

    public void select_Country() {
        countryDropdown.click();
        for (WebElement country : countryList) {
            if (country.getText().equals("United States")) {
                country.click();
                break;
            }
        }
    }

    public void select_State() throws InterruptedException {
        Thread.sleep(1500);
        stateDropdown.click();
        for (WebElement state : stateList) {
            if (state.getText().equals("NY")) {
                state.click();
                break;
            }
        }
    }

    public void enter_City() {
        cityName.sendKeys("New York");
    }

    public void click_BuyNumberButton() {
        buyNumberButton.click();
        waitForElementToAppear(numberConfirmation);
    }

    public void click_ThirdStepNext() {
        waitForElementToBeClickable(thirdStepNext);
        thirdStepNext.click();
    }

    public void click_SaveButton() {
        saveButton.click();
    }

    public void search_Bot() {
        waitForElementToAppear(searchField);
        searchField.sendKeys("FRT");
    }

    public void click_MicrosoftBotTile() {
        waitForElementToBeClickable(microsoftBotTile);
        microsoftBotTile.click();
    }

    public void click_DeleteBotButton() {
        waitForElementToBeClickable(deleteBotButton);
        deleteBotButton.click();
    }

    public String get_BotName() {
        return botNameField.getText();
    }

    public void confirmBotNumberDeletion() {
        waitForElementToAppear(confirmBotDeletion);
        confirmNumberDeletion.click();
        confirmBotDeletion.click();
    }
    public boolean isAlertDisplayed() {
        waitForElementToAppear(greenAlert);
        return greenAlert.isDisplayed();
    }

    public String getAlertText() {
        waitForElementToAppear(greenAlert);
        return greenAlert.getText();
    }

    public void clickOnMsBotTile() {
        waitForElementToAppear(msTestBotTile);
        msTestBotTile.click();
    }

    public String getNumberName() {
        waitForElementToAppear(testNumberInTable);
        return testNumberInTable.getText();
    }

    public Boolean isNumberDisplayed() {
        waitForElementToAppear(testNumberInTable);
        return testNumberInTable.isDisplayed();
    }

    public void clickOnTransferCallToggle() throws InterruptedException {
        Thread.sleep(4000);
        //waitForElementToBeClickable(transferCallToggle);
        transferCallToggle.click();
    }

    public void clickOnApplyButton() throws InterruptedException {
        waitForElementToBeClickable(applyButton);
        applyButton.click();
        Thread.sleep(3000);
    }

//    public Boolean isProgressBarDisplayed() throws InterruptedException {
//        Wait.untilJqueryIsDone(driver);
//        //waitForElementToAppear(progressBar);
//        waitForElementToBePresent(By.xpath("(//div[@role='progressbar'])"));
//        return progressBar.isDisplayed();
//    }

    public void navigateToNumbersPage() {
        //waitForElementInvisibility(progressBar);
        try {
            if (!applyButton.isEnabled()) {
                numbersPage.click();
            }
        } catch (Exception e) {
            System.out.println("The request did not finish");
        }
    }

    public void enter_msBotDetails() {
        enter_BotName("FRT Test");
        enter_SecretKey("pJOwNmK-fq0.u-2KkxMoXGxNb_F0qC9z6e4euw5A8jKs4Ar0VX77ljc");
    }

    public void navigateToBillingPage() {
        billingPage.click();
    }

}
