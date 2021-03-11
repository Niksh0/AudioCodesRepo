package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BotsPage {
    WebDriver driver;

    public BotsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "navbar-brand")
    private WebElement pageTitle;

    public String botsPage_Title() {
        return pageTitle.getText();
    }
}
