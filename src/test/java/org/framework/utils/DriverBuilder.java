package org.framework.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class DriverBuilder
{
    public static WebDriver buildDriver()
    {
        WebDriver driver;

        String browserType = System.getProperty("browser", "chrome");
        boolean headless = Boolean.parseBoolean(System.getProperty("headless", "false"));

        switch (browserType) {
            case "chrome" ->
            {
                ChromeOptions options = new ChromeOptions();
                if (headless)
                {
                    options.addArguments("--headless");
                }
                options.addArguments("--window-size=1920,1200");
                driver = new ChromeDriver(options);
            }
            case "edge" ->
            {
                EdgeOptions options = new EdgeOptions();
                if (headless)
                {
                    options.addArguments("--headless");
                }
                options.addArguments("--window-size=1920,1200");
                driver = new EdgeDriver(options);
            }
            case "firefox" ->
            {
                FirefoxOptions options = new FirefoxOptions();
                if (headless)
                {
                    options.addArguments("--headless");
                }
                options.addArguments("--window-size=1920,1200");
                driver = new FirefoxDriver(options);
            }
            case "safari" ->
            {
                SafariOptions options = new SafariOptions();
                if (headless)
                {
                    System.out.println("Note: Headless Mode not supported by Safari");
                }
                driver = new SafariDriver(options);
            }
            default ->
            {
                System.out.println("Warn: Unsupported browser type selected, defaulting to Chrome...");
                ChromeOptions options = new ChromeOptions();
                if (headless) {
                    options.addArguments("--headless");
                }
                options.addArguments("--window-size=1920,1200");
                driver = new ChromeDriver(options);
            }
        }
        return driver;
    }
}
