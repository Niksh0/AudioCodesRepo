package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    @FindBy(xpath = "//a[. = 'Bots']")
    private WebElement botsPageLink;

    public void clickNumbersPage() {
        numbersPage.click();
    }

    public void clickTestNumber() {
        waitForElementToAppear(testNumber);
        testNumber.click();
    }

    public void clickOnUnassignNumberButton() {
        waitForElementToAppear(unassignButton);
        unassignButton.click();
    }

    public void clickOnConfirmUnasignNumber() {
        confirmUnassign.click();
    }

    public String getUnassignAlertText() {
        waitForElementToAppear(greenAlert);
        return greenAlert.getText();
    }

}
