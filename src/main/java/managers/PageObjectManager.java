package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.BillingPage;
import pageObjects.BotsPage;
import pageObjects.LoginPage;
import pageObjects.NumbersPage;

public class PageObjectManager {
    private WebDriver driver;
    private LoginPage loginPage;
    private BotsPage botsPage;
    private NumbersPage numbersPage;
    private BillingPage billingPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
    }

    public BotsPage getBotsPage() {
        return (botsPage == null) ? botsPage = new BotsPage(driver) : botsPage;
    }

    public NumbersPage geNumbersPage() {
        return (numbersPage == null) ? numbersPage = new NumbersPage(driver) : numbersPage;
    }

    public BillingPage getBillingPage() {
        return (billingPage == null) ? billingPage = new BillingPage(driver) : billingPage;
    }
}
