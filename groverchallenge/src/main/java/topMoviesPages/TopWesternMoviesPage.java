package topMoviesPages;

import abstractPage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * @GabrielShaukan
 *
 * This class extends the abstractPage.BasePage and contains Web elements and methods
 * of the "Top Western Movies" page used for the test cases.
 *
 * This Page Object Model design pattern allows modular and dyanmic test
 * cases.
 *
 */

public class TopWesternMoviesPage extends BasePage {

    public TopWesternMoviesPage(WebDriver driver, String url) {
        super(driver,url);

        PageFactory.initElements(driver,this);
    }

    //Defining used web elements
    @FindBy(how = How.XPATH, using = "//div[@class='sorting']/a")
    List<WebElement> sortByOptions;

    @FindBy(how = How.XPATH, using = "(//div[@class='lister-item mode-advanced'])")
    List<WebElement> topWesternMoviesList;

    //Getting the list of top western movies
    public List<WebElement> getTopWesternMoviesList() {
        return topWesternMoviesList;
    }

    //Getting the list of all possible sorting options
    public List<WebElement> getSortByOptions() {
        return sortByOptions;
    }

    //Clicking the sorting option link
    public void clickSortByOption(WebElement sortByOption) {
        sortByOption.click();
    }
}
