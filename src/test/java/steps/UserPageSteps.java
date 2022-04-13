package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.When;
import org.testng.Assert;

import javax.swing.text.html.parser.Element;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class UserPageSteps {
public SelenideElement userCard = $x("//*[@class=\"MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 MuiCard-root css-y6yw79-MuiPaper-root-MuiCard-root\"]");
public SelenideElement userSchool = $x("//*[contains(text(),'School Name')]");


    @When("check that user date")
    public void checkThatUserDate() {
        userSchool.waitUntil(Condition.visible,5000);
        Assert.assertTrue(userCard.shouldBe(Condition.visible).getText().contains("Иванов Иван Иванович"));
        Assert.assertTrue(userCard.shouldBe(Condition.visible).getText().contains("СПБГУ"));
        Assert.assertTrue(userCard.shouldBe(Condition.visible).getText().contains("Тестировщик ПО"));
        Assert.assertTrue(userCard.shouldBe(Condition.visible).getText().contains("Санкт-Петербург"));
    }

    @When("check that user name")
    public void checkThatUserName() {
    }

    @When("check that user drade")
    public void checkThatUserDrade() {
    }

    @When("check that user School Name")
    public void checkThatUserSchoolName() {
    }

    @When("check that user City")
    public void checkThatUserCity() {
    }
}
