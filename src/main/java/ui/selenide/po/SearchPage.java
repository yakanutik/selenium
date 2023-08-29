package ui.selenide.po;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import ui.selenide.js.JSActions;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;


public class SearchPage {
    private final SelenideElement logInButton = $x("//*[@id='pt-login-2']");
    private final SelenideElement userName = $x("//*[@id='pt-userpage-2']");

    public LoginPage clickLogInTab() {
        logInButton.shouldBe(Condition.visible);
        JSActions.clickJs(logInButton);
        return Selenide.page(LoginPage.class);
    }

    public String getUserName() {
        return userName.shouldBe(visible).getText();
    }
}
