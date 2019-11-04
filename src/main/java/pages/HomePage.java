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

    // because this opens a new page: it is custom that if your action changes the page, then you should return a handle to that new page
    // in this case, return a login page object
    public LoginPage clickFormAuth() {
        // if this text needed to be called by two different methods, would remove this hard-coded text into a variable
        clickLink("Form Authentication");
        // every page needs a driver
        return new LoginPage(driver);
    }

    public DropdownPage clickDropdownLink() {
        clickLink("Dropdown");
        return new DropdownPage(driver);
    }

    // private because: encapsulation
    private void clickLink(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }
}
