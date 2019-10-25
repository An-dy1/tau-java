package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    // make a field for the driver
    public WebDriver driver;

    // make constructor that specifies that when you instantiate the class, you must pass in a webdriver
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // private because: encapsulation
    private By formAuthenticationLink = By.linkText("Form Authentication");

    // because this opens a new page: it is custom that if your action changes the page, then you should return a handle to that new page
    // in this case, return a login page object
    public LoginPage clickFormAuth() {
        driver.findElement(formAuthenticationLink).click();
        // every page needs a driver
        return new LoginPage(driver);
    }
}
