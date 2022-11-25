package org.framework.pageobjects;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExamplePage extends BasePage
{
    private static final String URL = "https://www.google.com";
    private boolean actionPerformed = false;

    public ExamplePage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(css="div[id='exampleId']")
    private WebElement exampleElement;

    public ExamplePage goToPage()
    {
        driver.navigate().to(URL);
        return this;
    }

    public ExamplePage performAction()
    {
        this.actionPerformed = true;
        return this;
    }

    public ExamplePage confirmExampleActionComplete()
    {
        assertTrue(actionPerformed);
        return this;
    }
}
