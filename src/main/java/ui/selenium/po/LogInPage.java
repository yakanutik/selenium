package ui.selenium.po;

import ui.selenium.base.BaseMethod;
import org.openqa.selenium.By;

public class LogInPage extends BaseMethod {

    public String getUser() {
        return user;
    }

    private String user;
    private String pass;
    private final By userField = By.xpath("//*[@id='wpName1']");
    private final By passwordField = By.xpath("//*[@id='wpPassword1']");
    private final By logInButton = By.xpath("//*[@id='wpLoginAttempt']");
    private final By logInField = By.xpath("//*[@id='pt-login-2']");
    private final By errorLogInMessage = By.xpath("//div[@class='cdx-message__content']");

    public LogInPage logInToWiki() {
        String user = "Ithillel";
        String pass = "FDyDet*z^7^E6Bz";

        findElementAndSetText(userField, user);
        findElementAndSetText(passwordField, pass);
        click(logInButton);
        return this;
    }

    public LogInPage clickLogIn() {
        click(logInField);
        return this;
    }

    public LogInPage enterUsername(String username) {
        this.user = username;
        findElementAndSetText(userField, user);
        return this;
    }

    public LogInPage enterPassword(String password) {
        this.pass = password;
        findElementAndSetText(passwordField, pass);
        return this;
    }

    public LogInPage enterClick() {
        click(logInButton);
        return this;
    }

    public String getErrorMessage() {
        return getTextFromElement(errorLogInMessage);
    }
}