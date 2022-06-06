package starter.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class AjaxPage extends PageObject {

    @FindBy(id = "x")
    private WebElementFacade xTextField;
    @FindBy(id = "y")
    private WebElementFacade yTextField;
    @FindBy(id = "calc")
    private WebElementFacade sumButton;
    @FindBy(xpath = "//div[@id='result' and contains(text(),'Result is:')]")
    private WebElementFacade correctResultField;
    @FindBy(xpath = "//div[@id='result' and contains(text(),'Result is: Incorrect')]")
    private WebElementFacade incorrectResultField;


    public String getIncorrectResultField() {
        element(incorrectResultField).waitUntilVisible();
        return incorrectResultField.getText();
    }

    public String getCorrectResultField() {
        element(correctResultField).waitUntilVisible();
        return correctResultField.getText();
    }

    public void typeData(String x, String y) {
        xTextField.type(x);
        yTextField.type(y);
    }

    public void clickSum() {
        sumButton.click();
    }

    public String getSum(double x, double y) {
        double sum = x + y;
        return String.valueOf(sum);
    }
}
