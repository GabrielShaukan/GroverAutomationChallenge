package abstractPageTest;

import configClasses.InitializeDriver;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public abstract class BasePageTest {
    protected static WebDriver driver;

    protected static final String browserType = getConfigValue("url");

    public static void initDriver() {
        driver = InitializeDriver.startWebDriver(getConfigValue("browser"));
    }

    public static String getConfigValue (String property) {
        Properties prop = new Properties();
        String fileName = "src\\test\\resources\\test.conf";
        try {
            FileInputStream fis = new FileInputStream(fileName);
            prop.load(fis);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return prop.getProperty(property);
    }


    @AfterClass
    public static void killDriver() throws Exception {
        driver.quit();
    }

}
