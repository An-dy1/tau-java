package alerts;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTests extends BaseTests {

    @Test
    public void testFileUpload() throws InterruptedException {
        var uploadPage = homePage.clickUploadLink();
        uploadPage.uploadFile("/Users/ajohnson1/VML/development/workspaces/qa/tau-java/resources/chromedriver-77");
        var text = uploadPage.getUploadFileTitle();
        Assert.assertEquals(text, "chromedriver-77", "incorrect file");
    }
}
