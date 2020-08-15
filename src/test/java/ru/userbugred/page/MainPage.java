package ru.userbugred.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.allure.annotations.Step;

public class MainPage extends AbstractPage {

    private static final Logger LOGGER = LogManager.getLogger(MainPage.class);

    @FindBy(xpath = "//span[contains(text(),'Войти')]")
    WebElement enterBtn;

    @FindBy(css = ".dropdown-toggle")
    WebElement userProfileSection;

    @FindBy(xpath = "//a[contains(text(),'Выход')]")
    WebElement signOutBtn;

    public LoginPage clickEnterBtn() {
        LOGGER.info("Clicking on" + enterBtn);
        click(enterBtn);
        return new LoginPage();
    }

    @Step
    public MainPage navigateTo(String url) {
        super.openUrl(url);
        return this;
    }

    @Step
    public String getUsername() {
        LOGGER.info("Getting username");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".dropdown-toggle")));
        return userProfileSection.getText();
    }

    @Step
    public MainPage openDropDownMenu() {
        click(userProfileSection);
        return this;
    }

    @Step
    public MainPage logout() {
        click(signOutBtn);
        return this;
    }

    @Step
    public boolean isEnterBtnDisplayed() {
        LOGGER.info("Checking sign up button is displayed");
        return enterBtn.isDisplayed();
    }


}
