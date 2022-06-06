package starter.steps;

import cucumber.api.java.en.*;
import net.thucydides.core.annotations.Steps;
import starter.serenity_cucumber_steps.JsUserStep;

public class JsStep {

    @Steps
    JsUserStep jsUserStep;

    @When("user at Home Page clicks on {string}")
    public void userAtHomePageClicksOnJsLink(String jsLink) {
        jsUserStep.goToJsPage(jsLink);
    }

    @Then("enter coordinates")
    public void enterCoordinates() {
        jsUserStep.userEntersCoordinate();
    }

    @And("check is {string} displayed")
    public void checkIsAlertDisplayed(String alert) {
        System.out.println("check is Alert displayed");
        jsUserStep.checkIsTextDisplayed(alert);
    }
}
