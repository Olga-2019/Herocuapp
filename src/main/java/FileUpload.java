import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUpload extends BaseTest {
    @Test
    public void uploadFile() {

        driver.findElement(By.linkText("File Upload")).click();
        String filePath = System.getProperty("user.dir") + "/src/main/resources/HelloWorld.txt";
        driver.findElement(By.id("file-upload")).sendKeys(filePath);
        driver.findElement(By.id("file-submit")).click();
        Assert.assertEquals(driver.findElement(By.id("uploaded-files")).getText(), "HelloWorld.txt",
                "It isn't file's name");
        driver.navigate().back();
    }
}
//    @Test
//    public void fileUploadTest() {
//        driver.findElement(By.linkText("File Upload")).click();
//        String filePath = System.getProperty("user.dir") + "/src/main/resources/text.txt";
//        driver.findElement(By.id("file-upload")).sendKeys(filePath);
//
//        driver.findElement(By.id("file-submit")).click();
//        driver.navigate().back();
