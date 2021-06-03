package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class BillingPage extends BasePage {
    public BillingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span/span[. = 'Billing']")
    private WebElement billingPage;

    @FindBy(xpath = "//div[@class='col-12 col-lg-4 col-md-6'][1]")
    private WebElement incomingRatePerMinute;

    @FindBy(xpath = "//div[@class='col-12 col-lg-4 col-md-6'][2]")
    private WebElement outgoingRatePerMinute;

    @FindBy(xpath = "//div[@class='col-12 col-lg-4 col-md-6'][3]")
    private WebElement botConnectionRate;

    @FindBy(xpath = "//div[@class='col-12 col-lg-4 col-md-6'][4]")
    private WebElement localRatePerMinute;

    @FindBy(xpath = "//div[@class='col-12 col-lg-4 col-md-6'][5]")
    private WebElement callRecordingRate;

    @FindBy(xpath = "//div[@class='col-12 col-lg-4 col-md-6'][6]")
    private WebElement speechServiceRate;

    @FindBy(xpath = "//button[.='Add credit']")
    private WebElement addCreditButton;

    @FindBy(id = "cardholder-first-name")
    private WebElement cardFirstName;

    @FindBy(id = "cardholder-last-name")
    private WebElement cardLastName;

    @FindBy(css = "#ccn")
    private WebElement cardNumber;

    @FindBy(css = "#exp")
    private WebElement expirationDate;

    @FindBy(css = "#cvv")
    private WebElement cvcNumber;

    @FindBy(xpath = "//button[.='Pay now']")
    private WebElement payNowButton;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//div[@role='alert']")
    private WebElement greenAlert;

    @FindBy(xpath = "//input[@name='UsernamePasswordEntry']")
    private WebElement submitButton;

    public String getIncomingRatesPerMinute() {
        return incomingRatePerMinute.getText();
    }

    public String getOutgoingRatesPerMinute() {
        return outgoingRatePerMinute.getText();
    }

    public String getBotConnectionRate() {
        return botConnectionRate.getText();
    }

    public String getLocalRatesPerMinute() {
        return localRatePerMinute.getText();
    }

    public String getCallRecordingRate() {
        return callRecordingRate.getText();
    }

    public String getSpeechServiceRate() {
        return speechServiceRate.getText();
    }

    public void clickOnAddCreditButton() {
        waitForElementToAppear(addCreditButton);
        addCreditButton.click();
    }

    public void enterCardDetails() {
        cardFirstName.sendKeys("Tester");
        cardLastName.sendKeys("Testersen");
        driver.switchTo().frame("bluesnap-hosted-iframe-ccn");
        cardNumber.sendKeys("4263982640269299");
        driver.switchTo().defaultContent();
        driver.switchTo().frame("bluesnap-hosted-iframe-exp");
        expirationDate.sendKeys("0223");
        driver.switchTo().defaultContent();
        driver.switchTo().frame("bluesnap-hosted-iframe-cvv");
        cvcNumber.sendKeys("837");
        driver.switchTo().defaultContent();
    }

    public void enter3dsCardDetails() {
        cardFirstName.sendKeys("Tester");
        cardLastName.sendKeys("Testersen");
        driver.switchTo().frame("bluesnap-hosted-iframe-ccn");
        cardNumber.sendKeys("4000000000000002");
        driver.switchTo().defaultContent();
        driver.switchTo().frame("bluesnap-hosted-iframe-exp");
        expirationDate.sendKeys("0124");
        driver.switchTo().defaultContent();
        driver.switchTo().frame("bluesnap-hosted-iframe-cvv");
        cvcNumber.sendKeys("123");
        driver.switchTo().defaultContent();
    }

    public void clickOnPayNowButton() {
        payNowButton.click();
    }

    public void enterPassword() {
        driver.switchTo().frame("Cardinal-CCA-IFrame");
        passwordField.sendKeys("1234");
        submitButton.click();
        driver.switchTo().defaultContent();
    }

    public String getConfirmationMessageText() {
        waitForElementToAppear(greenAlert);
        return greenAlert.getText();
    }

}
