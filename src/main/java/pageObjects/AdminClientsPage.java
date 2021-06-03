package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminClientsPage extends BasePage {
    public AdminClientsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchField;

    @FindBy(className = "d-flex align-self-center")
    private WebElement clientEmail;

    @FindBy(xpath = "//button[.='Action']")
    private WebElement actionButton;

}
