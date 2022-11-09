package Files;

import io.restassured.path.json.JsonPath;

public class reuse {

	public static JsonPath getrawtojson(String respond) {
		
		JsonPath js1=new JsonPath(respond);
		return js1;
	}
	
    public static JsonPath postrawtojson(String respond) {
		
		JsonPath js=new JsonPath(respond);
		return js;
	}

}
