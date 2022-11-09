package RestAssured1;

import org.testng.Assert;
import org.testng.annotations.Test;

import Files.Payload;
import io.restassured.path.json.JsonPath;

public class Sumofcourses {
	
	@Test
	public void SumOfAllCourses(){
	
		JsonPath js=new JsonPath(Payload.plValidation());
		int purchaseAmount=js.getInt("dashboard.purchaseAmount");
		System.out.println(purchaseAmount);
		
		int soldAmount=0;
		int count=js.getInt("courses.size()");
		System.out.println(count);
		for(int i=0;i<count;i++) {
			int prices=js.getInt("courses("+i+").price");
			System.out.println(prices);
			int copies=js.getInt("courses("+i+").copies");
			System.out.println(copies);
			int amount=prices*copies;
			System.out.println(amount);
			soldAmount+=amount;
			System.out.println(soldAmount);
		}
		Assert.assertEquals(purchaseAmount, soldAmount);
		System.out.println("true");
		
		
	}
	

}
