package com.live.hrms.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        plugin={
                "pretty",
                "html:target/cucumberReport",
                "json:target/cucumberReport/cucumber.json",
        },
        tags="@UI2",
       // strict = true,
        features = "src/test/java/com/live/hrms/features",
        glue={"com.live.hrms.stepDef"}
)
public class TestNGRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {

        return super.scenarios();
    }

}
