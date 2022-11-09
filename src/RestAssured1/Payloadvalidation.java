package RestAssured1;

import Files.Payload;
import Files.reuse;
import io.restassured.path.json.JsonPath;

public class Payloadvalidation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JsonPath js=new JsonPath(Payload.plValidation());
		int count=js.getInt("courses.size()");		
		System.out.println(count);
		int totalamount=js.getInt("dashboard.purchaseAmount");
		System.out.println(totalamount);
		String title=js.getString("courses[0].title");
		System.out.println(title);
		
		for(int i=0;i<count;i++) {
			String ctitle=js.getString("courses["+i+"].title");
			int cprice=js.getInt("courses["+i+"].price");
			System.out.println(ctitle+" is "+cprice);
			
		}
		

		for(int i=0;i<count;i++) {
			String ctitle=js.getString("courses["+i+"].title");
			if(ctitle.equalsIgnoreCase("RPA")) {
				int ccopies=js.getInt("courses["+i+"].copies");
				System.out.println(ctitle+" is "+ccopies);	
				break;
				
			}
			
			
		}
		
	}		

}
