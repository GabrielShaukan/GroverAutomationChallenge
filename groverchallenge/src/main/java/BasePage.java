import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    WebDriver driver;
    String url;

    /*public BasePage(WebDriver driver, String url) {
        this.driver = driver;
        this.url = url;
    }*/

    public WebDriver getDriver() {
        return driver;
    }

    public String getUrl() {
        return url;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //Method to open the browser and navigate to base url
    public void openPage() {
        driver.get(url);
    }

    //Method to open the browser and navigate to input url
    public void openPage(String url) {
        driver.get(url);
    }

    //Method to kill the driver
    public void killDriver() {
        driver.quit();
    }
}
