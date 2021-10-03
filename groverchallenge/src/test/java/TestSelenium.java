import com.sun.javafx.runtime.SystemProperties;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class TestSelenium {
    static WebDriver driver;

    @BeforeClass
    public static void initDriver() {
        System.setProperty("webdriver.chrome.driver","src\\test\\Resources\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void openBrowserWithSelenium() {
        driver.get("https://www.google.com/");
        Assert.assertTrue(driver.getTitle().equals("Googles"));
    }

}
