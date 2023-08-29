package ui.selenide;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.selenide.builder.LoginPageBuilder;
import ui.selenide.po.LoginPage;
import ui.selenide.po.SearchPage;

import static com.codeborne.selenide.Selenide.open;
import static org.testng.AssertJUnit.assertEquals;


public class LoginTest {
    private final String validUsername = "Ithillel";
    private final String validPassword = "FDyDet*z^7^E6Bz";

    @Test
    void verifyLogInName() {
        String expected = "Ithillel";

        open("https://en.wikipedia.org/");

        String actual = new SearchPage()
                .clickLogInTab()
                .logInToWiki()
                .getUserName();

        assertEquals("Actual should be equal to expected", expected, actual);
    }

    @Test(dataProvider = "invalidLogin")
    public void verifyErrorMessageLogInPage(String user, String pass, String error) {
        open("https://en.wikipedia.org/");

        new LoginPage().enterClick();

        String actual = new LoginPageBuilder()
                .withUsername(user)
                .withPassword(pass)
                .build()
                .clickLogInButton()
                .getErrorMessage();

        assertEquals("Error message should be equal to expected", error, actual);
    }

    @DataProvider(name = "invalidLogin")
    public Object[][] getInvalidLogin() {
        String errorMessage = "Incorrect username or password entered. Please try again.";
        return new Object[][]{
                {"Lorem Ipsum", validPassword, errorMessage},
                {validUsername, "Lorem Ipsum", errorMessage},
                {"Lorem Ipsum", "Lorem Ipsum", errorMessage}
        };
    }
}
