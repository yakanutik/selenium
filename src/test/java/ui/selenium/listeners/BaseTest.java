package ui.selenium.listeners;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static ui.selenium.config.WebDriverInit.closeDriver;
import static ui.selenium.config.WebDriverInit.getDriver;

public class BaseTest {
    WebDriver driver = null;

    @BeforeMethod(groups = {"All", "Smoke", "Neg"})
    public void setUp() {
        driver = getDriver();
    }

    @AfterMethod(groups = {"All", "Smoke", "Neg"})
    public void tearDown() {
        closeDriver();
    }
}