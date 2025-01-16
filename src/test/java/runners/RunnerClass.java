package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //path of the features directory
        features = "src/test/resources/features/",
       // features = "src/test/resources/features/Login.feature"
        // glue keyword we use to provide the name of the package we use for step def
        glue = "steps",

        //when i set the value of dry run to true, it stops actual execution and scans
        //all the steps, it any step def is missing, it will generate
        //to execute the code, we set the value of it to false
        dryRun = false,
        //pretty keyword prints all the steps in console
        //rerun plugin generates  txt file contains the path of failed test cases
        plugin = {"pretty", "html:target/cucumber.html","rerun:target/failed.txt",
        "json:target/cucumber.json"},
        tags = "@tekia"
)


public class RunnerClass {

}
