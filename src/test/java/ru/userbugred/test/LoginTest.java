package ru.userbugred.test;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import ru.userbugred.model.User;
import ru.userbugred.page.MainPage;
import ru.userbugred.service.UserManager;
import ru.yandex.qatools.allure.annotations.*;
import ru.yandex.qatools.allure.model.SeverityLevel;

public class LoginTest extends AbstractTest {

    @AfterMethod
    public void logout() {
        MainPage mainPage = new MainPage();
        mainPage.openDropDownMenu().logout();
    }

    @Test
    @Features(value = "Log in feature")
    @Stories(value = "User authentication")
    @TestCaseId(value = "1")
    @Severity(SeverityLevel.CRITICAL)
    @Title("Log in with correct credentials")
    @Description("Log in as a user with correct data")
    public void loginWithCorrectCredential() {
        User user = UserManager.withFullCredentials();
        String actualUsername = new MainPage()
                .navigateTo("http://users.bugred.ru/")
                .clickEnterBtn()
                .typeLogin(user.getEmail())
                .typePassword(user.getPassword())
                .clickSignInBtn()
                .getUsername();
        Assert.assertEquals(actualUsername, user.getName());
    }
}
