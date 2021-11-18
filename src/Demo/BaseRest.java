package Demo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import Parameters.Body;
public class BaseRest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
				//Validate Post is working
				
				//given - All the input 
				//when - submit the API methord and resource
				//then - validate the response
				RestAssured.baseURI  = "https://rahulshettyacademy.com";
				String Responce = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
				.body(Body.Bodycall()).when().post("maps/api/place/add/json")
				.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
				.header("Server" , "Apache/2.4.18 (Ubuntu)").extract().asString();
				
				System.out.println(Responce);
				//parse the JSON
				//take string as input and Pase it to Json
				JsonPath js = new JsonPath(Responce);
				//fetch the value with key and store that in string 
				String PlaceID = js.getString("place_id");
				String ValidateAddressPost = "29, side layout, cohen 09" ;
				
				System.out.println(PlaceID);
				System.out.println("POST Completed");
				// PUT Methord
				String ResponcePUT = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
				.body("{\r\n"
						+ "\"place_id\":\""+PlaceID+"\",\r\n"
						+ "\"address\":\"70 winter walk, USA\",\r\n"
						+ "\"key\":\"qaclick123\"\r\n"
						+ "}")
				.when().put("maps/api/place/update/json")
				.then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated")).extract().asString();
				JsonPath jsput = new JsonPath(ResponcePUT);
				String ValidateMsg = jsput.getString("msg");
				Assert.assertEquals("Address successfully updated", ValidateMsg);
				
				System.out.println("PUT Completed");
				
				//GET Method to validate update is done 
				String ResponceGet = given().log().all().queryParam("key", "qaclick123")
				.queryParam("place_id", PlaceID)
				.when().log().all().get("maps/api/place/get/json")
				.then().log().all().assertThat().statusCode(200).extract().asString();
				
				JsonPath jsget = new JsonPath(ResponceGet);
				
				String ValidateAddressinget = jsget.getString("address");
				
				Assert.assertNotEquals("29, side layout, cohen 09", ValidateAddressinget);
				System.out.println("Get Completed");
				
				//DELET ENDPOINT
				String ResponceDelet = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
				.body("{\r\n"
						+ "\r\n"
						+ "    \"place_id\":\""+PlaceID + "\"\r\n"
						+ "}")
				.when().delete("maps/api/place/delete/json")
				.then().log().all().assertThat().statusCode(200).extract().asString();
				JsonPath jsdelet = new JsonPath(ResponceDelet);
				
				String ValidateMSG= jsdelet.getString("status");
				System.out.println(ValidateMSG);
				Assert.assertEquals("OK", ValidateMSG);
				
				System.out.println("Delet Completed");
				
	}

	
}

