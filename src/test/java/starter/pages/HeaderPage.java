package starter.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import starter.framework.LocatorsEnum;

public class HeaderPage extends PageObject {

    private WebElementFacade myAppLink;
    private WebElementFacade ajaxLink;
    private WebElementFacade jsLink;
    private WebElementFacade homeLink;

    public String getWelcomeMessage() {
        element(By.cssSelector(".welcome")).waitUntilVisible();
        return element(By.cssSelector(".welcome")).getText();
    }

    public String getWelcomeUserName(String fName, String lName) {
        return "Welcome " + fName + " " + lName;
    }

    public WebElementFacade getMyAppLink() {
        return myAppLink;
    }

    public void getHomePage(String link) {
        homeLink = element(By.xpath(String.format(LocatorsEnum.BASE_LINK.getText(), link)));
    }

    public void getMyAppPage(String link) {
        myAppLink = element(By.xpath(String.format(LocatorsEnum.BASE_LINK.getText(), link)));
        myAppLink.click();
    }

    public void getAjaxPage(String link) {
        ajaxLink = element(By.xpath(String.format(LocatorsEnum.BASE_LINK.getText(), link)));
        ajaxLink.waitUntilEnabled();
        ajaxLink.click();
    }

    public void getJsPage(String link) {
        jsLink = element(By.xpath(String.format(LocatorsEnum.BASE_LINK.getText(), link)));
        jsLink.click();
    }

    public boolean isElementDisplayed(WebElementFacade element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}