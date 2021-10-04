package topMoviesPagesTests;

import abstractPageTest.BasePageTest;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import topMoviesPages.ImdbTop250Page;
import topMoviesPages.TopWesternMoviesPage;

/**
 * @GabrielShaukan
 *
 * Test cases to validate sorting options on the "Top Western Movies" Page
 *
 */

public class TopWesternMoviesPageTests extends BasePageTest {
    public static ImdbTop250Page imdbTop250Page;
    public static TopWesternMoviesPage topWesternMoviesPage;

    @BeforeClass
    public static void initializeDriver(){
        initDriver();

        imdbTop250Page = new ImdbTop250Page(driver, getConfigValue("url"));
        imdbTop250Page.openPage();
        imdbTop250Page.clickWesternGenreLink();

        topWesternMoviesPage = new TopWesternMoviesPage(driver, driver.getCurrentUrl());
    }

    @Test
    public void shouldReturnAtLeastOneMovieInTopWesternMoviesPage() {
        Assert.assertTrue(topWesternMoviesPage.getTopWesternMoviesList().size() > 0);
    }


    @Test
    //using a for loop instead of a while loop due to 'Stale element reference'
    //There are changes to the web elements after collecting them, therefore we have to create elements on the go
    public  void shouldReturnAtLeastOneMovieForAllSortingOptions() {
        for (int i = 0; i < topWesternMoviesPage.getSortByOptions().size(); i++) {
            topWesternMoviesPage.clickSortByOption(topWesternMoviesPage.getSortByOptions().get(i));
            Assert.assertTrue(topWesternMoviesPage.getTopWesternMoviesList().size() > 0);
        }
    }

}
