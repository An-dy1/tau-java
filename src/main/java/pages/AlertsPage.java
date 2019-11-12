package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {

    private WebDriver driver;
    private By clickForAlert = By.xpath("//button[text()='Click for JS Alert']");
    private By results = By.id("result");
    private By clickJSConfirm = By.xpath("//button[text()='Click for JS Confirm']");
    private By jsPromptButton = By.xpath("//button[text()='Click for JS Prompt']");

    // TODO: why do I have to specify what kind of parameter driver is?
    public AlertsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickForAlertButton() {
        driver.findElement(clickForAlert).click();
    }

    public void alert_clickToAccept() {
        driver.switchTo().alert().accept();
    }

    public String getResult() {
        return driver.findElement(results).getText();
    }

    public void clickJSConfirmButton() {
        driver.findElement(clickJSConfirm).click();
    }

    public String alert_confirmJSText() {
        return driver.switchTo().alert().getText();
    }

    public void alert_clickCancel() {
        driver.switchTo().alert().dismiss();
    }

    public void clickJSPromptButton() {
        driver.findElement(jsPromptButton).click();
    }

    public void alert_sendTextToPrompt(String text) {
        driver.switchTo().alert().sendKeys(text);
    }
}
