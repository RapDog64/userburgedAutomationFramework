package ru.userbugred.config.listener;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.userbugred.driver.BrowserFactory;
import ru.yandex.qatools.allure.annotations.Attachment;


public class AllureListener implements ITestListener {

    private static final Logger LOGGER = LogManager.getLogger(AllureListener.class);

    @Override
    public void onTestFailure(ITestResult result) {
        if (BrowserFactory.getDriver() != null) {
            LOGGER.info("Screenshot was captured for test case:" + getTestMethodName(result));
            saveScreenshotPNG(BrowserFactory.getDriver());
        }
    }

    private static String getTestMethodName(ITestResult testResult) {
        return testResult.getMethod().getConstructorOrMethod().getName();
    }


    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
