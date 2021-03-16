package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.Wait;

import java.util.List;

public class BotsPage {
    WebDriver driver;

    public BotsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "navbar-brand")
    private WebElement pageTitle;

    @FindBy(className = "fa fa-plus")
    private WebElement addBotButton;

    @FindBy(className = "numbers-wizard-bot-framework-logo microsoftbotframework")
    private WebElement microsoftBot;

    @FindBy(className = "btn-primary btn Ripple-parent round")
    private WebElement firstStepNext;

    @FindBy(xpath = "(//input[@name='agentName'])")
    private WebElement botNameInput;

    @FindBy(xpath = "(//input[@name='botSecretKey'])")
    private WebElement secretKeyInput;

    @FindBy(className = "btn-primary btn Ripple-parent round")
    private WebElement secondStepNext;

    @FindBy(xpath = "(//input[@data-test='controlled-select-input'])[1]")
    private WebElement countryDropdown;

    @FindBy(xpath = "(//ul[@data-test='controlled-select-options'])[1]")
    private List<WebElement> countryList;

    @FindBy(xpath = "(//input[@data-test='controlled-select-input'])[3]")
    private WebElement stateDropdown;

    @FindBy(xpath = "(//ul[@data-test='controlled-select-options'])[3]")
    private List<WebElement> stateList;

    @FindBy(xpath = "(//input[@name='cityPattern'])")
    private WebElement cityName;

    @FindBy(className = "btn-outline-primary btn Ripple-parent round btn-sm")
    private WebElement buyNumberButton;

    @FindBy(className = "btn-primary btn Ripple-parent round")
    private WebElement thirdStepNext;

    @FindBy(xpath = "//*[contains(text(),'Save and Close')]")
    private WebElement saveButton;

    @FindBy(xpath = "//*[contains(text(),'MS Test')]")
    private WebElement microsoftBotTile;

    @FindBy(className = "btn-danger btn Ripple-parent round btn-sm")
    private WebElement deleteBotButton;

    @FindBy(xpath = "(//input[@name='botName'])")
    private WebElement botNameField;

    @FindBy(className = "form-check-label")
    private WebElement confirmNumberDeletion;

    @FindBy(xpath = "//*[contains(text(),'OK')]")
    private WebElement confirmBotDeletion;

    @FindBy(className = "d-flex my-3 flex-wrap")
    private List<WebElement> audiocodesBots;

    public String botsPage_Title() {
        return pageTitle.getText();
    }

    public void add_Bot() {
        addBotButton.click();
    }
    public void clickON_MicrosoftBot() {
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
        firstStepNext.click();
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

    public void select_State() {
        stateDropdown.click();
        for (WebElement state : stateList) {
            if (state.getText().equals("US")) {
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
        Wait.untilJqueryIsDone(driver);
    }

    public void click_ThirdStepNext() {
        thirdStepNext.click();
    }

    public void click_SaveButton() {
        saveButton.click();
    }

    public void click_MicrosoftBotTile() {
        microsoftBotTile.click();
    }

    public void click_DeleteBotButton() {
        deleteBotButton.click();
    }

    public String get_BotName() {
        return botNameField.getText();
    }

    public void confirmBotNumberDeletion() {
        confirmNumberDeletion.click();
        confirmBotDeletion.click();
        Wait.untilJqueryIsDone(driver);
    }

}
