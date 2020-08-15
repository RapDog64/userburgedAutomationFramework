package ru.userbugred.service;

import ru.userbugred.model.User;
import ru.userbugred.page.MainPage;

public class LoginService {

    private MainPage mainPage = new MainPage();

    public void loginWithCorrectCredentials() {
        User user = UserManager.prepareUser();

        mainPage.navigateTo("http://users.bugred.ru/")
                .clickEnterBtn()
                .typeLogin(user.getEmail())
                .typePassword(user.getPassword())
                .clickSignInBtn();
    }
}
