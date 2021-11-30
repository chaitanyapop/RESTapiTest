package rest.stepdefination;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import jsonFileReader.JsonFileReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.Validatable;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
public class GetRequest {
	public static String id;
	public static String first_name;
	public static String last_name;
	public static String email;
	public static Response response;
	
	@Given("^take the necessary information from json file$")
    public void take_the_necessary_information_from_json_file() throws Throwable {
		id=JsonFileReader.reader("getuser","id");
		first_name=JsonFileReader.reader("getuser","first_name");
		last_name=JsonFileReader.reader("getuser","last_name");
		email=JsonFileReader.reader("getuser","email");
        
    }

    @When("^send get request$")
    public void send_get_request() throws Throwable {
    	response=
    	given()
    	.when().get("https://reqres.in/api/users/2")
    	.then().statusCode(200).log().all().extract().response();
        
    }

    @Then("^validate the response with internal json file")
    public void validate_the_response_with_internal_json_file() throws Throwable {
    	//String res=response.asString();
    	//System.out.println(res);
    	JsonPath jsonPathEvaluator=response.jsonPath();
    	
    	int id1=jsonPathEvaluator.get("data.id");
    	//System.out.println(id.getClass().getName());
    	String idmain=Integer.toString(id1);
    	System.out.println(id1);
    	System.out.println(id1);
    	Assert.assertEquals(idmain,id,"correct response");
    	
    	
        
    }
}
