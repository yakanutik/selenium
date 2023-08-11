
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static config.WebDriverInit.closeDriver;
import static config.WebDriverInit.getDriver;

public class BaseTest {
    WebDriver driver = null;

    @BeforeMethod
    public void setUp() {
        String baseUrl = "https://en.wikipedia.org/";
        driver = getDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        closeDriver();
    }
}