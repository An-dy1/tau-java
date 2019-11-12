package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

import java.util.List;

public class BaseTests {

    private WebDriver driver;

    // protected so that tests that inherit from this class will have access to the home page (not sure how that works?)
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {

        // Selenium needs to know where the executable file is
        // First argument specifies the property, second specifies location of the executable
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver-78");

        // instantiate webdriver object
        driver = new ChromeDriver();
        goHome();
        // maximize window
        driver.manage().window().maximize();
        // fullscreen:
        // driver.manage().window().fullscreen();
        // specific size:
        // driver.manage().window().setSize(new Dimension(375, 812));

        homePage = new HomePage(driver);

        /*
         * Remove interactions from test - that stuff belongs in the framework, but isn't needed here
         * Anything like .click()
         */
    }

    @BeforeMethod
    public void goHome() {
        // getting url launches browser
        driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterClass
    public void tearDown() {
        // close browser when finished
        driver.quit();
    }

}
