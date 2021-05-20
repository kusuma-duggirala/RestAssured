package RequestTest2;

import javax.xml.ws.Response;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class GetData 
{

	public static void main(String[] args) 
	{
		RestAssured.baseURI="https://fuscdrmsmc79-fa-ext.us.oracle.com/fscmRestApi/resources/latest";
		RequestSpecification request=RestAssured.given();
		request.header("Content-Type","application/json");
		request.auth().basic("exmvs.emp4", "Welcome1");
		io.restassured.response.Response response=request.get("/expenseReports?q=ExpenseReportNumber=VS:0113428379");
		//Response response=request.get("/expenseReports?q=ExpenseReportNumber=VS:0113428379");
		System.out.println("Status Code: "+response.getStatusCode());
		System.out.println("Response Body: "+response.getBody().asString());
		System.out.println("items[0].ExpenseReportStatus");
	}

}
