package starter.pages;

import lombok.Getter;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import starter.framework.LocatorsEnum;

@Getter
public class HomePage extends PageObject {

    private WebElementFacade detailsLink;
    @FindBy(xpath = "//div[@class=\"popular-app\"]//child::a[@href=\"/app?title=newAppAVS123\"]")
    private WebElementFacade myAppPopular;
    @FindBy(xpath = "//a[@href='/app?title=newAppAVS123']")
    private WebElementFacade newAppDetailsLink;
    @FindBy(xpath = "//div[@class='name' and contains(text(),'newAppAVS')]")
    private WebElementFacade newAppElement;
    @FindBy(xpath = "//div[@class='name' and contains(text(),'newAppWithImage_AVS')]")
    private WebElementFacade newAppWithImage;

    public WebElementFacade getNewAppElement() {
        return newAppElement;
    }
    public WebElementFacade getNewAppWithImage() {
        return newAppWithImage;
    }

    public boolean isMyAppDisplayed(WebElementFacade app) {
        try {
            app.isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void getDetailsPage(String link) {
        detailsLink = element(By.xpath(String.format(LocatorsEnum.BASE_LINK.getText(), link)));
        detailsLink.click();
    }

    public void getNewAppDetailsPage() {
        newAppDetailsLink.click();
    }
}
