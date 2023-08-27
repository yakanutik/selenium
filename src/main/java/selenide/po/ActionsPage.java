package selenide.po;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class ActionsPage {
    private final SelenideElement doubleClick = $x("//button[@id='doubleClickBtn']");
    private final SelenideElement contextClick = $x("//button[@id='rightClickBtn']");
    private final SelenideElement getDoubleClickText = $x("//p[@id='doubleClickMessage']");
    private final SelenideElement getContextClickText = $x("//p[@id='rightClickMessage']");

    public ActionsPage clickDoubleClick() {
        doubleClick.shouldBe(Condition.visible).doubleClick();
        return page(ActionsPage.class);
    }

    public ActionsPage clickRightClick() {
        contextClick.shouldBe(Condition.visible).contextClick();
        return page(ActionsPage.class);
    }

    public String getDoubleText() {
        return getDoubleClickText.shouldBe(visible).getText();
    }

    public String getRightText() {
        return getContextClickText.shouldBe(visible).getText();
    }
}
