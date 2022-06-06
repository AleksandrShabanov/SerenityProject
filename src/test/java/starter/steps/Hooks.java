package starter.steps;

import io.cucumber.java.Before;
import starter.pages.BasicPage;
import starter.pages.LoginPage;

public class Hooks {
    LoginPage loginPage;
    BasicPage basicPage;

    @Before
    public void openLoginPage() {
        loginPage.open();
        loginPage = basicPage.forceLogout("Logout");
    }
}
