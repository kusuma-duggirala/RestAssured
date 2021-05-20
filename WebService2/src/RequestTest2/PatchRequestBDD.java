package RequestTest2;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;

public class PatchRequestBDD 
{

	public static void main(String[] args) 
	{
		String jsonString = "{\r\n" + 
				"    \"Justification\" : \"mm\",\r\n" + 
				"    \"ReceiptAmount\" : \"500\"}";
		RestAssured.given().baseUri("https://fuscdrmsmc79-fa-ext.us.oracle.com/fscmRestApi/resources/latest/expenses/300100185944538")
						   .header("Content-Type","application/json")
						   .auth().basic("exmvs.emp1", "Welcome1")
						   .body(jsonString)
						   .when()
						   .patch()
						   .then()
						   .assertThat()
						   .statusCode(200)
						   .body("Justification", Matchers.equalTo("gg"))
						   .body("ReceiptAmount", Matchers.equalTo(50));

	}

}
