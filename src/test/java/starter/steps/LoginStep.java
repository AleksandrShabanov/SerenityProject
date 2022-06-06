package starter.steps;

import cucumber.api.java.en.*;
import net.thucydides.core.annotations.Steps;
import starter.serenity_cucumber_steps.LoginUserStep;

public class LoginStep {
    @Steps
    private LoginUserStep loginUserStep;

    @Given("type to input with name {string} text: {string}")
    public void enterData(String id, String data) {
        loginUserStep.enterUserData(id, data);
    }

    @When("user clicks on {string} button")
    public void clicksOnLoginButton(String button) {
        loginUserStep.clickOnLoginButton(button);
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
