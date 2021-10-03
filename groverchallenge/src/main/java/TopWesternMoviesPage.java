import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TopWesternMoviesPage extends BasePage {

    public TopWesternMoviesPage(WebDriver driver, String url) {
        this.driver = driver;
        this.url = url;

        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.XPATH, using = "//div[@class='sorting']/a")
    List<WebElement> sortByOptions;

    @FindBy(how = How.XPATH, using = "(//div[@class='lister-item mode-advanced'])")
    List<WebElement> topWesternMoviesList;

    public List<WebElement> getTopWesternMoviesList() {
        return topWesternMoviesList;
    }

    public List<WebElement> getSortByOptions() {
        return sortByOptions;
    }

    public void clickSortByOption(WebElement sortByOption) {
        sortByOption.click();
    }
}
