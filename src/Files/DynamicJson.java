package files;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import java.nio.file.Files;

import java.nio.file.Paths;

import io.restassured.RestAssured;

import io.restassured.path.json.JsonPath;

import io.restassured.response.Response;

import files.ReUsableMethods;

import files.payload;

public class DynamicJson {

	@Test(dataProvider = "BooksData")
	public void addBook(String isbn, String aisle) {
		RestAssured.baseURI = "http://216.10.245.166";

		String resp= given().

				header("Content-Type", "application/json").

				body(payload.Addbook(isbn, aisle)).

				when().

				post("/Library/Addbook.php").

				then().assertThat().statusCode(200).

				extract().response().toString();

		JsonPath js = ReUsableMethods.rawToJson(resp);

		String id = js.get("ID");

		System.out.println(id);

		// deleteBOok

	}
	
	@DataProvider(name="BooksData")
	public Object[][]  getData(){

	//array=collection of elements

	//multidimensional array= collection of arrays

	return new Object[][] {{"ojfwty","01633"},{"cwetee","22353"},{"okmfet","13332"}};

	}



}
