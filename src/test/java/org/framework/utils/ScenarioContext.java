package org.framework.utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static org.framework.utils.DriverBuilder.buildDriver;

public class ScenarioContext
{
    private WebDriver driver;
    private boolean initialised = false;

    @Before
    public void setUp()
    {
        if (!initialised)
        {
            this.driver = buildDriver();

            this.driver.manage().timeouts().implicitlyWait(Duration.ofMillis(0));
            this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
            this.driver.manage().window().maximize();

            this.driver.manage().deleteAllCookies();

            initialised = true;
        }
    }

    public WebDriver getDriver()
    {
        return driver;
    }

    @After
    public void tearDown(Scenario scenario)
    {
        try
        {
            if(scenario.isFailed())
            {
                scenario.attach(
                        ((TakesScreenshot) getDriver())
                        .getScreenshotAs(OutputType.BYTES),
                        "image/png",
                        "screenshot");
            }
        }
        catch (Exception ex)
        {
            System.out.println("Failed to take screenshot, error: " + ex);
        }
        finally {
            getDriver().quit();
            initialised = false;
        }
    }

}
