package starter.steps;

import cucumber.api.java.en.*;
import net.thucydides.core.annotations.Steps;
import starter.serenity_cucumber_steps.RegistrationUserStep;
import java.util.Map;

public class RegistrationStep {

    @Steps
    RegistrationUserStep registrationUserStep;

    @Given("user is on login page clicks on {string} link")
    public void userClicksOnRegisterLink(String registerLink) {
        registrationUserStep.goToRegistrationPage(registerLink);
    }

    @And("^user enters his data to ([^\"]*) and type([^\"]*)$")
    public void theUserEntersHisDataToTextFieldAndTypeText(String textFiled, String text, Map<String, String> map) {
        registrationUserStep.userEntersData(map);
    }

    @When("set {string} role")
    public void setUserRole(String role) {
        registrationUserStep.setRole(role);
    }

    @When("user clicks on {string}")
    public void userClicksOnRegisterButton(String button) {
        registrationUserStep.userClicksRegister(button);
        System.out.println("user clicks on register button");
    }

    @Then("verify that the user with name {string} and last name {string} is logged in")
    public void verifyThatTheUserIsLoggedIn(String fName, String lName) {
        registrationUserStep.verifyThatUserLogin(fName, lName);
    }

    @When("user {string}")
    public void userLogout(String logout) {
        registrationUserStep.userLogout(logout);
    }

    @Then("click on {string} and {string} and verify upload {string}")
    public void verifyThatTheDeveloperCanOpenThePageToUploadAnApp(String myAppLink, String newAppLink, String string) throws InterruptedException {
        registrationUserStep.verifyThatTheDeveloperCanOpenThePageToUploadAnApp(myAppLink, newAppLink, string);
    }

    @Then("verify that the user can see the app but cannot upload them")
    public void verifyThatTheUserCanSeeTheAppButCannotUploadThem() {
        registrationUserStep.verifyThatTheUserCanSeeTheAppButCannotUploadThem();
    }
}
