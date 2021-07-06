package com.lmmv.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/lmmv/step_definitions",
        dryRun = false,
        tags = "@vip"
)
public class CukesRunner {
}
