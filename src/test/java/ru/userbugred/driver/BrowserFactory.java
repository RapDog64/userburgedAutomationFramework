package ru.userbugred.driver;

import org.openqa.selenium.WebDriver;
import ru.userbugred.util.BrowserReader;

import java.util.concurrent.TimeUnit;

public class BrowserFactory {

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    private BrowserFactory() {
    }

    public synchronized static void initDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            DRIVER.set(new LocalChromeDriverManager().create());
        } else if (browser.equalsIgnoreCase("firefox")) {
            DRIVER.set(new LocalFireFoxDriverManager().create());
        }

        DRIVER.get().manage().window().maximize();
        DRIVER.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        DRIVER.get().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    public synchronized static WebDriver getDriver() {
        return DRIVER.get();
    }

    public synchronized static void quitDriver() {
        if (DRIVER.get() != null) {
            DRIVER.get().quit();
            DRIVER.remove();
        }
    }
}
