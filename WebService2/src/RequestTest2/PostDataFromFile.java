package RequestTest2;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostDataFromFile 
{

	public static void main(String[] args) throws FileNotFoundException 
	{
		FileReader file=new FileReader("C:\\Users\\kduggira.ORADEV\\eclipse-workspace\\WebService2\\ExpenseItem.json");
		JsonParser parser=new JsonParser();
		Object obj=parser.parse(file);
		//System.out.println(obj);
		JsonObject jo= (JsonObject)obj;
		//System.out.println(jo);
		String body=jo.toString();
		System.out.println(body);
		
		RestAssured.baseURI="https://fuscdrmsmc79-fa-ext.us.oracle.com/fscmRestApi/resources/latest";
		RequestSpecification request=RestAssured.given();
		request.header("Content-Type", "application/json");
		request.auth().basic("exmvs.emp4", "Welcome1");
		request.body(body);
		Response response=request.post("/expenses");
		
		System.out.println("Status Code: "+response.getStatusCode());
		System.out.println("Response Body: "+response.getBody().asString());
		
		

	}

}
