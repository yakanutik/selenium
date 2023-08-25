import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import po.ActionsPage;

import static config.WebDriverInit.getDriver;
import static org.assertj.core.api.Assertions.assertThat;


public class ActionsTest extends BaseTest {

    @Test
    public void checkDoubleAndContextClick() {
        String baseUrl = "https://demoqa.com/buttons";
        driver = getDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        new ActionsPage()
                .clickDoubleClick()
                .clickRightClick();
        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(new ActionsPage().getDoubleText())
                .as("The text is not visible")
                .isEqualTo("You have done a double click");

        softly.assertThat(new ActionsPage().getRightText())
                .as("The text is not visible")
                .isEqualTo("You have done a right click");

        softly.assertAll();
    }

    @Test
    public void getTextFromNestedFrame() {
        String baseUrl = "https://demoqa.com/nestedframes";
        driver = getDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();

        driver.switchTo().frame(driver.findElement(By.id("frame1")))
                .switchTo().frame(0);

        assertThat(new ActionsPage().getTextFromFrame())
                .as("Selenium located not into frame")
                .isEqualTo("Child Iframe");
    }

    @Test
    public void upLoadFileTest() {
        String baseUrl = "https://demoqa.com/upload-download";
        driver = getDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();

        new ActionsPage()
                .uploadFile("C:\\Project\\selenium\\text.txt");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }


    @Test
    public void getTextFromTable() {
        String baseUrl = "https://demoqa.com/webtables";
        driver = getDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();

        assertThat(new ActionsPage().getTextFromTable(2, 3))
                .as("Text not found")
                .isEqualTo("45");

    }

    @Test
    public void getTextFromTableWithRowsAndColumnsByHeading() {
        String baseUrl = "https://demoqa.com/webtables";
        driver = getDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();

        assertThat(new ActionsPage().getTextFromTable(2, "Age"))
                .as("Text not found")
                .isEqualTo("45");
    }
}