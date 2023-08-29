package ui.selenium.po;

import ui.selenium.base.BaseMethod;
import org.openqa.selenium.By;

public class SearchPage extends BaseMethod {
    private final By logInButton = By.xpath("//*[@id='pt-login-2']");
    private final By userName = By.xpath("//*[@id='pt-userpage-2']");

    public String getUserName() {
        return getTextFromElement(userName);
    }

    public void clickLogInTab() {
        click(logInButton);
    }
}
