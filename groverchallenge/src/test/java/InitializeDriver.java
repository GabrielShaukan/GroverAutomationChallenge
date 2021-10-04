import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InitializeDriver {

    private static WebDriver driver;

    public static WebDriver startWebDriver(String browserName) {

        if(browserName.toUpperCase().equals("CHROME")) {
            System.setProperty("webdriver.chrome.driver", "src\\test\\Resources\\webdrivers\\chromedriver.exe");
            driver = new ChromeDriver();

        } else if (browserName.toUpperCase().equals("FIREFOX")) {
            System.setProperty("webdriver.gecko.driver", "src\\test\\Resources\\webdrivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browserName.toUpperCase().equals("EDGE")) {
            System.setProperty("webdriver.edge.driver", "src\\test\\Resources\\webdrivers\\msedgedriver.exe");
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        return driver;
    }

}
