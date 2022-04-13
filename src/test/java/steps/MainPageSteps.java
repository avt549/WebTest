package steps;

import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import exeptions.BrowserNotSupported;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPageSteps {

    public  ElementsCollection users = $$x("//*[@class=\"MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 MuiCard-root css-y6yw79-MuiPaper-root-MuiCard-root\"]");

    public String url = "http://localhost:3000/";


    @Given("Open browser {string}")
    public void openBrowserChrome(String browserType) throws BrowserNotSupported {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 50;
        Configuration.startMaximized = true;
        Configuration.pageLoadTimeout = 5000;
        switch (browserType) {
            case "chrome":
                Configuration.browser = "chrome";
                break;
            case "opera":
                Configuration.browser = "opera";
                break;
            case "firefox":
                Configuration.browser = "fireFox";
                break;
            default:
                throw new BrowserNotSupported();
        }

    }
    @When("Open page users")
    public void openPageUsers() {
        open(url);
    }

    @Then("Close browser")
    public void closeBrowser() {
        Selenide.closeWindow();
    }





    public MainPageSteps moveToElementAndClick(SelenideElement element) {
        Actions actions = new Actions(getWebDriver());
        actions.moveToElement(element).click().build().perform();
        return new MainPageSteps();
    }

    @When("check that id is visible")
    public void checkThatIdIsVisible() {
        System.out.println(users.get(0).waitUntil(Condition.visible,5000).getText());
        Assert.assertTrue(users.get(0).waitUntil(Condition.visible,5000).getText().contains("Id:"));
    }
    @When("check that name is visible")
    public void checkThatNameIsVisible() {
        System.out.println(users.get(0).waitUntil(Condition.visible,5000).getText());
        Assert.assertTrue(users.get(0).waitUntil(Condition.visible,5000).getText().contains("Name:"));
    }
    @When("check that grade is visible")
    public void checkThatGradeIsVisible() {
        System.out.println(users.get(0).waitUntil(Condition.visible,5000).getText());
        Assert.assertTrue(users.get(0).waitUntil(Condition.visible,5000).getText().contains("Grade:"));
    }

    @When("check that user date is visible")
    public void checkThatUserDateIsVisible() {

        Assert.assertTrue(users.get(0).waitUntil(Condition.visible,5000).getText().contains("Иванов Иван Иванович"));
        Assert.assertTrue(users.get(0).waitUntil(Condition.visible,5000).getText().contains("1"));
        Assert.assertTrue(users.get(0).waitUntil(Condition.visible,5000).getText().contains("Тестировщик ПО"));
    }

    @When("check that that users more then {int}")
    public void checkThatThatUsersMoreThen(int arg0) {
        users.get(0).waitUntil(Condition.visible,5000);
        Assert.assertTrue(users.size()>arg0);
    }

    @When("Open page user")
    public void openPageUser() {

        $$x("//*[@class=\"MuiCardHeader-content css-1qbkelo-MuiCardHeader-content\"]").get(0).waitUntil(Condition.visible,5000).click();
        System.out.println(users.get(0).waitUntil(Condition.visible,5000).getText());
    }
}
