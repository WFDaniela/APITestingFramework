package ResponseObject;

import ResponseObject.ResponseLogin.ResponseLoginFailed;
import ResponseObject.ResponseLogin.ResponseLoginSuccess;
import ResponseObject.ResponseRegister.ResponseRegisterFailed;
import ResponseObject.ResponseRegister.ResponseRegisterSuccess;
import ResponseObject.ResponseResources.ResponseResourcesSuccess;
import ResponseObject.ResponseUser.ResponsePostUser;
import ResponseObject.ResponseUser.ResponsePutPatchUser;
import ResponseObject.ResponseUsers.ResponseUsersSuccess;
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

    public void validateResponse(String ResponseType, Integer ResponseCode) {
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), ResponseCode);
        ResponseBody body = response.getBody();
        System.out.println(body.asString());

        if (ResponseType.equals(ResponseBodyType.RESPONSE_LOGIN)) {
            switch (ResponseCode) {
                case 200:
                    ResponseLoginSuccess ResponseLoginSuccess = response.getBody().as(ResponseLoginSuccess.class);
                    ResponseLoginSuccess.ValidateResponse();
                    break;
                case 400:
                    ResponseLoginFailed ResponseLoginFailed = response.getBody().as(ResponseObject.ResponseLogin.ResponseLoginFailed.class);
                    ResponseLoginFailed.ValidateResponse();

            }
        }
        if (ResponseType.equals(ResponseBodyType.RESPONSE_REGISTER)) {
            switch (ResponseCode) {
                case 200:
                    ResponseRegisterSuccess ResponseRegisterSuccess = response.getBody().as(ResponseRegisterSuccess.class);
                    ResponseRegisterSuccess.ValidateResponse();
                    break;
                case 400:
                    ResponseRegisterFailed ResponseRegisterFailed = response.getBody().as(ResponseRegisterFailed.class);
                    ResponseRegisterFailed.ValidateResponse();

            }
        }
        if (ResponseType.equals(ResponseBodyType.RESPONSE_RESOURCES)) {
            switch (ResponseCode) {
                case 200:
                    ResponseResourcesSuccess ResponseResourcesSuccess = response.getBody().as(ResponseResourcesSuccess.class);
                    ResponseResourcesSuccess.ValidateResponse();
                    break;
            }
            if (ResponseType.equals(ResponseBodyType.RESPONSE_RESOURCE)) {
                switch (ResponseCode) {
                    case 200:
                        ResponseRegisterSuccess ResponseRegisterSuccess = response.getBody().as(ResponseRegisterSuccess.class);
                        ResponseRegisterSuccess.ValidateResponse();
                        break;
                    case 400:
                        ResponseRegisterFailed ResponseRegisterFailed = response.getBody().as(ResponseRegisterFailed.class);
                        ResponseRegisterFailed.ValidateResponse();

                }
            }

            if (ResponseType.equals(ResponseBodyType.RESPONSE_USER)) {
                switch (ResponseCode) {
                    case 201:
                        ResponsePostUser responsePostUser = response.getBody().as(ResponsePostUser.class);
                        responsePostUser.ValidateResponse();
                        break;
                    case 200:
                        ResponsePutPatchUser responsePutPatchUser = response.getBody().as(ResponsePutPatchUser.class);
                        responsePutPatchUser.ValidateResponse();
                        break;
                    case 204:
                        Assert.assertNotNull(response.getBody());
                        break;
                }
            }
            if (ResponseType.equals(ResponseBodyType.RESPONSE_USERS)) {
                switch (ResponseCode) {
                    case 200:
                        ResponseUsersSuccess responseUsersSuccess = response.getBody().as(ResponseUsersSuccess.class);
                        responseUsersSuccess.ValidateResponse();
                        break;
                    case 404:
                        Assert.assertNotNull(response.getBody());
                        break;
                }
            }

        }
    }

}

