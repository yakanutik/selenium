package ui.selenium.listeners;

import org.testng.annotations.Test;
import ui.selenium.po.LogInPage;
import ui.selenium.po.SearchPage;

import static org.testng.AssertJUnit.assertEquals;

public class SearchTest extends BaseTest {

    @Test(groups = {"Smoke"})
    public void verifyLogInName() {
        String expected = "Ithillel";

        new SearchPage().clickLogInTab();
        new LogInPage().logInToWiki();
        String actual = new SearchPage().getUserName();

        assertEquals("Actual should be equal to expected", expected, actual);
    }
}