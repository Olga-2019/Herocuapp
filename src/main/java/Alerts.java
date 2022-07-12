import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class Alerts extends BaseTest {
    @Test
    public void alerts() {
        driver.get("https://demoqa.com/alerts");
        driver.findElement(By.id("alertButton")).click();
        Alert alert = driver.switchTo().alert();
        assertEquals(alert.getText(), "You clicked a button", "The message is incorrect");
        alert.accept();
        driver.findElement(By.id("timerAlertButton")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        assertEquals(alert.getText(), "This alert appeared after 5 seconds", "The message is incorrect");
        alert.accept();
        driver.findElement(By.id("confirmButton")).click();
        assertEquals(alert.getText(), "Do you confirm action?", "The message is incorrect");
        alert.dismiss();
        assertEquals(driver.findElement(By.id("confirmResult")).getText(), "You selected Cancel", "The message is incorrect");
        driver.findElement(By.id("promtButton")).click();
        assertEquals(alert.getText(), "Please enter your name", "The message is incorrect");
        alert.sendKeys("Olga Strukova");
        alert.accept();
        assertEquals(driver.findElement(By.id("promptResult")).getText(), "You entered Olga Strukova", "The message is incorrect");
    }
}

