# Java Selenium Framework

Basic Java Selenium Framework using Cucumber, for developing automated end to end browser tests.

# What's Inside

- Java Selenium setup so you can quickly get started with writing steps
- Dependency Injected Scenario Context Object which controls driver mappings
- Page Object Model structure, with a Base Page containing wrappers for some common Selenium functionality
- Parallel execution of Cucumber Scenarios (using all available cores)
- Cucumber Reports generation

# Usage

Designed for use as a template for a new repository of tests, download and use as a template.

# Running the Tests
 
 In order to run these tests, you will need java and maven installed and configured on your machine.
 
 From a terminal, run:

```
 mvn clean install
```
 
Or, if you are using IntelliJ, you can run individual Senarios and Feature files from within the code by simply adding:
```org.framework``` to your Cucumber Run Configuration, as the Cucumber Glue.

# How to Write New Tests

Using this template, you can find an example feature file in the ```src/test/resources/org/framework/features``` folder, and you should write new features in here too. Step files are found in ```src/test/java/org/framework/steps```, alongside the Page Objects in the neighbouring ```pageobjects``` directory.

If you need to create any context-stored variables, these should be added to the ScenarioContext object inside of the ```utils``` folder, but my tendancy is to avoid storing too much in the Scenario Context unless absolutely necessary, and instead use natural language to incorporate data into the feature file, and use Scenario Outlines to avoid repetition. 
In a future update, I will add in some more functionality to the ScenarioContext class, such as screenshot on failure and better reporting, but it's mostly an object for storing driver information at present.

# Coming Soon

- Driver Factory Class for generating the driver and browser based on command line arguments
- Screenshot on failure
- Cucumber local HTML reporting
