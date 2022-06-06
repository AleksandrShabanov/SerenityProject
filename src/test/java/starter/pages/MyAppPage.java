package starter.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import starter.framework.LocatorsEnum;

public class MyAppPage extends PageObject {

    public void getNewAppPage(String link) {
        WebElementFacade addNewApp = element(By.xpath(String.format(LocatorsEnum.BASE_LINK.getText(), link)));
        addNewApp.click();
    }
}
