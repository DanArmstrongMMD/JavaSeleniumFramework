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
 mvn clean package
```
 
Or, if you are using IntelliJ, you can run individual Senarios and Feature files from within the code by simply adding:
```org.framework``` to your Cucumber Run Configuration, as the Cucumber Glue.

# Coming Soon

- Driver Factory Class for generating the driver and browser based on command line arguments
- Screenshot on failure
- Cucumber local HTML reporting