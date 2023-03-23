package ResponseObject;

import ResponseObject.ResponseLogin.ResponseLoginFailed;
import ResponseObject.ResponseLogin.ResponseLoginSuccess;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;

public class ResponseHelper {

    private Response response;

    public ResponseHelper(Response response) {
        this.response = response;
    }

    public void validateResponseCode(Integer expectedCode){
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), expectedCode);
    }

    public void validateResponse(String ResponseType, Integer ResponseCode){
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), ResponseCode);
        ResponseBody body = response.getBody();
        System.out.println(body.asString());

        if(ResponseType.equals(ResponseBodyType.RESPONSE_LOGIN)){
            switch (ResponseCode){
                case 200:
                    ResponseLoginSuccess ResponseLoginSuccess = response.getBody().as(ResponseLoginSuccess.class);
                    ResponseLoginSuccess.ValidateResponse();
                    break;
                case 400:
                    ResponseLoginFailed ResponseLoginFailed =response.getBody().as(ResponseObject.ResponseLogin.ResponseLoginFailed.class);
                    ResponseLoginFailed.ValidateResponse();

            }
        }
    }



}
