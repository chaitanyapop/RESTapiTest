package rest.stepdefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.Validatable;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.ResponseSpecification;
import jsonFileReader.JsonFileReader;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import java.util.HashMap;

import org.testng.Assert;

public class PostRequest {
	public HashMap<String,String> map=new HashMap<String,String>();
	public static Response response;
	public static String name;
	
	 @Given("fetch the data from the json file")
	    public void fetch_the_data_from_the_json_file() throws Throwable {
	        map.put("name",JsonFileReader.reader("postuser","name"));
	        map.put("job",JsonFileReader.reader("postuser","job"));
	        name=JsonFileReader.reader("postuser","name");
	        System.out.println(map);
	    }

	    @When("send post request using json file data")
	    public void send_post_request_using_json_file_data() throws Throwable {
	    	response=
	    	given()
	    	.contentType("application/json")// type of the content
    		.body(map)
    		.when()
    		.post("https://reqres.in/api/users")
    		.then()
    		.statusCode(201)
    		.log().all()
    		.extract().response();
    		
    		
	    	
	       
	    }

	    @Then("validate response")
	    public void validate_response() throws Throwable {
	    	JsonPath jsonPathEvaluator=response.jsonPath();
	    	String name1=jsonPathEvaluator.get("name");
	    	Assert.assertEquals(name,name1);
	    	System.out.println("Response validated");
	    }
}
