package Test;

import com.codeborne.selenide.WebDriverRunner;
import exeptions.BrowserNotSupported;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.MainPageSteps;
import pages.UserPageSteps;
import utils.FailureWatcher;

//@ExtendWith(FailureWatcher.class)
public class BaseTest {
    public MainPageSteps mainPageSteps = new MainPageSteps();
    public UserPageSteps userPageSteps = new UserPageSteps();
    public final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @Step("Открыть страницу users в браузере chrome")
    @BeforeMethod
    public void openBrowserChrome() throws BrowserNotSupported {
        mainPageSteps.openBrowserChrome("chrome");
        mainPageSteps.openPageUsers();
    }

    @Step("Открыть страницу users в браузере chrome")
    @AfterMethod
    public void closeBrowserChrome() {
        takeScreenshot();
        mainPageSteps.closeBrowser();
    }

    protected  WebDriver getDriver() {
        return driver.get();
    }

    @Attachment(value = "Attachment screenshot", type = "image/png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
