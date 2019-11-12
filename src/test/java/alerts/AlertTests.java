package alerts;

import base.BaseTests;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class AlertTests extends BaseTests {

    @Test
    public void testAcceptAlert() {
        var alertsPage = homePage.getClickAlertsLink();
        alertsPage.clickForAlertButton();
        alertsPage.alert_clickToAccept();
        Assert.assertEquals(alertsPage.getResult(), "You successfuly clicked an alert", "Results message doesn't match");
    }

    @Test
    public void testGetTextFromAlert() {
        var alertsPage = homePage.getClickAlertsLink();
        alertsPage.clickJSConfirmButton();
        String text = alertsPage.alert_confirmJSText();
        alertsPage.alert_clickCancel();
        Assert.assertEquals(text, "I am a JS Confirm", "Message does not match expected");
    }

    @Test
    public void testSendTextToAlert() {
        var alertsPage = homePage.getClickAlertsLink();
        var text = "Hey Andie";
        alertsPage.clickJSPromptButton();
        alertsPage.alert_sendTextToPrompt(text);
        alertsPage.alert_clickToAccept();
        Assert.assertTrue(alertsPage.getResult().contains(text));
    }
}
