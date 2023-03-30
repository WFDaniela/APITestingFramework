package ResponseObject.ResponseSingleUser;

import ResponseObject.ResponseValidator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.testng.Assert;

public class UserSimpleData implements ResponseValidator {
    @JsonProperty("id")
    private Integer Id;
    @JsonProperty("email")
    private String Email;
    @JsonProperty("first_name")
    private Integer FirstName;
    @JsonProperty("last_name")
    private String LastName;
    @JsonProperty("avatar")
    private String Avatar;

    @Override
    public void ValidateResponse() {
        Assert.assertNotNull(Id);
        Assert.assertNotNull(Email);
        Assert.assertNotNull(FirstName);
        Assert.assertNotNull(LastName);
        Assert.assertNotNull(Avatar);


    }
}
