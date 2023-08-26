package selenium.builder;

import selenium.po.LogInPage;

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

    public LogInPage build() {
        return new LogInPage()
                .enterUsername(user)
                .enterPassword(pass);
    }
}
