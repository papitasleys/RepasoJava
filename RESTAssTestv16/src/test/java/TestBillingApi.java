import org.junit.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import com.jayway.jsonpath.JsonPath;
import static org.junit.Assert.*;


public class TestBillingApi {

    // Get Oauth token
    private String getToken() {

        String url= String.format("https://webapi.segundamano.mx/nga/api/v1.1/private/accounts?lang=es");


        Response resp = given().header("Authorization", "Basic cGFwaXRhc2xleXM5MUBnbWFpbC5jb206Y29udHJhMTIz").post(url);
        String body = resp.getBody().asString();

        //System.out.println(body);
        return JsonPath.read(body, "$.access_token");
    }

    @Test
    public void Test1()
    {

        String account = "10620414";

        RestAssured.baseURI = String.format("https://webapi.segundamano.mx/nga/api/v1.1/private/accounts/%s",  account);

        // Call contracts/active API
        Response response = given().log().all().header("Authorization", "tag:scmcoord.com,2013:api " + getToken()).get("/stats?lang=es");

        String body = response.getBody().asString();

        System.out.println("Body test:" + body);

        //Validaciones
        assertEquals(200,response.getStatusCode());
        assertNotNull(body);
        assertTrue(body.contains("ad_events"));
    }
}

