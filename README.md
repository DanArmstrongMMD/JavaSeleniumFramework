# Java Selenium Framework

Basic Java Selenium Framework using Cucumber, for developing automated end to end browser tests.

# What's Inside

- Java Selenium setup so you can quickly get started with writing steps
- Dependency Injected Scenario Context Object which controls driver mappings
- Page Object Model structure, with a Base Page containing wrappers for some common Selenium functionality
- Parallel execution of Cucumber Scenarios (using all available cores)
- Cucumber Reports generation
- Screenshot on failure
- Driver Builder Class for generating the driver and browser based on command line arguments
  - Arguments: ```browser```(defaulted to "chrome"), ```headless``` (defaulted to "true")

# Usage

Designed for use as a template for a new repository of tests, download and use as a template.

# Running the Tests
 
 In order to run these tests, you will need java and maven installed and configured on your machine.
 
 From a terminal, run:

```
 mvn clean install
```
 
Or, if you are using IntelliJ, you can run individual Scenarios and Feature files from within the code by simply adding:
```org.framework``` to your Cucumber Run Configuration, as the Cucumber Glue.

When running the tests in your IDE, it can be worth adding the command line argument ```-Dheadless=false``` to your cucumber run configuration
this will allow you to run individual Scenarios and Feature files with the browser open, but keep the command line implementation
in headless mode.
For intelliJ, add this as your default Cucumber Java VM options.

# Command line Options

```-Dheadless```, enables or disables your browser's headless flag, any value except the string ```true``` will return ```false```, default setting is ```true```

```-Dbrowser```, allows for the selection of different browsers, non-accepted values will result in a default of ```chrome```.
- options:
    - ```chrome```
    - ```edge```
    - ```firefox``` (needs testing)
    - ```safari``` (needs testing)


# How to Write New Tests

Using this template, you can find an example feature file in the ```src/test/resources/org/framework/features``` folder, and you should write new features in here too. Step files are found in ```src/test/java/org/framework/steps```, alongside the Page Objects in the neighbouring ```pageobjects``` directory.

If you need to create any context-stored variables, these should be added to the ScenarioContext object inside the ```utils``` folder, but my tendency is to avoid storing too much in the Scenario Context unless absolutely necessary, and instead use natural language to incorporate data into the feature file, and use Scenario Outlines to avoid repetition. 
In a future update, I will add in some more functionality to the ScenarioContext class, such as screenshot on failure and better reporting, but it's mostly an object for storing driver information at present.

# Coming Soon


- Cucumber local HTML reporting
