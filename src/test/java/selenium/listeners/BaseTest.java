package selenium.listeners;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static selenium.config.WebDriverInit.closeDriver;
import static selenium.config.WebDriverInit.getDriver;

public class BaseTest {
    WebDriver driver = null;

    @BeforeMethod(groups = {"All", "Smoke", "Neg"})
    public void setUp() {
        String baseUrl = "https://en.wikipedia.org/";
        driver = getDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }

    @AfterMethod(groups = {"All", "Smoke", "Neg"})
    public void tearDown() {
        closeDriver();
    }
}