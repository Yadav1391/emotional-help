package com.epam.singleton;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class SingletonWebDriver {

    private static SingletonWebDriver instance = null;
    private WebDriver driver;

    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

    private SingletonWebDriver() {

    }

    public static SingletonWebDriver getInstance() {
        if (instance == null) {
            instance = new SingletonWebDriver();
        }
        return instance;
    }

    public WebDriver getDriver(String browserName) {

        setWebDriver(browserName);

        return webDriver.get();
    }

    public WebDriver setWebDriver(String browserName) {

        switch (browserName) {
            case ("Chrome") -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                driver = new ChromeDriver(options);
                webDriver.set(driver);
            }
            case ("Edge") -> {
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--start-maximized");
                driver = new EdgeDriver(edgeOptions);
                webDriver.set(driver);
            }
        }
        return driver;
    }
}

