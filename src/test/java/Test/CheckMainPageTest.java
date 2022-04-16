package Test;

import exeptions.BrowserNotSupported;
import org.testng.annotations.Test;

public class CheckMainPageTest extends BaseTest{


    @Test(testName="проверка отображения данных пользователя",
            description = "проверка отображения данных пользователя")
    public void checkUserDateTest(){
        mainPageSteps.checkThatUserDateIsVisible();
    }

    @Test(testName="проверка отображения грейда пользователя",
            description = "проверка отображения грейда пользователя")
    public void checkGradeIsVisibleTest(){
        mainPageSteps.checkThatGradeIsVisible();
    }


    @Test(testName="проверка отображения 20 пользователей",
            description = "проверка отображения 20 пользователей")
    public void checkThatThatUsersMoreThenTest(){
        mainPageSteps.checkThatThatUsersMoreThen(20);
    }


    @Test(testName="проверка отображения поля id",
            description = "проверка отображения поля id")
    public void checkThatIdIsVisibleTest(){
        mainPageSteps.checkThatIdIsVisible();
    }



    @Test(testName="проверка отображения поля name",
            description = "проверка отображения поля name")
    public void checkThatNameIsVisibleTest(){
        mainPageSteps.checkThatNameIsVisible();
    }
}
