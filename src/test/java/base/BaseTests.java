package base;

import com.google.common.io.Files;
import jdk.jfr.Event;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseTests {

    private EventFiringWebDriver driver;
    // protected so that tests that inherit from this class will have access to the home page (not sure how that works?)
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {

        // Selenium needs to know where the executable file is
        // First argument specifies the property, second specifies location of the executable
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver-78");

        // instantiate webdriver object
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        driver.register(new EventReporter());
        goHome();
        // maximize window
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
        setCookies();
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

    @AfterMethod
    public void recordFailure(ITestResult result) {

        if (ITestResult.FAILURE == result.getStatus()) {
            // first, cast driver to a new Selenium class
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("resources/screenshots/test.png" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
//        options.setHeadless(true);
        return options;
    }

    private void setCookies() {
        Cookie cookie = new Cookie.Builder("TAU", "ABC")
                .domain("http://the-internet.herokuapp.com/").build();
        driver.manage().addCookie(cookie);
    }

    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }

}
