import org.testng.annotations.Test;
import po.LogInPage;
import po.SearchPage;

import static org.testng.AssertJUnit.assertEquals;

public class SearchTest extends BaseTest {

    @Test(groups = {"Smoke"})
    public void verifyLogInName() {
        String expected = "Ithillel";
        String actual;

        new SearchPage().clickLogInTab();
        new LogInPage().logInToWiki();
        actual = new SearchPage().getUserName();

        assertEquals("Actual should be equal to expected", expected, actual);
    }
}