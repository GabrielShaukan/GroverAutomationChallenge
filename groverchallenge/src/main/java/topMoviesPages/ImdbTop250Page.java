package topMoviesPages;

import abstractPage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * @GabrielShaukan
 *
 * This class extends the abstractPage.BasePage and contains Web elements and methods
 * of the "top 250 Movies" page used for the test cases.
 *
 * This Page Object Model design pattern allows modular and dyanmic test
 * cases.
 *
 */

public class ImdbTop250Page extends BasePage {

    public ImdbTop250Page(WebDriver driver, String url) {
        super(driver, url);
        PageFactory.initElements(driver, this);
    }

    //Defining used web elements
    @FindBy(how = How.XPATH,using = "//select[@id='lister-sort-by-options']")
    WebElement sortByDropdown;

    @FindBy(how = How.XPATH,using = "//tbody/tr")
    List<WebElement> top250MoviesList;

    @FindBy(how = How.XPATH, using = "//a[normalize-space()='Western']")
    WebElement westernGenreLink;

    //Creating an enum for storing all the "Sort By" drop-down options
    public enum SortingDropDownOptions {
        RANKING("rk:ascending"),
        IMDB_RATING("ir:descending"),
        RELEASE_DATE("us:descending"),
        NUMBER_OF_RATINGS("nv:descending"),
        YOUR_RATING("ur:descending");

        private String sortingDropDownValue;

        SortingDropDownOptions(String value) {
            sortingDropDownValue = value;
        }

        public String getDropDownValue() {
            return sortingDropDownValue;
        }
    }

    //Getting back the list of movies from the site
    public List<WebElement> getTop250MoviesList() {
        return top250MoviesList;
    }

    //Selecting the "Sort By" option based on the enum value created
    public void selectSortOption(SortingDropDownOptions sortOption) {
        new Select(sortByDropdown).selectByValue(sortOption.getDropDownValue());
    }

    //Clicking the link to "Top Western Movies"
    public void clickWesternGenreLink() {
        westernGenreLink.click();
    }





}
