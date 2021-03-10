package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.BotsPage;
import pageObjects.LoginPage;

public class PageObjectManager {
    private WebDriver driver;
    private LoginPage loginPage;
    private BotsPage botsPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
    }

    public BotsPage getBotsPage() {
        return (botsPage == null) ? botsPage = new BotsPage(driver) : botsPage;
    }
}
