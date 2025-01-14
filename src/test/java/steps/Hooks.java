package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.CommonMethods;

import java.io.IOException;
import java.time.Duration;

public class Hooks extends CommonMethods {
    //this is for pre condition of the project
    @Before
    public void start() throws IOException {
        openBrowserAndLaunchApplication();
    }

    @After
    public void end(Scenario scenario){
        //scenario class - this class contains all the information about execution logs
        //screenshot right before the browser closes
        byte[] pic;
        if(scenario.isFailed()) {
            pic = takeScreenshot("failed/"+scenario.getName());
        }else{
            pic = takeScreenshot("passed/"+scenario.getName());
        }

        closeBrowser();
    }

}
