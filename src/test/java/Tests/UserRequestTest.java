package Tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserRequestTest {

    @Test(priority = 1)
    public void postUserTest(){
        RequestSpecification Request = RestAssured.given();
        Request.header("Content-Type", "application/json");

        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "morpheus");
        requestBody.put("job", "leader");
        Request.body(requestBody.toString());

        Response response = Request.post("https://reqres.in/api/users");
        ResponseBody body = response.getBody();
        System.out.println(body.asString());
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 201);
    }

    @Test(priority = 2)
    public void putUserTest(){
        RequestSpecification Request = RestAssured.given();
        Request.header("Content-Type", "application/json");
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "morpheus");
        requestBody.put("job", "zion resident");


        Response response = Request.put("https://reqres.in/api/users/2");
        ResponseBody body = response.getBody();
        System.out.println(body.asString());
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 200);

    }
    @Test(priority = 3)
    public void patchUserTest(){
        RequestSpecification Request = RestAssured.given();
        Request.header("Content-Type", "application/json");
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "morpheus");
        requestBody.put("job", "zion resident");


        Response response = Request.patch("https://reqres.in/api/users/2");
        ResponseBody body = response.getBody();
        System.out.println(body.asString());
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 200);

    }
    @Test(priority = 4)
    public void deleteUserTest(){
        RequestSpecification Request = RestAssured.given();
        Response response = Request.delete("https://reqres.in/api/users/2");
        ResponseBody body = response.getBody();
        System.out.println(body.asString());
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 204);
    }




}
