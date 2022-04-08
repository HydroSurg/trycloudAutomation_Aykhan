package com.trycloud.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "rerun:target/rerun.txt",
              //  "me.jvt.cucumber.report.PrettyReports:target",
                "json:target/cucumber.json",

                "junit:target/junit/junit-report.xml",
        },
        features = "src/test/resources/features",
        glue = "com/trycloud/step_definitions",
        dryRun = false,
        tags = "@US10"
       // publish = false

)



public class CukesRunner {
}
