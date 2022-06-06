package starter.serenity_cucumber_steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import starter.pages.*;

public class  LoginUserStep {

    private BasicPage basicPage;
    private LoginPage loginPage;
    private HeaderPage headerPage;

    @Step
    public void enterUserData(String id, String login) {
        loginPage.enterData(id, login);
    }

    @Step
    public void clickOnLoginButton(String button) {
        loginPage.clickLoginButton(button);
    }

    @Step
    public void checkValidLogin(String fName, String lName) {
        Assert.assertEquals(headerPage.getWelcomeMessage(), headerPage.getWelcomeUserName(fName, lName));
    }

    @Step
    public void checkInvalidLogin(String string) {
        Assert.assertEquals(basicPage.getFlashMessage(), string);
    }
}
