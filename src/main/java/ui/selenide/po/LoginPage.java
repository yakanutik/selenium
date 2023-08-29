package ui.selenide.po;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {
    private final SelenideElement userField = $x("//*[@id='wpName1']");
    private final SelenideElement passwordField = $x("//*[@id='wpPassword1']");
    private final SelenideElement logInButton = $x("//*[@id='wpLoginAttempt']");
    private final SelenideElement logInField = $x("//*[@id='pt-login-2']");
    private final SelenideElement errorLogInMessage = $x("//div[@class='cdx-message__content']");

    public SearchPage logInToWiki() {
        String user = "Ithillel";
        String pass = "FDyDet*z^7^E6Bz";

        userField.shouldBe(Condition.visible).sendKeys(user);
        passwordField.shouldBe(Condition.visible).sendKeys(pass);
        logInButton.shouldBe(Condition.visible).click();
        return page(SearchPage.class);
    }

    public LoginPage enterUsername(String username) {
        userField.shouldBe(Condition.visible).sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordField.shouldBe(Condition.visible).sendKeys(password);
        return this;
    }

    public LoginPage enterClick() {
        logInField.shouldBe(Condition.visible).click();
        return this;
    }

    public LoginPage clickLogInButton() {
        logInButton.shouldBe(Condition.visible).click();
        return this;
    }

    public String getErrorMessage() {
        return errorLogInMessage.shouldBe(visible).getText();
    }
}
