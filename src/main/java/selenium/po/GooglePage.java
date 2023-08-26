package selenium.po;

import selenium.base.BaseMethod;
import org.openqa.selenium.By;

import java.util.List;

public class GooglePage extends BaseMethod {

    private String search;
    private final By searchField = By.xpath("//textarea[@id='APjFqb']");
    private final String searchResult = "//*[contains(text(),'%s')][not(preceding-sibling::*)]";

    public GooglePage enterSearch(String text) {
        this.search = text;
        findElementAndSetText(searchField, text);
        return this;
    }

    public GooglePage clickSearchButton() {
        clickEnter(searchField);
        return this;
    }

    public List<String> getSearchResults(String searchText) {
        return getTextFromElements(searchResult(searchText));
    }

    private By searchResult(String searchText) {
        return By.xpath(String.format(searchResult, searchText));
    }
}
