package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WysiwygPage {

    private WebDriver driver;
    private String editorIframId = "mce_0_ifr";
    private By iframeInput = By.id("tinymce");
    private By indentButton = By.cssSelector("#mceu_12 button");

    public WysiwygPage(WebDriver driver) {
        this.driver = driver;
    }

    private void switchToEditArea() {
        driver.switchTo().frame(editorIframId);
    }

    private void switchToMainArea() {
        driver.switchTo().parentFrame();
    }

    public void clearTextArea() {
        switchToEditArea();
        driver.findElement(iframeInput).clear();
        switchToMainArea();
    }

    public void setTextArea(String textInput) {
        switchToEditArea();
        driver.findElement(iframeInput).sendKeys(textInput);
        switchToMainArea();
    }

    public void clickIndent() {
        driver.findElement(indentButton).click();
    }

    public String getTextFromEditor() {
        switchToEditArea();
        String textFromEditor = driver.findElement(iframeInput).getText();
        switchToMainArea();
        return textFromEditor;
    }
}
