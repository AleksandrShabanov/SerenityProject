package starter.steps;

import cucumber.api.java.en.*;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.util.EnvironmentVariables;
import starter.serenity_cucumber_steps.LoginUserStep;

public class LoginStep {
    @Steps
    private LoginUserStep loginUserStep;
    private EnvironmentVariables env;
    private String baseUrl = EnvironmentSpecificConfiguration.from(env)
            .getProperty("webdriver.base.url");
    private String url = "http://admin:admin@selenium-courses.ipa.dataart.net:8081/";

    @Given("type to input with name {string} text: {string}")
    public void enterData(String id, String data) {
        if (!baseUrl.equals(url)) {
            loginUserStep.enterUserData(id, data);
        }
    }

    @When("user clicks on {string} button")
    public void clicksOnLoginButton(String button) {
        if (!baseUrl.equals(url)) {
            loginUserStep.clickOnLoginButton(button);
        }
    }

    @Then("^check valid login using fName '(.*)' and lName '(.*)'$")
    public void checkValidLogin(String fName, String lName) {
        loginUserStep.checkValidLogin(fName, lName);
    }

    @Then("^check invalid login using string '(.*)'$")
    public void checkInvalidLogin(String string) {
        loginUserStep.checkInvalidLogin(string);
    }
}
