package Tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterRequestTest {


        @Test
        public void postRegisterSuccessTest(){
        RequestSpecification Request = RestAssured.given();
        Request.header("Content-Type", "application/json");

        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "eve.holt@reqres.in");
        requestBody.put("password", "pistol");
        Request.body(requestBody.toString());

        Response response = Request.post("https://reqres.in/api/register");
        ResponseBody body = response.getBody();
        System.out.println(body.asString());
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void postRegisterUnSuccessfullTest(){
        RequestSpecification Request = RestAssured.given();
        Request.header("Content-Type", "application/json");

        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "sydney@fife");

        Request.body(requestBody.toString());

        Response response = Request.post("https://reqres.in/api/register");
        ResponseBody body = response.getBody();
        System.out.println(body.asString());
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 400);
    }


}
