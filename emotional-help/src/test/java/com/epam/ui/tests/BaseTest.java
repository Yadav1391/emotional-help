package com.epam.ui.tests;

import com.epam.common.ConfigReader;
import com.epam.singleton.SingletonWebDriver;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


import java.io.IOException;
import java.sql.DriverManager;
import java.time.Duration;

public class BaseTest {
    WebDriver webDriver;
    DriverManager driverManager;
    String webUrl;

    @Parameters({"browserName", "envName"})
    @BeforeClass(groups = "smoke")
    public void setUp(@Optional("Chrome") String browserName, @Optional("integration") String envName) throws IOException, InterruptedException {
        webDriver = SingletonWebDriver.getInstance().getDriver(browserName);
        webUrl = ConfigReader.getValueFromProperties(envName,"ui.app.url");
        webDriver.get(webUrl);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterClass
    public void tearDown() {
        webDriver.quit();
    }
}
