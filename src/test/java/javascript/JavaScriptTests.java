package javascript;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.InfiniteScrollPage;

public class JavaScriptTests extends BaseTests {

    @Test
    public void testScrollToView() {
        var deepLargeDomPage = homePage.clickLargeDeep();
        deepLargeDomPage.scrollToTable();
    }

    @Test
    public void testParagraphsScroll() {
        var infiniteScrollPage = homePage.clickInfiniteScroll();
        infiniteScrollPage.scrollToIndex(5);
    }
}
