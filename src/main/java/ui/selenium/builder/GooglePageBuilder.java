package ui.selenium.builder;

import ui.selenium.po.GooglePage;

public class GooglePageBuilder {

    private String search;

    public GooglePageBuilder withSearch(String search) {
        this.search = search;
        return this;
    }

    public GooglePage build() {
        return new GooglePage()
                .enterSearch(search);
    }
}
