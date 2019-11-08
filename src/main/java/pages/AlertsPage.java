package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AlertsPage {

    private WebElement driver;
    private By clickForAlert = By.xpath(".//button[text()='Click for JS Alert'");

    // TODO: why do I have to specify what kind of parameter driver is?
    public AlertsPage(WebElement driver) {
        this.driver = driver;
    }

    public void clickForAlertButton() {
        driver.findElement(clickForAlert).click();
    }

    public void acceptAlert() {

    }
}
