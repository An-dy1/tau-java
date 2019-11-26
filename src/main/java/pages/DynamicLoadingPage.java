package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage {

    private WebDriver driver;
    private String linkXpath_Format = ".//a[contains(text(), '%s')]";
    private By linkOne = By.xpath(String.format(linkXpath_Format, "Example 1"));

    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
    }

    public DynamicLoadingExampleOnePage clickExampleOneLink() {
        driver.findElement(linkOne).click();
        return new DynamicLoadingExampleOnePage(driver);
    }
}
