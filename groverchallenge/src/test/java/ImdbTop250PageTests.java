import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @GabrielShaukan
 *
 * Test cases to validate sorting options on the "Top 250 Movies" Page
 *
 */

public class ImdbTop250PageTests extends BasePageTest {

    private static ImdbTop250Page imdbTopRankPage;

    @BeforeClass
    public static void init() throws Exception {

        initDriver();

        imdbTopRankPage = new ImdbTop250Page(driver, getConfigValue("url"));
        imdbTopRankPage.openPage();
    }

    @Test
    public void shouldReturnAtLeastOneMovieInTop250List() {
        Assert.assertTrue(imdbTopRankPage.getTop250MoviesList().size() > 0);
    }

    @Test
    public void shouldReturnAtLeastOneMovieForEachSortOption() {
        for (ImdbTop250Page.SortingDropDownOptions sortByOption: ImdbTop250Page.SortingDropDownOptions.values()) {
            imdbTopRankPage.selectSortOption(sortByOption);
            Assert.assertTrue(imdbTopRankPage.getTop250MoviesList().size() > 0);
        }
    }
}
