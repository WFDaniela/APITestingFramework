package ResponseObject.ResponseResource;

import ResponseObject.ResponseValidator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.testng.Assert;

import java.util.List;

public class ResponseResourcesSuccess implements ResponseValidator {
    @JsonProperty("page")
    private Integer page;
    @JsonProperty("per_page")
    private Integer per_page;
    @JsonProperty("total")
    private Integer total;
    @JsonProperty("total_pages")
    private Integer totalPages;
    @JsonProperty("data")
    private List<ResourceData> data;
    @JsonProperty("support")
    private ResourceSupport support;

    @Override
    public void ValidateResponse() {
        Assert.assertNotNull(page);
        Assert.assertNotNull(per_page);
        Assert.assertNotNull(total);
        Assert.assertNotNull(support);
        Assert.assertNotNull(totalPages);
        Assert.assertNotNull(data);
        for(Integer index=0; index< data.size(); index++){
            data.get(index).ValidateResponse();
        }
        Assert.assertNotNull(support);
        support.ValidateResponse();


    }
}