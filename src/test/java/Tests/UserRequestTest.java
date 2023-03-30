package Tests;

import RequestObject.RequestLogin.RequestLogin;
import RequestObject.RequestMethodType;
import RequestObject.RequestURLType;
import RequestObject.RequestUser.RequestUser;
import ResponseObject.ResponseBodyType;
import ResponseObject.ResponseCodeType;
import ResponseObject.ResponseHelper;
import ShareData.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserRequestTest extends BaseTest {

    @Test(priority = 1)
    public void postUserTest(){
        RequestUser requestUser = new RequestUser.RequestUserBuilder().Name("morpheus").Job("leader").build();
        Response response = requestHelper.performRequest(RequestMethodType.POST_METHOD, BaseURL + RequestURLType.POST_USER, requestUser);

        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_USER, ResponseCodeType.STATUS_201);

    }

    @Test(priority = 2)
    public void putUserTest(){
        RequestUser requestUser = new RequestUser.RequestUserBuilder().Name("morpheus").Job("leader").build();
        Response response = requestHelper.performRequest(RequestMethodType.PUT_METHOD, BaseURL + RequestURLType.PUT_PATCH_DELETE_USER, requestUser);
        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_USER, ResponseCodeType.STATUS_200);

    }
    @Test(priority = 3)
    public void patchUserTest(){
        RequestUser requestUser = new RequestUser.RequestUserBuilder().Name("morpheus").Job("zion resident").build();
        Response response = requestHelper.performRequest(RequestMethodType.PATCH_METHOD, BaseURL + RequestURLType.PUT_PATCH_DELETE_USER, requestUser);
        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_USER, ResponseCodeType.STATUS_200);

    }
    @Test(priority = 4)
    public void deleteUserTest(){
        Response response = requestHelper.performRequest(RequestMethodType.DELETE_METHOD, BaseURL + RequestURLType.PUT_PATCH_DELETE_USER, null);
        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_USER, ResponseCodeType.STATUS_204);

    }




}
