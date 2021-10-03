import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TopWesternMoviesPageTests {
    public static WebDriver driver;
    public static ImdbTop250Page imdbTop250Page;
    public static TopWesternMoviesPage topWesternMoviesPage;

    @BeforeClass
    public static void initializeDriver(){
        System.setProperty("webdriver.chrome.driver","src\\test\\Resources\\chromedriver.exe");
        driver = new ChromeDriver();

        imdbTop250Page = new ImdbTop250Page(driver, "https://www.imdb.com/chart/top");
        imdbTop250Page.openPage();
        imdbTop250Page.clickWesternGenreLink();

        topWesternMoviesPage = new TopWesternMoviesPage(driver, driver.getCurrentUrl());
    }

    @Test
    public  void shouldReturnAtLeastOneMovieForAllSortingOptions() {
        for (int i = 0; i < topWesternMoviesPage.getSortByOptions().size(); i++) {
            topWesternMoviesPage.clickSortByOption(topWesternMoviesPage.getSortByOptions().get(i));
            Assert.assertTrue(topWesternMoviesPage.getTopWesternMoviesList().size() > 0);
        }
    }

}
