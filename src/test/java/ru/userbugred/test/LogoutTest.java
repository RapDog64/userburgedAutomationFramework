package ru.userbugred.test;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.userbugred.page.MainPage;
import ru.userbugred.service.LoginService;
import ru.yandex.qatools.allure.annotations.*;
import ru.yandex.qatools.allure.model.SeverityLevel;

public class LogoutTest extends AbstractTest {

    @BeforeMethod
    public void loginAsUser() {
        LoginService loginService = new LoginService();
        loginService.loginWithCorrectCredentials();
    }

    @Test
    @Features(value = "Log out feature")
    @Stories(value = "Log out possibility")
    @TestCaseId(value = "2")
    @Severity(SeverityLevel.CRITICAL)
    @Title("Log out from the website")
    @Description("Log out from the website")
    public void logout() {
        boolean signUp = new MainPage()
                .openDropDownMenu()
                .logout()
                .isEnterBtnDisplayed();
        Assert.assertTrue(signUp, "The sign up button has not been displayed");
    }
}
