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

    @FindBy(className = "d-flex my-3")
    private List<WebElement> googleBots;

    @FindBy(className = "d-flex my-3 flex-wrap")
    private List<WebElement> audiocodesBots;

    public String botsPage_Title() {
        return pageTitle.getText();
    }

    public void add_Bot() {
        addBotButton.click();
    }

    public void google_Bots(String botName) {
        for (WebElement gbot : googleBots) {
            if (gbot.getText().equals(botName)) {
                gbot.click();
                Wait.untilJqueryIsDone(driver);
            }

        }
    }


}
