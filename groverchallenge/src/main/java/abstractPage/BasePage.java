package abstractPage;

import org.openqa.selenium.WebDriver;

/**
 * @GabrielShaukan
 *
 * This an abstract page class which will be inherited by other page classes
 *
 */

public abstract class BasePage {

    protected WebDriver driver;
    protected String url;

    public BasePage(WebDriver driver, String url) {
        this.driver = driver;
        this.url = url;
    }

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

    //Launches browser and navigates to base url
    public void openPage() {
        driver.get(url);
    }

    //Launches browser and navigate to input url
    public void openPage(String url) {
        driver.get(url);
    }

    //Method to kill the driver
    public void killDriver() {
        driver.quit();
    }
}
