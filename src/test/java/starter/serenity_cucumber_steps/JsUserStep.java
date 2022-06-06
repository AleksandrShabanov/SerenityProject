package starter.serenity_cucumber_steps;

import net.thucydides.core.annotations.Step;
import starter.pages.HeaderPage;
import starter.pages.JsPage;

public class JsUserStep {

    private HeaderPage headerPage;
    private JsPage jsPage;

    @Step
    public void goToJsPage(String link) {
        headerPage.getJsPage(link);
    }

    @Step
    public void userEntersCoordinate() {
        jsPage.enterCoordinates();
    }

    @Step
    public void checkIsTextDisplayed(String alert) {
        jsPage.isAlertDisplayed(alert);
    }
}
