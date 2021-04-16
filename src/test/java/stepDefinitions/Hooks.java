package stepDefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import managers.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class Hooks {
    WebDriver driver;
    WebDriverManager webDriverManager;

    @Before
    public void BeforeSteps() {
    }

    @After
    public void AfterSteps(Scenario scenario) throws InterruptedException, IOException, IllegalMonitorStateException {
        if (scenario.isFailed()) {
            System.out.println(scenario.getName());
            Allure.addAttachment("Image", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        }
    }


//    @After
//    public void AfterSteps(Scenario scenario) {
//        //webDriverManager = new WebDriverManager();
//        if (scenario.isFailed()) {
//
//           //saveFailureScreenShot(webDriverManager.getDriver());
//        }
//    }

//    @Attachment
//    public byte[] saveFailureScreenShot(WebDriver driver) {
//        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
//    }
}
