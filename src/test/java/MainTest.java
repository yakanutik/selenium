import org.testng.annotations.Test;
import po.LogInPage;
import po.SearchPage;

import static org.testng.AssertJUnit.assertEquals;

public class MainTest extends BaseTest {

    SearchPage basePage = new SearchPage();
    LogInPage logInPage = new LogInPage();

    @Test
    public void verifyLogInName() {
        String expected = "Ithillel";
        String actual;

        basePage.clickLogInTab();
        logInPage.logInToWiki();
        actual = basePage.getUserName();

        assertEquals("Actual should be equal to expected", expected, actual);
    }
}