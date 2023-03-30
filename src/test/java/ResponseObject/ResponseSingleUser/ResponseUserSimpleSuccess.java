package ResponseObject.ResponseSingleUser;

import ResponseObject.ResponseValidator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.testng.Assert;

import java.util.List;

public class ResponseUserSimpleSuccess implements ResponseValidator {

    @JsonProperty("data")
    private List<UserSimpleData> data;
    @JsonProperty("support")
    private UserSimpleSupport support;

    @Override
    public void ValidateResponse() {

        Assert.assertNotNull(support);
        Assert.assertNotNull(data);
        for(Integer index=0; index< data.size(); index++){
            data.get(index).ValidateResponse();
        }
        support.ValidateResponse();


    }
}
