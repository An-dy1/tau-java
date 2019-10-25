package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BaseTests {

    private WebDriver driver;

    public void setUp() {

        // Selenium needs to know where the executable file is
        // First argument specifies the property, second specifies location of the executable
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver-77");

        // instantiate webdriver object
        driver = new ChromeDriver();

        // getting url launches browser
        driver.get("https://the-internet.herokuapp.com/");

        // maximize window
        driver.manage().window().maximize();

        // fullscreen:
        // driver.manage().window().fullscreen();

        // specific size:
        // driver.manage().window().setSize(new Dimension(375, 812));

        WebElement shiftingContent = driver.findElement(By.linkText("Shifting Content"));
        shiftingContent.click();

        WebElement exampleOne = driver.findElement(By.linkText("Example 1: Menu Element"));
        exampleOne.click();

        List<WebElement> menuOptions = driver.findElements(By.tagName("li"));
        System.out.println(menuOptions.size());

        // confirm success
        // System.out.println(driver.getTitle());

        // close browser when finished
        driver.quit();
    }

    public static void main(String[] args) {
        BaseTests test = new BaseTests();
        test.setUp();
    }

}
