package RestAssured1;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import Files.Payload;
import Files.reuse;


public class Basics1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println("ram");
     //post
	RestAssured.baseURI="https://rahulshettyacademy.com";
	String response=given().log().all()
			               .queryParam("key","qaclick123")
			               .header("Content-Type","application/json")
	                       .body(Payload.AddPlace())
	                .when().post("/maps/api/place/add/json")
	                .then().log().all()
	                       .assertThat().statusCode(200)
	                       .body("scope",equalTo("APP"))
	                       .header("Server","Apache/2.4.41 (Ubuntu)")
	                       .extract().response().asString();
   System.out.println("response1"+response);
	                    //JsonPath js=new JsonPath(response);
	                    JsonPath js=reuse.postrawtojson(response);
	                    String placeid=js.get("place_id");
   System.out.println("placeid"+placeid);
   //update
   String expected="70 winter walk, USA";
	given().log().all()
	       .queryParam("key","qaclick123")
	       .header("Content-Type","application/json")
           .body("{\r\n"
    		+ "\"place_id\":\""+placeid+"\",\r\n"
    		+ "\"address\":\""+expected+"\",\r\n"
    		+ "\"key\":\"qaclick123\"\r\n"
    		+ "}\r\n"
    		+ "")
   .when().put("/maps/api/place/update/json")
   .then().assertThat().log().all()
          .statusCode(200)
          .body("msg",equalTo("Address successfully updated"));
	
	//get place
   String getplace=given().log().all()
			               .queryParam("key","qaclick123")
		                   .queryParam("place_id",placeid)
		           	       .header("Content-Type","application/json")
		            .when().get("/maps/api/place/get/json")
	            	.then().log().all()
		                   .assertThat().statusCode(200)
		                   .extract().response().asString();
	System.out.println("response2"+getplace);	
		            JsonPath js1=reuse.getrawtojson(getplace);
		            String actual=js1.getString("address");
	System.out.println("address"+actual);
	                 Assert.assertEquals(actual, expected);
	
	}

}
