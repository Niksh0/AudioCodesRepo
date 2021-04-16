package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class NumbersPage extends BasePage {
    public NumbersPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span/span[. = 'Numbers']")
    private WebElement numbersPage;

    @FindBy(xpath = "//div[2][. = 'FRT Test Number']")
    private WebElement testNumber;

    @FindBy(xpath = "//button[. = 'Unassign number from bot']")
    private WebElement unassignButton;

    @FindBy(xpath = "//button[. = 'Yes']")
    private WebElement confirmUnassign;

    @FindBy(xpath = "//div[@role='alert']")
    private WebElement greenAlert;

    @FindBy(xpath = "//button[. = 'Assign number to bot']")
    private WebElement assignButton;

    @FindBy(xpath = "//div/div/div/div/div[1]/div/input")
    private WebElement selectBotDropdown;

    @FindBy(xpath = "//span[. = 'MS Test']")
    private WebElement botName;

    @FindBy(xpath = "//button[. = 'OK']")
    private WebElement confirmBotSelection;

    @FindBy(xpath = "(//input[@name='botTransferCall'])")
    private WebElement transferCallField;

    @FindBy(xpath = "//button[. = 'Update']")
    private WebElement updateButton;

    @FindBy(xpath = "//a[. = 'Bots']")
    private WebElement botsPageLink;

    @FindBy(xpath = "//div[contains(text(),'Please note that call transfer will add cost to th')]")
    private WebElement infoField;

    @FindBy(xpath = "(//div[@class='col portal-section-container right'])")
    private WebElement numberSettings;

    @FindBy(xpath = "(//div[@class='md-form form-group md-outline'])[1]")
    private WebElement numberName;

    public void navigateToNumbersPage() {
        numbersPage.click();
    }

    public void clickTestNumber() {
        waitForElementToAppear(testNumber);
        testNumber.click();
    }

    public void clickOnUnassignNumberButton() {
        waitForElementToBeClickable(unassignButton);
        unassignButton.click();
    }

    public void clickOnConfirmUnasignNumber() {
        confirmUnassign.click();
    }

    public String getUnassignAlertText() {
        waitForElementToAppear(greenAlert);
        return greenAlert.getText();
    }

    public void clickAssignButton() {
        waitForElementToAppear(assignButton);
        assignButton.click();
    }

    public void selectBotToAssign() {
        waitForElementToAppear(selectBotDropdown);
        selectBotDropdown.click();
        botName.click();
        waitForElementToAppear(confirmBotSelection);
        confirmBotSelection.click();
    }

    public void enterTransferCallNumber() {
        transferCallField.sendKeys("+12124338402");
    }

    public void clickOnUpdateButton() throws InterruptedException {
        Thread.sleep(2000);
        infoField.click();
        waitForElementToBeClickable(updateButton);
        updateButton.click();
    }

    public String getUpdateAlertText() {
        waitForElementToAppear(greenAlert);
        return greenAlert.getText();
    }

    public Boolean isTransferCallNumberDisplayed() {
        return isElementDisplayed(transferCallField);
    }

    public void clearTransferCallField() throws InterruptedException {
        transferCallField.click();
        transferCallField.clear();
        Thread.sleep(3000);
    }

    public void updateAfterClear()  {
        transferCallField.click();
        numberName.click();
        waitForElementToBeClickable(updateButton);
        updateButton.click();
    }

    public void navigateToBotsPage() {
        botsPageLink.click();
    }

}
