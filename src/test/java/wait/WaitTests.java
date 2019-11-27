package wait;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WaitTests extends BaseTests {

    @Test
    public void testWaitUntilText() {
        var dynamicLoadingPage = homePage.clickDynamicPage();
        var dynamicLoadingExampleOne = dynamicLoadingPage.clickExampleOneLink();
        dynamicLoadingExampleOne.clickStart();
        String dynamicLoadedText = dynamicLoadingExampleOne.getLoadedText();
        Assert.assertEquals(dynamicLoadedText, "Hello World!", "text doesn't match");
    }
}
