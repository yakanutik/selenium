import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.AssertJUnit.assertEquals;

public class MainTest {
    public static void main(String[] args) {
        By search = By.xpath("//input[@name='search']");
        By firstHeading = By.xpath("//*[@id='firstHeading']/span");
        By searchButton = By.xpath("//*[@id='searchform']/div/button");
        String expected = "Test";

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://en.wikipedia.org/");
        driver.manage().window().maximize();

        findElementAndSetText(driver, search, expected);
        clickButton(driver, searchButton);

        String actual = getTextFirstElement(driver, firstHeading);

        assertEquals(actual, expected);

        driver.close();
    }

    private static void findElementAndSetText(WebDriver driver, By locator, String search) {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(e -> e.findElement(locator)).sendKeys(search);
    }

    private static void clickButton(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(e -> e.findElement(locator)).click();
    }

    private static String getTextFirstElement(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        return wait.until(e -> e.findElements(locator)).get(0).getText();
    }
}
