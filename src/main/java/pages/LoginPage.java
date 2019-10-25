package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    // TODO: Angie puts her constructor AFTER her fields - why? because they're all private?
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // username, pw and login = 3 fields, 3 methods

    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    // TODO: hadn't seen this sort of css selection before
    private By loginField = By.cssSelector("#login button");

    public void setUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public SecureAreaPage clickLoginButton() {
        driver.findElement(loginField).click();
        return new SecureAreaPage(driver);
    }

}
