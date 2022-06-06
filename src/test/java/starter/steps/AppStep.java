package starter.steps;

import cucumber.api.java.en.*;
import net.thucydides.core.annotations.Steps;
import starter.serenity_cucumber_steps.AppUserStep;

public class AppStep {

    @Steps
    AppUserStep appUserStep;

    @And("at Home Page click on {string}")
    public void clickOnLink(String myAppLink) {
        appUserStep.clickOnLinkOnTheHomePage(myAppLink);
    }

    @And("at My applications page {string}")
    public void clickAddNewApp(String newAppLink) {
        appUserStep.clickOnAddNewApplication(newAppLink);
    }

    @When("create new app with name {string} and description {string}")
    public void createNewAppWithNameAndDescription(String name, String descr) {
        appUserStep.createNewApp(name, descr);
    }

    @And("click on {string}")
    public void clickOnButton(String createButton) {
        appUserStep.clickToCreate(createButton);
    }

    @When("Verify that it is displayed")
    public void verifyThatItIsDisplayed() {
        appUserStep.verifyThatItIsDisplayed();
    }

    @When("at Details Page click on {string} link")
    public void atDetailsPageClickOnLink(String link) {
        appUserStep.clickOnLinkOnTheDetailsPage(link);
    }

    @Then("check the user can download new app")
    public void checkTheUserCanDownloadNewApp() {
        appUserStep.checkTheUserCanDownloadNewApp();
    }

    @And("at Home Page click on {string} link")
    public void atHomePageClickOnLink(String link) {
        appUserStep.clickOnLinkOnTheHomePage(link);
    }

    @And("at Home Page click on details new app link")
    public void atHomePageClickOnDetailsNewAppLink() {
        appUserStep.getNewAppDetails();
    }

    @Then("verify that the changes were applied and we see {string}")
    public void verifyThatTheChangesWereApplied(String string) {
        appUserStep.verifyThatTheChangesWereApplied(string);
    }

    @When("press choose file for add {string}")
    public void pressChooseFileForAdd(String fileType) {
        appUserStep.pressChooseFile(fileType);
    }

    @Then("verify that app was create")
    public void verifyThatAppWasCreate() {
        appUserStep.isAppCreated();
    }

    @Then("confirm text after {string}")
    public void confirmTextOnPage(String string) {
        appUserStep.isDataEqual(string);
    }

    @When("{string} file many times")
    public void downloadFileManyTimes(String string) {
        appUserStep.makeAppPopular(string);
    }

    @Then("verify that my app in popular section")
    public void verifyThatMyAppInPopularSection() {
        appUserStep.verifyThatMyAppPopular();
    }

    @And("click on {string} at Header")
    public void clickOnHomeAtHeader(String link) {
        appUserStep.getHomePage(link);
    }
}
