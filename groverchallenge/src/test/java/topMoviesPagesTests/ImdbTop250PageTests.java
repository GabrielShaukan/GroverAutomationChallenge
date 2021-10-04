package topMoviesPagesTests;

import abstractPageTest.BasePageTest;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import topMoviesPages.ImdbTop250Page;

/**
 * @GabrielShaukan
 *
 * Test cases to validate sorting options on the "Top 250 Movies" Page
 *
 */

public class ImdbTop250PageTests extends BasePageTest {

    private static ImdbTop250Page imdbTop250Page;

    @BeforeClass
    public static void init() throws Exception {

        initDriver();

        imdbTop250Page = new ImdbTop250Page(driver, getConfigValue("url"));
        imdbTop250Page.openPage();
    }

    @Test
    public void shouldReturnAtLeastOneMovieInTop250List() {
        Assert.assertTrue(imdbTop250Page.getTop250MoviesList().size() > 0);
    }

    @Test
    public void shouldReturnAtLeastOneMovieForEachSortOption() {
        for (ImdbTop250Page.SortingDropDownOptions sortByOption: ImdbTop250Page.SortingDropDownOptions.values()) {
            imdbTop250Page.selectSortOption(sortByOption);
            Assert.assertTrue(imdbTop250Page.getTop250MoviesList().size() > 0);
        }
    }
}
