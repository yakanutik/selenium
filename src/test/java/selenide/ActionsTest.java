package selenide;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import selenide.po.ActionsPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;

public class ActionsTest {

    @Test
    public void checkDoubleAndContextClick() {
        open("https://demoqa.com/buttons");
        webdriver().driver().getWebDriver().manage().window().maximize();
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
}
