package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;
import utils.DBUtils;
import utils.ExcelReader;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {

    String expectedFN;
    String expectedMN;
    String expectedLN;
    String employeeId;


    @When("user clicks on Add Employee option")
    public void user_clicks_on_add_employee_option() {
     //   WebElement addEmployeeOption = driver.findElement(By.id("menu_pim_addEmployee"));
      //  addEmployeeOption.click();
        click(dashboardPage.addEmployeeOption);
    }

    @When("user enters firstname and middlename and lastname")
    public void user_enters_firstname_and_middlename_and_lastname() {
      //  WebElement firstNameLocator = driver.findElement(By.id("firstName"));
      //  WebElement middleNameLocator = driver.findElement(By.id("middleName"));
      //  WebElement lastNameLocator = driver.findElement(By.id("lastName"));

       // firstNameLocator.sendKeys("evid");
       // middleNameLocator.sendKeys("andria");
      //  lastNameLocator.sendKeys("steven");
        sendText("evid", addEmployeePage.firstNameLocator);
        sendText("andria", addEmployeePage.middleNameLocator);
        sendText("steven", addEmployeePage.lastNameLocator);
    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        click(addEmployeePage.saveButton);
    }



    @When("user enters data {string} and {string} and {string}")
    public void user_enters_data_and_and
            (String firstname, String middlename, String lastname) {

        expectedFN=firstname;
        expectedMN=middlename;
        expectedLN=lastname;
        employeeId=addEmployeePage.employeeId.getAttribute("value");


        sendText(firstname, addEmployeePage.firstNameLocator);
        sendText(middlename, addEmployeePage.middleNameLocator);
        sendText(lastname, addEmployeePage.lastNameLocator);
    }

    @Then("employee added successfully")
    public void employee_added_successfully() {

        String query="select emp_firstname,emp_middle_name,emp_lastname from hs_hr_employees where employee_id="+employeeId;
      List<Map<String,String>> actualData= DBUtils.fetch(query);
      Map<String,String> rowMap=actualData.get(0);
      String actualFN=rowMap.get("emp_firstname");
      String actualMN=rowMap.get("emp_middle_name");
      String actualLN=rowMap.get("emp_lastname");
        Assert.assertEquals(expectedFN,actualFN);
        Assert.assertEquals(expectedMN,actualMN);
        Assert.assertEquals(expectedLN,actualLN);

    }

    @When("user enters {string} and {string} and {string}.")
    public void user_enters_and_and(String fn, String mn, String ln) {
        //WebElement firstNameLocator = driver.findElement(By.id("firstName"));
        //WebElement middleNameLocator = driver.findElement(By.id("middleName"));
        //WebElement lastNameLocator = driver.findElement(By.id("lastName"));

      //  firstNameLocator.sendKeys(fn);
      //  middleNameLocator.sendKeys(mn);
      //  lastNameLocator.sendKeys(ln);
        sendText(fn, addEmployeePage.firstNameLocator);
        sendText(mn, addEmployeePage.middleNameLocator);
        sendText(ln, addEmployeePage.lastNameLocator);
    }

    @When("user adds multiple employees using data table and verify them")
    public void user_adds_multiple_employees_using_data_table_and_verify_them
            (io.cucumber.datatable.DataTable dataTable) throws InterruptedException {

        //list of maps handling in java from data table
        List<Map<String, String>> employeeNames = dataTable.asMaps();
        //from list of maps, we will get one map at a time
        for (Map<String, String> name:employeeNames
             ) {
          //  WebElement firstNameLocator = driver.findElement(By.id("firstName"));
          //  WebElement middleNameLocator = driver.findElement(By.id("middleName"));
           // WebElement lastNameLocator = driver.findElement(By.id("lastName"));

            //from every map, we will get value based on the key
            addEmployeePage.firstNameLocator.sendKeys(name.get("firstName"));
            addEmployeePage.middleNameLocator.sendKeys(name.get("middleName"));
            addEmployeePage.lastNameLocator.sendKeys(name.get("lastName"));
            //we are still in the loop
           // WebElement saveButton = driver.findElement(By.id("btnSave"));
           // saveButton.click();
            click(addEmployeePage.saveButton);
            Thread.sleep(1000);
          //  WebElement addEmployeeOption = driver.findElement(By.id("menu_pim_addEmployee"));
          //  addEmployeeOption.click();
            click(dashboardPage.addEmployeeOption);
        }

    }

    @When("user adds employees from excel file and verify them")
    public void user_adds_employees_from_excel_file_and_verify_them() throws IOException, InterruptedException {
       List<Map<String, String>> employeeNames = ExcelReader.read();
        for (Map<String, String> name:employeeNames
             ) {
            WebElement firstNameLocator = driver.findElement(By.id("firstName"));
            WebElement middleNameLocator = driver.findElement(By.id("middleName"));
            WebElement lastNameLocator = driver.findElement(By.id("lastName"));

            //from every map, we will get value based on the key
            addEmployeePage.firstNameLocator.sendKeys(name.get("firstName"));
            addEmployeePage.middleNameLocator.sendKeys(name.get("middleName"));
            addEmployeePage.lastNameLocator.sendKeys(name.get("lastName"));
            //we are still in the loop
            click(addEmployeePage.saveButton);
            Thread.sleep(1000);
            //  WebElement addEmployeeOption = driver.findElement(By.id("menu_pim_addEmployee"));
            //  addEmployeeOption.click();
            click(dashboardPage.addEmployeeOption);
        }
    }


}
