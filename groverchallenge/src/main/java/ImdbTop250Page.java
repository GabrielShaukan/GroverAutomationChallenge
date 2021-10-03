import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ImdbTop250Page extends BasePage {

    public ImdbTop250Page(WebDriver driver, String url) {
        this.driver = driver;
        this.url = url;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH,using = "//select[@id='lister-sort-by-options']")
    WebElement sortByDropdown;

    @FindBy(how = How.XPATH,using = "//tbody/tr")
    List<WebElement> top250MoviesList;

    @FindBy(how = How.XPATH, using = "//a[normalize-space()='Western']")
    WebElement westernGenreLink;

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


    public List<WebElement> getTop250MoviesList() {
        return top250MoviesList;
    }

    public void selectSortOption(SortingDropDownOptions sortOption) {
        new Select(sortByDropdown).selectByValue(sortOption.getDropDownValue());

    }




}
