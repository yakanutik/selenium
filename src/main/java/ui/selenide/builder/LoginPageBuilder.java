package ui.selenide.builder;

import ui.selenide.po.LoginPage;

public class LoginPageBuilder {

    private String user;
    private String pass;

    public LoginPageBuilder withUsername(String username) {
        this.user = username;
        return this;
    }

    public LoginPageBuilder withPassword(String password) {
        this.pass = password;
        return this;
    }

    public LoginPage build() {
        return new LoginPage()
                .enterUsername(user)
                .enterPassword(pass);
    }
}
