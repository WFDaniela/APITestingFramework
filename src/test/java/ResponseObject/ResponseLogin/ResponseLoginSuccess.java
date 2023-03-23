package ResponseObject.ResponseLogin;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.testng.Assert;

@Getter
public class ResponseLoginSuccess {

    @JsonProperty("token")
    private String Token;


    public void ValidateResponse(){
        Assert.assertNotNull(Token);
    }
}
