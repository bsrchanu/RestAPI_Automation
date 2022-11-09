package RestAssured1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Files.Dynamic_Payload;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;

public class Dynamic_Json {
	

		@Test(dataProvider="BooksData")
		public void AddBook(String isbn,String aisle) {
	
		RestAssured.baseURI="http://216.10.245.166";
		String response= given().log().all()
		       .header("Content-Type","application/json")
		       .body(Dynamic_Payload.addbook(isbn,aisle))
		      
		.when().post("Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200).extract().response().toString();
		       
	//	JsonPath js=reuse.postrawtojson(response);	
		JsonPath js=new JsonPath(response);
		String id=js.get("ID");
		System.out.println(id);
		
	}
	
	@DataProvider(name="BooksData")
	public Object[][]  getData(){

	//array=collection of elements

	//multidimensional array= collection of arrays

	return new Object[][] {{"ojfwty","0633"},{"cwetee","2353"},{"okmfet","1332"}};

	}



}
