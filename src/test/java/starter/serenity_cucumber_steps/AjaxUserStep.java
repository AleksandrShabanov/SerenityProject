package starter.serenity_cucumber_steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import starter.pages.AjaxPage;
import starter.pages.HeaderPage;

public class AjaxUserStep {

    private HeaderPage headerPage;
    private AjaxPage ajaxPage;

    @Step
    public void goToTheAjaxPage(String link) {
        headerPage.getAjaxPage(link);
    }

    @Step
    public void userEntersData(String x, String y) {
        ajaxPage.typeData(x, y);
    }

    @Step
    public void userClicksButton() {
        ajaxPage.clickSum();
    }

    @Step
    public void checkCorrectResult(String x, String y) {
        ajaxPage.typeData(x, y);
        String sum = ajaxPage.getSum(2, 2);
        Assert.assertEquals(ajaxPage.getCorrectResultField(), "Result is: " + sum);
    }

    @Step
    public void checkIncorrectResult(String incorrectString) {
        Assert.assertEquals(ajaxPage.getIncorrectResultField(), incorrectString);
    }
}
