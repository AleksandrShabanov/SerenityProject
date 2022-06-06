package starter.serenity_cucumber_steps;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import starter.pages.*;

public class AppUserStep extends PageObject {

    private HeaderPage headerPage;
    private HomePage homePage;
    private MyAppPage myAppPage;
    private NewAppPage newAppPage;
    private BasicPage basicPage;
    private DetailsPage detailsPage;

    @Step
    public void getNewAppDetails() {
        homePage.getNewAppDetailsPage();
    }

    @Step
    public void getHomePage(String link) {
        headerPage.getHomePage(link);
    }

    @Step
    public void goToTheMyApplications(String link) {
        headerPage.getMyAppPage(link);
    }

    @Step
    public void clickOnAddNewApplication(String link) {
        myAppPage.getNewAppPage(link);
    }

    @Step
    public void createNewApp(String name, String description) {
        newAppPage.createNewApp(name, description);
    }

    @Step
    public void clickToCreate(String button) {
        newAppPage.clickCreateButton(button);
    }

    @Step
    public void verifyThatItIsDisplayed() {
        Assert.assertTrue(headerPage.isElementDisplayed(homePage.getNewAppElement()));
    }

    @Step
    public void clickOnLinkOnTheHomePage(String link) {
        switch (link) {
            case "Details": homePage.getDetailsPage(link);
            break;
            case "My applications": headerPage.getMyAppPage(link);
            break;
        }
    }

    @Step
    public void clickOnLinkOnTheDetailsPage(String link) {
        switch (link) {
            case "Download": detailsPage.downloadFile(link);
            break;
            case "Edit": detailsPage.editFile(link);
            break;
            case "Delete": detailsPage.deleteFile(link);
            break;
        }
    }

    @Step
    public void checkTheUserCanDownloadNewApp() {
        Assert.assertTrue(detailsPage.getJsonResponse().isDisplayed());
    }

    @Step
    public void verifyThatTheChangesWereApplied(String string) {
        Assert.assertEquals(basicPage.getFlashMessage(), string);
    }

    @Step
    public void isDataEqual(String string) {
        DetailsPage detailsPageInfo = detailsPage.getDetailsPageInfo();
        detailsPage.downloadFile(string);
        DetailsPage detailsPageJson = detailsPage.getJson();
        detailsPage.isEqual(detailsPageInfo, detailsPageJson);
    }

    @Step
    public void pressChooseFile(String name) {
        newAppPage.add(name);
    }

    @Step
    public void isAppCreated() {
        Assert.assertTrue(basicPage.isElementDisplayed(homePage.getNewAppWithImage()));
    }

    @Step
    public void makeAppPopular(String string) {
        while (!homePage.isMyAppDisplayed(homePage.getMyAppPopular())) {
            homePage.getNewAppDetailsPage();
            detailsPage.downloadFile(string);
            detailsPage.getDriver().navigate().back();
            detailsPage.getDriver().navigate().refresh();
        }
    }

    @Step
    public void verifyThatMyAppPopular() {
        Assert.assertTrue(homePage.getMyAppPopular().isDisplayed());
    }
}
