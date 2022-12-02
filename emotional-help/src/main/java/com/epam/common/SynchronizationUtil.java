package com.epam.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SynchronizationUtil {
    private static final Logger logger = LogManager.getLogger(SynchronizationUtil.class);

    private SynchronizationUtil() {
    }

    private static void waitUntilElementVisible(WebDriver driver, WebElement currentElement) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.ignoring(NoSuchElementException.class).until(ExpectedConditions.visibilityOf(currentElement));
        } catch (Exception exception) {
            logger.info("Element is not Visible");
        }
    }

    public static void webElementVisible(WebDriver driver, WebElement element) {
        waitUntilElementVisible(driver, element);
    }

    private static void waitUntilElementClick(WebDriver driver, WebElement currentElement) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.ignoring(NoSuchElementException.class).until(ExpectedConditions.elementToBeClickable(currentElement));
        } catch (Exception exception) {
            logger.info("Element is not Clickable");
        }
    }

    public static void webElementClick(WebDriver driver, WebElement element) {
        waitUntilElementClick(driver, element);
        element.click();
    }

    public static void webElementWait(WebDriver driver) {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
    }
}
