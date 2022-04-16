package pages;

import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import exeptions.BrowserNotSupported;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPageSteps {

    public  ElementsCollection users = $$x("//*[@class=\"MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 MuiCard-root css-y6yw79-MuiPaper-root-MuiCard-root\"]");

    public String url = "http://localhost:3000/";

    @Step("открытие браузера chrome")
//    @Given("Open browser {string}")
    public void openBrowserChrome(String browserType) throws BrowserNotSupported {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 50;

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
    @Step("откртыие страницы приложения")
    public void openPageUsers() {
        open(url);
    }
    @Step("закрчтие браузера")
    public void closeBrowser() {
        Selenide.closeWindow();
    }





    public MainPageSteps moveToElementAndClick(SelenideElement element) {
        Actions actions = new Actions(getWebDriver());
        actions.moveToElement(element).click().build().perform();
        return new MainPageSteps();
    }
    @Step("проверка отображения поля id")
    @Attachment
    public void checkThatIdIsVisible() {
        System.out.println(users.get(0).shouldBe(Condition.visible,Duration.ofSeconds(10)).getText());
        Assert.assertTrue(users.get(0).shouldBe(Condition.visible,Duration.ofSeconds(10)).getText().contains("Id:"));
    }
    @Step("проверка отображения поля name")
    @Attachment
    public void checkThatNameIsVisible() {
        System.out.println(users.get(0).shouldBe(Condition.visible,Duration.ofSeconds(10)).getText());
        Assert.assertTrue(users.get(0).shouldBe(Condition.visible,Duration.ofSeconds(10)).getText().contains("Name:"));
    }
    @Step("проверка отображения поля grade")
    @Attachment
    public void checkThatGradeIsVisible() {
        System.out.println(users.get(0).shouldBe(Condition.visible, Duration.ofSeconds(10)).getText());
        Assert.assertTrue(users.get(0).shouldBe(Condition.visible,Duration.ofSeconds(10)).getText().contains("Grade:"));
    }

    @Step("проверка отображения данных конкретного пользователя")
    @Attachment
    public void checkThatUserDateIsVisible() {

        Assert.assertTrue(users.get(0).shouldBe(Condition.visible,Duration.ofSeconds(10)).getText().contains("Иванов Иван Иванович"));
        Assert.assertTrue(users.get(0).shouldBe(Condition.visible,Duration.ofSeconds(10)).getText().contains("1"));
        Assert.assertTrue(users.get(0).shouldBe(Condition.visible,Duration.ofSeconds(10)).getText().contains("Тестировщик ПО"));
    }

    @Step("проверка отображения польше карточеек пользователей")
    @Attachment
    public void checkThatThatUsersMoreThen(int arg0) {
        users.get(0).shouldBe(Condition.visible);
        Assert.assertTrue(users.size()>20);
    }

    @Step("откртыь карточку юзера")
    @Attachment
    public void openPageUser() {
        $$x("//*[@class=\"MuiCardHeader-content css-1qbkelo-MuiCardHeader-content\"]").get(0).shouldBe(Condition.visible,Duration.ofSeconds(10)).click();
        System.out.println(users.get(0).shouldBe(Condition.visible,Duration.ofSeconds(10)).getText());
    }
}
