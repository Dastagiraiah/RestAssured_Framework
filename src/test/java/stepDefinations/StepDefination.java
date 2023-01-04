package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.io.IOException;
import Utils.APIResource;
import Utils.ReqSepcBulider;
import Utils.TestDataPayload;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.builder.ResponseSpecBuilder;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class StepDefination extends ReqSepcBulider {
	ResponseSpecification resSpec;
	RequestSpecification req;
	Response response;
	static String place_id;
	TestDataPayload test = new TestDataPayload();
	@Given("Add place paylod with {string} {string} {string}")
	public void add_place_paylod_with(String Name, String Language, String Address) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		 req = given().spec(requestSpec()).body(test.addDataPayload(Name,Language,Address));
	}

	@When("User calls {string} with https {string}")
	public void user_calls_with_https(String resource, String method ) {
	    // Write code here that turns the phrase above into concrete actions
		APIResource APIre = APIResource.valueOf(resource);
		
		resSpec = new ResponseSpecBuilder().expectStatusCode(200).build();
			System.out.println(APIre.getResource());
		if(method.equalsIgnoreCase("Post"))
			response = req.when().post(APIre.getResource());
		else if(method.equalsIgnoreCase("Get"))
			response = req.when().get(APIre.getResource());
		
				
	}

	@Then("Verify the response is success with status code {int}")
	public void verify_the_response_is_success_with_status_code(int int1) {
	    // Write code here that turns the phrase above into concrete actions
		response.then().spec(resSpec).extract().response();
		
		 System.out.println(response.asString());
	    assertEquals(response.statusCode(),int1);
	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    
	   assertEquals( getJson(response,string),string2);
	}
	@Then("Verify the place_id created map to {string} using {string}")
	public void verify_the_place_id_created_map_to_using(String name, String method) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		 place_id=getJson(response,"place_id");
		req = given().spec(requestSpec()).queryParam("place_id",place_id );
		user_calls_with_https(method, "Get");
		String actualName = getJson(response,"name");
		System.out.println(actualName);
		assertEquals(actualName,name);
	}
	
	@Given("Delete place payload")
	public void delete_place_payload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		req = given().spec(requestSpec()).body(test.deletePlayload(place_id));
	    
	}
	
}
