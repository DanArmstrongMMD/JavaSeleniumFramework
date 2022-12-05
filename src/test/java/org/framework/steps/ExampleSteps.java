package org.framework.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.framework.pageobjects.ExamplePage;
import org.framework.utils.ScenarioContext;

public class ExampleSteps
{

    private ScenarioContext scenarioContext;

    public ExampleSteps(ScenarioContext scenarioContext)
    {
        this.scenarioContext = scenarioContext;
    }

    private ExamplePage examplePage;

    @Given("the user has navigated to the example page")
    public void theUserHasNavigatedToTheExamplePage()
    {
        examplePage = new ExamplePage(scenarioContext.getDriver())
                .goToPage();
    }

    @When("the user does an action")
    public void theUserDoesAnAction()
    {
        examplePage
                .performAction();
    }

    @Then("the user should see the result")
    public void theUserShouldSeeTheResult()
    {
        examplePage
                .confirmExampleActionComplete();

    }
}
