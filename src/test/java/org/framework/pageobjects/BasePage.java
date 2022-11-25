package org.framework.pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

import static org.junit.Assert.fail;

public class BasePage
{
    protected WebDriver driver;
    private FluentWait wait;

    private final int maxAttempts = 3;
    private int attempts = 0;

    protected BasePage(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new FluentWait(this.driver)
                .withTimeout(Duration.ofSeconds(3))
                .pollingEvery(Duration.ofSeconds(1));

        PageFactory.initElements(driver, this);
    }

    protected WebElement waitUntilElementIsVisible(WebElement element) {
        while (attempts < maxAttempts) {
            try {
                wait.until(ExpectedConditions.visibilityOf(element));
                break;
            } catch (NoSuchElementException | StaleElementReferenceException e)
            {
                if(attempts >= maxAttempts)
                {
                    fail("No Such Element found after " + maxAttempts + " tries.");
                }
                else
                {
                    System.out.println("No Such Element found, retrying. Attempts: " + (attempts + 1));
                    ++attempts;
                }
            }
        }

        attempts = 0;
        return element;
    }

    protected WebElement waitUntilElementIsClickable(WebElement element) {
        while (attempts < maxAttempts) {
            try {
                wait.until(ExpectedConditions.visibilityOf(element));
                wait.until(ExpectedConditions.elementToBeClickable(element));
                break;
            } catch (NoSuchElementException | StaleElementReferenceException e)
            {
                if(attempts >= maxAttempts)
                {
                    fail("No Such Element found after " + maxAttempts + " tries.");
                }
                else
                {
                    System.out.println("No Such Element found, retrying. Attempts: " + (attempts + 1));
                    ++attempts;
                }
            }
            catch (ElementNotInteractableException e)
            {
                if(attempts >= maxAttempts)
                {
                    fail("Element not Clickable after " + maxAttempts + " tries, failing");
                }
                else
                {
                    System.out.println("Element not Clickable, retrying. Attempts: " + (attempts + 1));
                    ++attempts;
                }
            }
        }

        attempts = 0;
        return element;
    }
}
