package starter.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import starter.framework.LocatorsEnum;

public class RegistrationPage extends PageObject {

    private WebElementFacade registerButton;
    private WebElementFacade textFiled;
    @FindBy(xpath = "//select[@name='role']")
    private WebElementFacade userRoleSelector;


    public void enterTextData(String fieldName, String text) {
        textFiled = element(By.xpath(String.format(LocatorsEnum.BASE_TEXT_FIELD_NAME.getText(), fieldName)));
        textFiled.sendKeys(text);
    }

    public void setUserRoleSelector(String role) {
        new Select(userRoleSelector).selectByVisibleText(role);
    }

    public void clickOnRegister(String button) {
        registerButton = element(By.xpath(String.format(LocatorsEnum.BASE_BUTTON.getText(), button)));
        registerButton.click();
    }
}
