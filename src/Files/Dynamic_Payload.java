package Files;

public class Dynamic_Payload {

	public static String addbook(String isbn, String aisle) {
		// TODO Auto-generated method stub

		String response="{\r\n"
				+ "\r\n"
				+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
				+ "\"isbn\":\""+isbn+"\",\r\n"
				+ "\"aisle\":\""+aisle+"\",\r\n"
				+ "\"author\":\"John foe\"\r\n"
				+ "}\r\n"
				+ ""; 
		
		return response;
	}

}
