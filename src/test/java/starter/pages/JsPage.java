package starter.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JsPage extends PageObject {

    @FindBy(id = "top")
    private WebElementFacade top;
    @FindBy(id = "left")
    private WebElementFacade left;


    public void enterCoordinates() {
        String sTop = (String)evaluateJavascript("return $(\"div.flash\").css(\"top\" );");
        String sLeft = (String)evaluateJavascript("return $(\"div.flash\").css(\"left\" );");

        top.sendKeys(Long.toString(Math.round(Double.parseDouble(sTop.replace("px", "")))));
        left.sendKeys(Long.toString(Math.round(Double.parseDouble(sLeft.replace("px", "")))));
    }

    public void isAlertDisplayed(String alert) {
        evaluateJavascript("process();");
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 2);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert message = getDriver().switchTo().alert();
            if (message.getText().equals(alert)) {
                message.accept();
                System.out.println(message.getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
