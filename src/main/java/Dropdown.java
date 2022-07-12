import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Dropdown extends BaseTest{
    @Test
    public void dropdown() {
        driver.get("http://the-internet.herokuapp.com/dropdown");
        Select dropDown = new Select(driver.findElement(By.id("dropdown")));
        assertEquals(dropDown.getOptions().get(0).getText(), "Please select an option", "No such text");
        assertEquals(dropDown.getOptions().get(1).getText(), "Option 1", "No such category 1");
        assertEquals(dropDown.getOptions().get(2).getText(), "Option 2", "No such category 2");
        dropDown.selectByVisibleText("Option 1");
        assertEquals(dropDown.getFirstSelectedOption().getText(), "Option 1", "Option 1 is not selected");
        dropDown.selectByVisibleText("Option 2");
        assertEquals(dropDown.getFirstSelectedOption().getText(), "Option 2", "Option 2 is not selected");
    }
}
