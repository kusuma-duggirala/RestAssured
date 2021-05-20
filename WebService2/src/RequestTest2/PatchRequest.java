package RequestTest2;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PatchRequest 
{

	public static void main(String[] args) 
	{
		RestAssured.baseURI="https://fuscdrmsmc79-fa-ext.us.oracle.com/fscmRestApi/resources/latest/expenses/300100185944538";
		RequestSpecification request=RestAssured.given();
		String jsonString = "{\r\n" + 
				"    \"Justification\" : \"gg\",\r\n" + 
				"    \"ReceiptAmount\" : \"50\"}";
		request.body(jsonString);
		request.header("Content-Type","application/json");
		request.auth().basic("exmvs.emp1", "Welcome1");
		Response r=request.put();
		System.out.println(r.getStatusCode());

	}

}
