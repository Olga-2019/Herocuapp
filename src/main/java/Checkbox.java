import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class Checkbox extends BaseTest{
    @Test
    public void checkbox() {
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        List<WebElement> elements = driver.findElements(By.cssSelector("[type=checkbox]"));
        WebElement firstCheckBox = elements.get(0);
        WebElement secondCheckBox = elements.get(1);
        assertFalse(firstCheckBox.isSelected(), "The first checkbox should be unchecked");
        assertTrue(secondCheckBox.isSelected(), "The second checkbox should be checked");
        firstCheckBox.click();
        assertTrue(firstCheckBox.isSelected(), "The first checkbox should be checked");
        secondCheckBox.click();
        assertFalse(secondCheckBox.isSelected(), "The second checkbox should be unchecked");
    }
}
