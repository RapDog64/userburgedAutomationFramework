package ru.userbugred.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;
import ru.userbugred.driver.BrowserFactory;


public abstract class AbstractTest {

    protected static final Logger LOGGER = LogManager.getLogger(AbstractTest.class);


    @Parameters("browser")
    @BeforeClass
    public void setUp(String browser) {
        LOGGER.info("Starting the browser");
      BrowserFactory.initDriver(browser);
    }

    @AfterClass
    public void tearDown() {
        LOGGER.info("Closing the browser");
        BrowserFactory.quitDriver();
    }
}
