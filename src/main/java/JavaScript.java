import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JavaScript extends BaseTest {

    @Test
    public void javaScript() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://www.onliner.by/");
        js.executeScript("window.scrollTo(0,100)");
        WebElement element = driver.findElement(By.xpath("//a[@class='btn-green-2 btn']"));
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        js.executeScript("window.scrollBy(0,document.body.scrollHeight);", element);
        js.executeScript("window.scrollBy(0,document.body.scrollHeight);", element);
        js.executeScript("window.scrollBy(0,document.body.scrollHeight);", element);
        js.executeScript("window.scrollBy(0,document.body.scrollHeight);", element);
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight);", element);
    }
}