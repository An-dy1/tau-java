package frames;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WysiwygTest extends BaseTests {

    @Test
    public void testWysiwygInput() {
        var wysiwygPage = homePage.clickWysiwygLink();

        String inputTextOne = "Hello ";
        String inputTextTwo = "World";

        wysiwygPage.clearTextArea();
        wysiwygPage.setTextArea(inputTextOne);
        wysiwygPage.clickIndent();
        wysiwygPage.setTextArea(inputTextTwo);

        String inputText = wysiwygPage.getTextFromEditor();
        Assert.assertEquals(inputText, inputTextOne+inputTextTwo, "text does not match");
    }
}
