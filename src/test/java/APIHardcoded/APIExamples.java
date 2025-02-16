package APIHardcoded;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class APIExamples {
//    setting the base URL
    String baseURI=RestAssured.baseURI="http://hrm.syntaxtechs.net/syntaxapi/api";

//    token
    String token= "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE3Mzk3MTk5MTEsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTczOTc2MzExMSwidXNlcklkIjoiNzA3MiJ9.tNqmIv81xS08642Yn14v4a8QDCKj8hncxZq3g78T7kc";

    static String empID;
    @Test
    public  void acreateEmployee(){
//        prepare the request
        RequestSpecification preparedRequest = given().header("Content-Type", "application/json").header("Authorization", token)
                .body("{\n" +
                        "  \"emp_firstname\": \"Shawn\",\n" +
                        "  \"emp_lastname\": \"Beverly\",\n" +
                        "  \"emp_middle_name\": \"S.\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"1990-03-09\",\n" +
                        "  \"emp_status\": \"active\",\n" +
                        "  \"emp_job_title\": \"Lead\"\n" +
                        "}");

        Response response = preparedRequest.when().post("/createEmployee.php");
        response.prettyPrint();

        response.then().assertThat().statusCode(201);

        response.then().assertThat().header("Connection","Keep-Alive");

        response.then().assertThat().body("Message",equalTo("Employee Created"));

        response.then().assertThat().body("Employee.emp_firstname",equalTo( "Shawn"));
//         extract the employee id to be used in the next getcall

        empID = response.jsonPath().getString("Employee.employee_id");
        System.out.println("the employee id is "+empID);

    }

    @Test
    public void bgetTheCreatedEmployee(){
        RequestSpecification preparedRequest = given().header("Content-Type", "application/json").header("Authorization", token)
                .queryParam("employee_id",empID);
        Response response = preparedRequest.when().get("/getOneEmployee.php");
        System.out.println("**********************Get call********************");
        response.prettyPrint();
        System.out.println("***************************************************");

        response.then().assertThat().body("employee.employee_id",equalTo(empID));
        response.then().statusCode(200);

    }

    @Test
    public void cUpdateTheEmployee(){
        RequestSpecification preparedRequest = given().header("Content-Type", "application/json").header("Authorization", token)
                .body("{\n" +
                        "  \"employee_id\": \""+empID+"\",\n" +
                        "  \"emp_firstname\": \"Crtistina\",\n" +
                        "  \"emp_lastname\": \"Meng\",\n" +
                        "  \"emp_middle_name\": \"CM\",\n" +
                        "  \"emp_gender\": \"F\",\n" +
                        "  \"emp_birthday\": \"1980-02-12\",\n" +
                        "  \"emp_status\": \"employeed\",\n" +
                        "  \"emp_job_title\": \"Product Owner\"\n" +
                        "}");
        Response response = preparedRequest.when().put("/updateEmployee.php");
        System.out.println("**********************put call********************");
        response.prettyPrint();
        System.out.println("********************** ********************");

    }


}
