package selenide.po;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;
import static selenide.js.JSActions.clickJs;


public class SearchPage {
    private final SelenideElement logInButton = $x("//*[@id='pt-login-2']");
    private final SelenideElement userName = $x("//*[@id='pt-userpage-2']");

    public LoginPage clickLogInTab() {
        logInButton.shouldBe(Condition.visible);
        clickJs(logInButton);
        return page(LoginPage.class);
    }

    public String getUserName() {
        return userName.shouldBe(visible).getText();
    }
}
