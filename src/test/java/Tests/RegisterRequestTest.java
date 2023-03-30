package Tests;

import RequestObject.RequestMethodType;
import RequestObject.RequestRegister.RequestRegister;
import RequestObject.RequestURLType;
import ResponseObject.ResponseBodyType;
import ResponseObject.ResponseCodeType;
import ResponseObject.ResponseHelper;
import ShareData.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class RegisterRequestTest extends BaseTest {


        @Test(priority = 1)
        public void postRegisterSuccessTest(){

        RequestRegister RequestSuccess = new RequestRegister.RequestRegisterBuilder().Email("eve.holt@reqres.in").Password("pistol").build();
        Response response = requestHelper.performRequest(RequestMethodType.POST_METHOD, BaseURL+RequestURLType.POST_REGISTER, RequestSuccess);

        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_REGISTER, ResponseCodeType.STATUS_200, null);
        responseHelper.printResponseBody();

    }

    @Test
    public void postRegisterUnSuccessfullTest(){

        RequestRegister RequestFailed = new RequestRegister.RequestRegisterBuilder().Email("sydney@fife").build();
        Response response = requestHelper.performRequest(RequestMethodType.POST_METHOD, BaseURL+RequestURLType.POST_REGISTER, RequestFailed);
        String error = "Missing password";
        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_REGISTER, ResponseCodeType.STATUS_400, error);
        responseHelper.printResponseBody();



    }


}
