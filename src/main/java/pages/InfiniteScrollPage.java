package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class InfiniteScrollPage {

    private WebDriver driver;
    private By textBlocks = By.className("jscroll-added");

    public InfiniteScrollPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Scrolls until paragraph with specified index is in view
     * @param index is 1-based
     */
    public void scrollToIndex(int index) {
        String script = "window.scrollTo(0, document.body.scrollHeight)";
        var jsExecutor = ((JavascriptExecutor)driver);
        while(getNumberOfParagraphs() < index) {
            jsExecutor.executeScript(script);
        }

    }

    private int getNumberOfParagraphs() {
        return driver.findElements(textBlocks).size();
    }
}
