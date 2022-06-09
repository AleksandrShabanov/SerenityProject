package starter.steps;

import io.cucumber.java.Before;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.util.EnvironmentVariables;
import starter.pages.BasicPage;
import starter.pages.LoginPage;

public class Hooks {
    private LoginPage loginPage;
    private BasicPage basicPage;

    private EnvironmentVariables env;
    private String url = "http://admin:admin@selenium-courses.ipa.dataart.net:8081/";


    @Before
    public void openLoginPage() {
        String baseUrl = EnvironmentSpecificConfiguration.from(env)
                        .getProperty("webdriver.base.url");

        loginPage.open();
        if (!baseUrl.equals(url)) {
            loginPage = basicPage.forceLogout("Logout");
        }
    }
}
