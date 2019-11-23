package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UploadPage {

    private WebDriver driver;
    private By inputField = By.id("file-upload");
    private By uploadButton = By.id("file-submit");
    private By uploadedFiles = By.id("uploaded-files");

    public UploadPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickUploadButton() {
        driver.findElement(uploadButton).click();
    }

    /**
     * Provides path to file to the form, then clicks upload
     * @param absolutePathToFile The complete path of the file to upload
     */
    public void uploadFile(String absolutePathToFile) throws InterruptedException {
        driver.findElement(inputField).sendKeys(absolutePathToFile);
        Thread.sleep(5000);
        clickUploadButton();
    }

    public String getUploadFileTitle() {
        return driver.findElement(uploadedFiles).getText();
    }
}
