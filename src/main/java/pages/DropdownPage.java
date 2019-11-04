package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropdownPage {

    private WebDriver driver;
    private By dropdown = By.id("dropdown");

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectFromDropdown(String option) {
        // don't need to assign to a variable - only using once
        findDropdownElement().selectByVisibleText(option);
    }

    public List<String> getSelectedOptions() {
        // want to return list of strings to test, not list of webelements, because you don't need to interact with webelements within the test
        List<WebElement> selectedElements = findDropdownElement().getAllSelectedOptions();
        // TODO: look at .stream, .map, and lambda! :D
        return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    // helper method to get Select object - needs to be used by both select method and get value method, so put it in its own method
    private Select findDropdownElement() {
        // Select class takes a webelement
        // driver.findElement returns a webelement - huzzah
        return new Select(driver.findElement(dropdown));
    }

}
