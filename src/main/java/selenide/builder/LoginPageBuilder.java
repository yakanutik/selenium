package selenide.builder;

import selenide.po.LoginPage;

public class LoginPageBuilder {

    private String user;
    private String pass;

    public selenide.builder.LoginPageBuilder withUsername(String username) {
        this.user = username;
        return this;
    }

    public selenide.builder.LoginPageBuilder withPassword(String password) {
        this.pass = password;
        return this;
    }

    public LoginPage build() {
        return new LoginPage()
                .enterUsername(user)
                .enterPassword(pass);
    }
}
