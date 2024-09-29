package org.puneeth.RunnerFile;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber.html"},
        features = {"src/test/java/FeatureFiles"},
        glue = {"src/main/java/org/puneeth/StepDefinitionFile"},
        monochrome = true,
        dryRun = false,
        tags = ("@NewCustomer")
)

public class TestRunnerFile  {


}
