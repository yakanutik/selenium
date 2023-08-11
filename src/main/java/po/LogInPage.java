package po;

import base.BaseMethod;
import org.openqa.selenium.By;

public class LogInPage extends BaseMethod {

    private final By userName = By.xpath("//*[@id='wpName1']");
    private final By password = By.xpath("//*[@id='wpPassword1']");
    private final By logInButton = By.xpath("//*[@id='wpLoginAttempt']");

    public void logInToWiki() {
        String user = "Ithillel";
        String pass = "FDyDet*z^7^E6Bz";

        findElementAndSetText(userName, user);
        findElementAndSetText(password, pass);
        click(logInButton);
    }
}