package Tests;

import RequestObject.RequestHelper;
import RequestObject.RequestMethodType;
import RequestObject.RequestURLType;
import ResponseObject.ResponseCodeType;
import ResponseObject.ResponseHelper;
import ShareData.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class ResourceRequestsTest extends BaseTest {



    @Test(priority = 1)
    public void getListResourceTest(){

        Response response = requestHelper.performRequest(RequestMethodType.GET_METHOD, BaseURL + RequestURLType.GET_LIST_RESOURCES, null);

        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponseCode(ResponseCodeType.STATUS_200);
    }

    @Test(priority = 2)
    public void getSingleResource(){

        Response response = requestHelper.performRequest(RequestMethodType.GET_METHOD, BaseURL + RequestURLType.GET_SINGLE_RESOURCE, null);

        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponseCode(ResponseCodeType.STATUS_200);

    }

    @Test(priority = 3)
    public void getResourceNotFound(){

        Response response = requestHelper.performRequest(RequestMethodType.GET_METHOD, BaseURL + RequestURLType.GET_RESOURCE_NOT_FOUND, null);

        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponseCode(ResponseCodeType.STATUS_404);

    }
}
