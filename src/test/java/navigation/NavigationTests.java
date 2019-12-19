package navigation;

import base.BaseTests;
import org.testng.annotations.Test;

public class NavigationTests extends BaseTests {

    @Test
    public void testNavigator() {
        homePage.clickDynamicPage().clickExampleOneLink();
        getWindowManager().goBack();
        getWindowManager().refresh();
        getWindowManager().goForward();
        getWindowManager().goTo("https://www.nymag.com");
    }

    @Test
    public void testSwitchToTab() {
        homePage.clickNewWindowPage().clickHere();
        getWindowManager().switchToTab("New Window");

    }
}
