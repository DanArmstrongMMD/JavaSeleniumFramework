package org.framework.utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class ScenarioContext
{
    private WebDriver driver;
    private static boolean initialised = false;

    @Before
    public void setUp() {
        setDriver();
    }

    public WebDriver getDriver()
    {
        return driver;
    }

    public void setDriver()
    {
        if (!initialised)
        {
            ChromeOptions options = new ChromeOptions();

            this.driver = new ChromeDriver(options);

            // Implicit Wait
            this.driver.manage().timeouts().implicitlyWait(Duration.ofMillis(0));

            this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
            this.driver.manage().window().maximize();

            this.driver.manage().deleteAllCookies();

            initialised = true;
        }
    }


    @After
    public void tearDown()
    {
        getDriver().quit();
        initialised = false;
    }

}
