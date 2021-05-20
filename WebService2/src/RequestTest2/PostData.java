package RequestTest2;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostData 
{

	public static void main(String[] args) 
	{
		RestAssured.baseURI="https://fuscdrmsmc79-fa-ext.us.oracle.com/fscmRestApi/resources/latest";
		RequestSpecification request=RestAssured.given();
		request.header("Content-Type","application/json");
		request.auth().basic("exmvs.emp4", "Welcome1");

		JSONObject data=new JSONObject();
		data.put("ReceiptDate","2019-10-05");
		data.put("ReceiptAmount","115");
		data.put("ReceiptCurrencyCode","USD");
		data.put("Description","Exact Match Misc");
		data.put("Justification","Exact Match Misc");
		data.put("MerchantName","Peri");
		data.put("Location","United States");
		
		request.body(data.toString());
		Response response=request.post("/expenses");
		
		System.out.println("Status Code: "+response.getStatusCode());
		System.out.println("Response Body: "+response.getBody().asString());

	}

}
