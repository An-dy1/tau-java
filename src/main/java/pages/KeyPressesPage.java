package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class KeyPressesPage {
    private WebDriver driver;
    private By inputBox = By.id("target");
    private By result = By.id("result");

    public KeyPressesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputText(String text) {
        driver.findElement(inputBox).sendKeys(text);
    }

    public String getMessage() {
        return driver.findElement(result).getText();
    }

    public void enterPi() {
        inputText(Keys.chord(Keys.ALT, "P") + " = 3.14");
    }
}
