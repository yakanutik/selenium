package selenium.listeners;

import selenium.builder.LoginPageBuilder;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import selenium.po.LogInPage;
import selenium.po.SearchPage;

import static org.testng.AssertJUnit.assertEquals;

public class LoginTest extends BaseTest {
    private final String validUsername = "Ithillel";
    private final String validPassword = "FDyDet*z^7^E6Bz";

    @Test(groups = {"Smoke"})
    public void verifyLogInPage() {
        new LogInPage()
                .clickLogIn();

        LogInPage logInPage = new LoginPageBuilder()
                .withUsername(validUsername)
                .withPassword(validPassword)
                .build()
                .enterClick();

        String expected = logInPage.getUser();
        String actual = new SearchPage().getUserName();

        assertEquals("Actual should be equal to expected", expected, actual);
    }

    @Test(groups = {"Neg"}, dataProvider = "invalidLogin")
    public void verifyErrorMessageLogInPage(String user, String pass, String error) {
        new LogInPage()
                .clickLogIn();

        String actual = new LoginPageBuilder()
                .withUsername(user)
                .withPassword(pass)
                .build()
                .enterClick()
                .getErrorMessage();

        assertEquals("Error message should be equal to expected", error, actual);
    }

    @DataProvider(name = "invalidLogin")
    public Object[][] getInvalidLogin() {
        String errorMessage = "Incorrect username or password entered. Please try again.";
        return new Object[][]{
                {"Lorem Ipsum", validPassword, errorMessage},
                {validUsername, "Lorem Ipsum", errorMessage},
                {"Lorem Ipsum", "Lorem Ipsum", errorMessage},
                {validUsername + "%", validPassword, errorMessage},
                {validUsername + "&", validPassword, errorMessage},
                {validUsername + "#", validPassword, errorMessage},
                {validUsername + "@", validPassword, errorMessage},
                {validUsername + "?", validPassword, errorMessage},
        };
    }
}