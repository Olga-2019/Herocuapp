import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Inputs extends BaseTest {
    @Test
    public void inputs() {
        driver.get("http://the-internet.herokuapp.com/inputs");
        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_UP);
        String upKeyResult = driver.findElement(By.tagName("input")).getAttribute("value");
        assertEquals(upKeyResult, "1");
        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN);
        String downKeyResult = driver.findElement(By.tagName("input")).getAttribute("value");
        assertEquals(downKeyResult, "-3");

        driver.navigate().refresh();
        driver.findElement(By.tagName("input")).sendKeys("www");
        String alphaResult = driver.findElement(By.tagName("input")).getAttribute("value");
        assertEquals(alphaResult, "");

        driver.navigate().refresh();
        driver.findElement(By.tagName("input")).sendKeys("12");
        String numericResult = driver.findElement(By.tagName("input")).getAttribute("value");
        assertEquals(numericResult, "12");
    }
}
