package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.When;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.testng.Assert;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class UserPageSteps {
public SelenideElement userCard = $x("//*[@class=\"MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 MuiCard-root css-y6yw79-MuiPaper-root-MuiCard-root\"]");
public SelenideElement userSchool = $x("//*[contains(text(),'School Name')]");

    @Step("проверка данных конкретного пользователя")
    @Attachment
    public void checkThatUserDate(){
        userSchool.shouldBe(Condition.visible,Duration.ofSeconds(10));
        Assert.assertTrue(userCard.shouldBe(Condition.visible,Duration.ofSeconds(10)).getText().contains("Иванов Иван Иванович"));
        Assert.assertTrue(userCard.shouldBe(Condition.visible,Duration.ofSeconds(10)).getText().contains("СПБГУ"));
        Assert.assertTrue(userCard.shouldBe(Condition.visible,Duration.ofSeconds(10)).getText().contains("Тестировщик ПО"));
        Assert.assertTrue(userCard.shouldBe(Condition.visible,Duration.ofSeconds(10)).getText().contains("Санкт-Петербург"));
    }
    @Step("проверка отображения поля name")
    @Attachment
    public void checkThatUserName() {
        System.out.println();
        Assert.assertTrue(userCard.shouldBe(Condition.visible,Duration.ofSeconds(10)).getText().contains("Name:"));

    }
    @Step("проверка отображения поля grade")
    @Attachment
    public void checkThatUserGrade() {
        Assert.assertTrue(userCard.shouldBe(Condition.visible, Duration.ofSeconds(10)).getText().contains("Grade:"));

    }
    @Step("проверка отображения поля School Name")
    @Attachment
    public void checkThatUserSchoolName() {
        Assert.assertTrue(userCard.shouldBe(Condition.visible,Duration.ofSeconds(10)).getText().contains("School Name"));

    }
    @Step("проверка отображения поля City")
    @Attachment
    public void checkThatUserCity() {
        Assert.assertTrue(userCard.shouldBe(Condition.visible,Duration.ofSeconds(10)).getText().contains("City"));
    }
}
