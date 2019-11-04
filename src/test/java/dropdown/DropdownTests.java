package dropdown;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownTests extends BaseTests {

    @Test
    public void testSelectOption() {
        // returns a dropdown page:
        var dropdownPage = homePage.clickDropdownLink();
        String option = "Option 1";
        // returns void:
        dropdownPage.selectFromDropdown(option);
        // returns a list:
        var selectedOptions = dropdownPage.getSelectedOptions();
        // assert two things:
        // 1. that there's only one option selected
        Assert.assertEquals(selectedOptions.size(), 1, "incorrect number of selected options");
        // 2. that the selected item is the one you expect
        Assert.assertTrue(selectedOptions.contains(option), "option not selected");

    }
}
