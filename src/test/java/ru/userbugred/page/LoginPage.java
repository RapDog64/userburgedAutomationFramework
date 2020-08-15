package ru.userbugred.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class LoginPage extends AbstractPage {

    @FindBy(xpath = "//input[@name='login']")
    WebElement usernameInput;

    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordInput;

    @FindBy(xpath = "//input[@value='Авторизоваться']")
    WebElement signInBtn;

    @Step
    public LoginPage typeLogin(String login) {
        usernameInput.click();
        usernameInput.clear();
        usernameInput.sendKeys(login);
        return this;
    }

    @Step
    public LoginPage typePassword(String password) {
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
        return this;
    }

    @Step
    public MainPage clickSignInBtn() {
        click(signInBtn);
        return new MainPage();
    }


}
