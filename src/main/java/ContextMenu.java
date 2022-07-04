import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v100.page.Page;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.net.URL;

import static org.testng.Assert.*;

public class ContextMenu extends BaseTest {

    @Test
    public void rightClick() {
        driver.get("http://the-internet.herokuapp.com/context_menu");
        WebElement box = driver.findElement(By.id("hot-spot"));
        Actions action = new Actions(driver);
        action.contextClick(box).perform();
        Alert alert = driver.switchTo().alert();
        assertEquals(alert.getText(), "You selected a context menu", "The message is incorrect");
    }
    @Test
    public void closeAlert() {
        driver.get("http://the-internet.herokuapp.com/context_menu");
        WebElement box = driver.findElement(By.id("hot-spot"));
        Actions action = new Actions(driver);
        action.contextClick(box).perform();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.switchTo().parentFrame();
    }

}

