package ui.selenide.js;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class JSActions {
    public static void clickJs(SelenideElement element) {
        executeJavaScript("arguments[0].click();", element);
    }
}
