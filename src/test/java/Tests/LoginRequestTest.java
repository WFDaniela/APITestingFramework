package Tests;

import RequestObject.RequestLogin.RequestLogin;
import RequestObject.RequestMethodType;
import RequestObject.RequestURLType;
import ResponseObject.ResponseBodyType;
import ResponseObject.ResponseCodeType;
import ResponseObject.ResponseHelper;
import ShareData.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class LoginRequestTest extends BaseTest {

    @Test(priority = 1)
    public void postLoginSuccessfullTest(){

        RequestLogin requestLoginSuccess = new RequestLogin.RequestLoginBuilder().Email("eve.holt@reqres.in").Password("cityslicka").build();
        Response response = requestHelper.performRequest(RequestMethodType.POST_METHOD, BaseURL + RequestURLType.POST_LOGIN, requestLoginSuccess);

        responseHelper = new ResponseHelper(response);

        responseHelper.validateResponse(ResponseBodyType.RESPONSE_LOGIN, ResponseCodeType.STATUS_200);

    }

    @Test(priority = 2)
    public void postLoginUnSuccessfulTest(){
        RequestLogin requestLoginFailed = new RequestLogin.RequestLoginBuilder().Email("peter@klaven").build();
        Response response = requestHelper.performRequest(RequestMethodType.POST_METHOD, BaseURL + RequestURLType.POST_LOGIN, requestLoginFailed);
        String error = "Missing password";

        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_LOGIN, ResponseCodeType.STATUS_400, error);
    }



}
