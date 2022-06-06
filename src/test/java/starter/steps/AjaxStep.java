package starter.steps;

import cucumber.api.java.en.*;
import net.thucydides.core.annotations.Steps;
import starter.serenity_cucumber_steps.AjaxUserStep;

public class AjaxStep {

    @Steps
    private AjaxUserStep ajaxUserStep;

    @When("user at Home Page clicks on {string} AjaxLink")
    public void userAtHomePageClicksOnAjaxTestPageLink(String ajaxLink) {
        ajaxUserStep.goToTheAjaxPage(ajaxLink);
    }

    @And("user at Ajax Page enters X {string} and Y {string}")
    public void userAtAjaxPageEntersXAndY(String x, String y) {
        ajaxUserStep.userEntersData(x, y);
    }

    @And("user clicks on Sum button")
    public void user_clicks_on_sum_button() {
        ajaxUserStep.userClicksButton();
    }

    @Then("check if the result is correct if X {string} and Y {string}")
    public void checkCorrectResult(String x, String y) {
        ajaxUserStep.checkCorrectResult(x, y);
    }

    @Then("check if incorrect result field equals {string}")
    public void checkIncorrectResult(String incorrectFiled) {
        ajaxUserStep.checkIncorrectResult(incorrectFiled);
    }
}
