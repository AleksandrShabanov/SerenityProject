package starter.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import starter.framework.LocatorsEnum;

public class LoginPage extends PageObject {

    public void enterData(String id, String data) {
        WebElementFacade textField = element(By.xpath(String.format(LocatorsEnum.BASE_TEXT_FIELD_ID.getText(), id)));
        textField.type(data);
    }

    public void clickLoginButton(String button) {
        WebElementFacade loginButton = element(By.xpath(String.format(LocatorsEnum.BASE_BUTTON.getText(), button)));
        loginButton.click();
    }

    public void getRegistrationPage(String link) {
        WebElementFacade registerLink = element(By.xpath(String.format(LocatorsEnum.BASE_LINK.getText(), link)));
        registerLink.click();
    }
}
