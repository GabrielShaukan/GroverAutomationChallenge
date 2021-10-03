import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImdbTop250PageTests {

    static WebDriver driver;
    private static ImdbTop250Page imdbTopRankPage;

    @BeforeClass
    public static void init() throws Exception {

        System.setProperty("webdriver.chrome.driver","src\\test\\Resources\\chromedriver.exe");
        driver = new ChromeDriver();

        imdbTopRankPage = new ImdbTop250Page(driver, "https://www.imdb.com/chart/top");
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
