package starter.serenity_cucumber_steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import starter.pages.*;

import java.util.Map;

public class RegistrationUserStep {

    private LoginPage loginPage;
    private RegistrationPage registrationPage;
    private HeaderPage headerPage;
    private MyAppPage myAppPage;
    private NewAppPage newAppPage;
    private BasicPage basicPage;

    @Step
    public void goToRegistrationPage(String link) {
        loginPage.getRegistrationPage(link);
    }

    @Step
    public void enterMultipleData(String field, String data) {
        registrationPage.enterTextData(field, data);
    }

    @Step
    public void userEntersData(Map<String, String> data) {
        for (Map.Entry<String, String> entry : data.entrySet()) {
            registrationPage.enterTextData(entry.getKey(), entry.getValue());
        }
    }

    @Step
    public void setRole(String role) {
        registrationPage.setUserRoleSelector(role);
    }

    @Step
    public void userClicksRegister(String button) {
        registrationPage.clickOnRegister(button);
    }

    @Step
    public void userLogout(String link) {
        basicPage.forceLogout(link);
    }

    @Step
    public void verifyThatUserLogin(String fName, String lName) {
        Assert.assertEquals(headerPage.getWelcomeMessage(), headerPage.getWelcomeUserName(fName, lName));
    }

    @Step
    public void verifyThatTheUserCanSeeTheAppButCannotUploadThem() {
        Assert.assertFalse(headerPage.isElementDisplayed(headerPage.getMyAppLink()));
    }

    @Step
    public void verifyThatTheDeveloperCanOpenThePageToUploadAnApp(String myAppLink, String newAppLink, String string) {
        headerPage.getMyAppPage(myAppLink);
        myAppPage.getNewAppPage(newAppLink);
        Assert.assertEquals(newAppPage.getTitleName().getText(), string);
    }
}
