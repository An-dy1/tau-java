package keypresses;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Assert.*;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import pages.KeyPressesPage;

public class KeysTests extends BaseTests {

    @Test
    public void verifyKeysMessage() {
        // TODO: why can't I pull this variable out of the Test annotation?
        var keyPressesPagePage = homePage.clickKeyPresses();
        keyPressesPagePage.inputText("Andie!" + Keys.BACK_SPACE);
        assertTrue(keyPressesPagePage.getMessage().contains("BACK_SPACE"), "incorrect success message)");
//        Assert.assertEquals(keyPressesPagePage.getMessage(), "You entered: BACK_SPACE", "incorrect success message");
    }

    @Test
    public void verifyPi() {
        var keyPressesPagePage = homePage.clickKeyPresses();
        keyPressesPagePage.enterPi();
    }
}
