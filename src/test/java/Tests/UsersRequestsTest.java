package Tests;

import RequestObject.RequestMethodType;
import RequestObject.RequestURLType;
import ResponseObject.ResponseBodyType;
import ResponseObject.ResponseHelper;
import ResponseObject.ResponseCodeType;
import ShareData.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class UsersRequestsTest extends BaseTest {

    @Test(priority = 1)
    public void getListUsersTest() {

        Response response = requestHelper.performRequest(RequestMethodType.GET_METHOD, BaseURL + RequestURLType.GET_LIST_USERS, null);
        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_USERS, ResponseCodeType.STATUS_200);
    }

        @Test(priority = 2)
        public void getSingleUserTest(){
            Response response = requestHelper.performRequest(RequestMethodType.GET_METHOD, BaseURL + RequestURLType.GET_SINGLE_USER, null);
            responseHelper = new ResponseHelper(response);
            responseHelper.validateResponseCode(ResponseCodeType.STATUS_200);

        }

        @Test(priority = 3)
        public void getSingleUserNotFound() {

            Response response = requestHelper.performRequest(RequestMethodType.GET_METHOD, BaseURL + RequestURLType.GET_SINGLE_USER_NOT_FOUND, null);
            responseHelper = new ResponseHelper(response);
            responseHelper.validateResponse(ResponseBodyType.RESPONSE_USER, ResponseCodeType.STATUS_404);

        }
        @Test(priority = 4)
        public void getDelayedResponse() {

            Response response = requestHelper.performRequest(RequestMethodType.GET_METHOD, BaseURL + RequestURLType.GET_LIST_USERS, null);
            responseHelper = new ResponseHelper(response);
            responseHelper.validateResponse(ResponseBodyType.RESPONSE_USERS, ResponseCodeType.STATUS_200);

        }

    }

