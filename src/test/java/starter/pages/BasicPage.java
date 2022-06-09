package starter.pages;
import freemarker.core.Environment;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.util.EnvironmentVariables;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import starter.framework.LocatorsEnum;
public class BasicPage extends PageObject {
    @FindBy(css = "p.flash")
    private WebElementFacade flash;

    public LoginPage forceLogout(String link) {
        WebElementFacade logoutBy = element(String.format(LocatorsEnum.BASE_LINK.getText(), link));
        if (logoutBy.isPresent()) {
            logoutBy.click();
        }
        return new LoginPage();
    }

    public String getFlashMessage() {
        if (isElementDisplayed(flash)) {
            return flash.getText();
        }
        return null;
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
