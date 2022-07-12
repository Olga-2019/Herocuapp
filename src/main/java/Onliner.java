import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class Onliner extends BaseTest {
    @Test
    public void onliner() {
        driver.get("https://www.onliner.by/");
        driver.findElement(By.cssSelector("input[class='fast-search__input']")).sendKeys("Тостер");
        WebElement iframe = driver.findElement(By.xpath("//iframe[@class='modal-iframe']"));
        driver.switchTo().frame(iframe);
        WebElement firstProduct = driver.findElement(By.id("search-page")).findElement(By.className("product__title-link"));
        String title = firstProduct.getText();
        driver.findElement(By.id("search-page")).findElement(By.cssSelector("input[class='search__input']")).clear();
        driver.findElement(By.id("search-page")).findElement(By.cssSelector("input[class='search__input']")).sendKeys(title);
        driver.findElement(By.className("search__close")).click();
        String searchTitle = driver.findElement(By.xpath("//span[@class='text_match']")).getText();
        assertEquals(searchTitle, title, "The message is incorrect");
    }
}

