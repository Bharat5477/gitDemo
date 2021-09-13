package NestedJSON.APINestOne;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.path.json.JsonPath;

public class GoogleNestOne
{
	public static void main(String[] args) {
		baseURI = "https://rahulshettyacademy.com";
		String res = given().queryParam("key", "qaclick123")
		.header("Content-Type","application/json")
		.body(PayLoad.Place_id.getPlace())
		.when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200)
		.header("server", "Apache/2.4.18 (Ubuntu)")
		.body("scope", equalTo("APP"))
		.extract().response().asString();
		System.out.println(res);
		
		JsonPath js = new JsonPath(res);
		String place_id = js.getString("place_id");
		System.out.println(place_id);
		System.out.println("This is scope " + js.getString("scope"));
		String newAdd = "1001 Dalal Street";
		
		
		given().queryParam("key", "qaclick123")
		.header("Content-Type","application/json")
		.body("{\n"
				+ "\"place_id\":\""+place_id+"\",\n"
				+ "\"address\":\""+newAdd+"\",\n"
				+ "\"key\":\"qaclick123\"\n"
				+ "}\n"
				+ "")
		.when().put("/maps/api/place/update/json")
		.then().assertThat().statusCode(200);
		
//		get Address
		String res_get = given().queryParam("key", "qaclick123")
		.queryParam("place_id", place_id)
		.when().get("/maps/api/place/get/json")
		.then().statusCode(200).extract().response().asString();
		System.out.println("this is res _ get " + res_get);
		
		JsonPath js1 = new JsonPath(res_get);
		System.out.println("this is new address updated --- >>> " + js1.getString("address"));
		
		
	
	}
	
	
	
}
