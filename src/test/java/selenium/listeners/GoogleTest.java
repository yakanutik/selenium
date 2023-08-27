package selenium.listeners;

import selenium.builder.GooglePageBuilder;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static selenium.config.WebDriverInit.closeDriver;
import static selenium.config.WebDriverInit.getDriver;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GoogleTest {
    WebDriver driver = null;

    @BeforeMethod(groups = {"All", "Smoke", "Neg"})
    public void setUp() {
        String baseUrl = "https://google.com/";
        driver = getDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }

    @AfterMethod(groups = {"All", "Smoke", "Neg"})
    public void tearDown() {
        closeDriver();
    }

    @Test(groups = {"Smoke"}, dataProvider = "search")
    public void verifyGoogleSearch(String search) {
        List<String> results = new GooglePageBuilder()
                .withSearch(search)
                .build()
                .clickSearchButton()
                .getSearchResults(search);

        assertThat(results.get(0).toLowerCase())
                .as("Search results should be equal to expected")
                .contains(search.toLowerCase());
    }

    @DataProvider(name = "search")
    public Object[][] getSearch() {
        return new Object[][]{
                {"Ubisoft"},
                {"Apple"},
                {"Dell"},
                {"IBM"},
                {"Intel"},
                {"Adobe"},
                {"Oracle"},
                {"Cisco"},
                {"NVIDIA"}
        };
    }
}
