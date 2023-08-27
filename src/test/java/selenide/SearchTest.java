package selenide;

import org.testng.annotations.Test;
import selenide.po.SearchPage;

import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SearchTest {

    @Test
    void verifyLogInName() {
        String expected = "Ithillel";

        open("https://en.wikipedia.org/");

        String actual = new SearchPage()
                .clickLogInTab()
                .logInToWiki()
                .getUserName();

        assertThat(actual)
                .as("Actual should be equal to expected")
                .isEqualTo(expected);
    }
}
