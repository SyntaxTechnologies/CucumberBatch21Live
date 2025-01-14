package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;


import java.time.Duration;

public class LoginSteps extends CommonMethods {

 //   public WebDriver driver;

    @Given("user is able to access HRMS application")
    public void user_is_able_to_access_hrms_application() {
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @When("user enters admin username and password")
    public void user_enters_admin_username_and_password() {
       // LoginPage loginPage = new LoginPage();
      //  WebElement usernameField = driver.findElement(By.id("txtUsername"));
       // WebElement passwordField = driver.findElement(By.id("txtPassword"));

        sendText(ConfigReader.read("userName"), loginPage.usernameField);
        sendText(ConfigReader.read("password"), loginPage.passwordField);
      //  usernameField.sendKeys("admin");
      //  passwordField.sendKeys("Hum@nhrm123");
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        //   WebElement loginButton = driver.findElement(By.id("btnLogin"));
      //  loginButton.click();
      //  LoginPage loginPage = new LoginPage();
        click(loginPage.loginButton);
    }

    @Then("user is able to see dashboard page")
    public void user_is_able_to_see_dashboard_page() {
        //need  assertion here to validate the presence of element or value of element
        Assert.assertTrue(dashboardPage.messageText.isDisplayed());
        System.out.println("Test passed");
    }

    @When("user enters invalid username and password")
    public void user_enters_invalid_username_and_password() {
      //  WebElement usernameField = driver.findElement(By.id("txtUsername"));
       // WebElement passwordField = driver.findElement(By.id("txtPassword"));

      //  usernameField.sendKeys("admin123");
      //  passwordField.sendKeys("Hum@nhrm");
        sendText("admin234", loginPage.usernameField);
        sendText("Hum@n", loginPage.passwordField);
    }

    @Then("user is able to see error message")
    public void user_is_able_to_see_error_message() {
        String errorValue = loginPage.errorMessage.getText();
        Assert.assertEquals("Invali credentials", errorValue);
        System.out.println("Error message shown");
    }

}
