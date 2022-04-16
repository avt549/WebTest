package Test;

import org.testng.annotations.Test;

public class CheckUserPageTest extends BaseTest {


    @Test(testName="проверка отображения данных на странице пользователя",
            description = "проверка отображения данных на странице пользователя")
    public void checkUserDateTest(){
        mainPageSteps.openPageUser();
        userPageSteps.checkThatUserDate();
    }

    @Test(testName="проверка отображения поля name",
            description = "проверка отображения поля name")
    public void checkThatUserNameTest(){
        mainPageSteps.openPageUser();
        userPageSteps.checkThatUserName();
    }

    @Test(testName="проверка отображения поля Grade",
            description = "проверка отображения поля Grade")
    public void checkThatUserGradeTest(){
        mainPageSteps.openPageUser();
        userPageSteps.checkThatUserGrade();
    }
    @Test(testName="проверка отображения поля School Name",
            description = "проверка отображения поля School Name")
    public void checkThatUserSchoolNameTest(){
        mainPageSteps.openPageUser();
        userPageSteps.checkThatUserSchoolName();
    }
    @Test(testName="проверка отображения поля City",
            description = "проверка отображения поля City")
    public void checkThatUserCityTest(){
        mainPageSteps.openPageUser();
        userPageSteps.checkThatUserCity();
    }

}
