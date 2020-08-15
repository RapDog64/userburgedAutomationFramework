package ru.userbugred.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.userbugred.driver.BrowserFactory;

public abstract class AbstractPage {

    private static final Logger LOGGER = LogManager.getLogger(AbstractPage.class);

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public AbstractPage() {
        this.driver = BrowserFactory.getDriver();
        wait = new WebDriverWait(driver, 15);
        actions = new Actions(driver);
        PageFactory.initElements(this.driver, this);
    }


    public void click(WebElement element) {
        LOGGER.info("Clicking on " + element);
        element.click();
    }

    public void openUrl(String url) {
        LOGGER.info("Open the url: " + url);
        driver.navigate().to(url);
    }
}
