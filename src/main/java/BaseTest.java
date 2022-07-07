import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    WebDriver driver;
    WebDriverWait wait;
    final By CHECKBOX = By.cssSelector("input[type='checkbox']");
    final By BUTTON_REMOVE = By.cssSelector("[onclick='swapCheckbox()']");
    final By INPUT = By.cssSelector("input[type='text']");
    final By BUTTON_ENABLE = By.cssSelector("[onclick='swapInput()']");

    public By getBUTTON_REMOVE() {
        return BUTTON_REMOVE;
    }

    public boolean CheckboxDisplay() {
        try {
            driver.findElement(CHECKBOX);
            return false;
        } finally {
            return true;
        }
    }


    @BeforeClass
    public void setPathVariable() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        Map<String, String> chromePref = new HashMap<>();
        String downloadFolder = System.getProperty("user.dir");
        chromePref.put("download.default_directory", downloadFolder);
        options.setExperimentalOption("prefs", chromePref);
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("http://the-internet.herokuapp.com/");
        System.out.println();
    }




    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

