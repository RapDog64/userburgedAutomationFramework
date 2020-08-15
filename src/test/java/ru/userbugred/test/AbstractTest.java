package ru.userbugred.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ru.userbugred.driver.BrowserFactory;


public abstract class AbstractTest {

    protected static final Logger LOGGER = LogManager.getLogger(AbstractTest.class);

    @BeforeClass
    public void setUp() {
        LOGGER.info("Starting the browser");
        BrowserFactory.getDriver();
    }

    @AfterClass
    public void tearDown() {
        LOGGER.info("Closing the browser");
        BrowserFactory.quitDriver();
    }
}
