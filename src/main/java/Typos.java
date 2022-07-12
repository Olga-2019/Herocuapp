import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Typos extends BaseTest {
    @Test
    public void typos() {
        driver.get("http://the-internet.herokuapp.com/typos");
        for (int i = 0; i < 10; i++) {
            driver.navigate().refresh();
            String TypoText = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p[2]")).getText();
            assertEquals(TypoText, "Sometimes you'll see a typo, other times you won't.", "The word 'won,t' is misspelled");
        }
    }
}
