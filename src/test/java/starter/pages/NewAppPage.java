package starter.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import starter.framework.LocatorsEnum;
import java.io.File;

public class NewAppPage extends PageObject {

    private WebElement createButton;
    private WebElement addButton;
    @FindBy(tagName = "h1")
    private WebElementFacade titleName;
    @FindBy(xpath = "//input[@name='title']")
    private WebElementFacade titleTextField;
    @FindBy(xpath = "//textarea[@name='description']")
    private WebElementFacade textAreaDescription;
    private File file = new File("src/test/resources/files/Image.png");

    public WebElement getTitleName() {
        return titleName;
    }


    public void createNewApp(String name, String descr) {
        titleTextField.sendKeys(name);
        textAreaDescription.sendKeys(descr);
    }

    public void clickCreateButton(String button) {
        createButton = element(By.xpath(String.format(LocatorsEnum.BASE_BUTTON.getText(), button)));
        createButton.click();
    }

    public void add(String name) {
        addButton = element(By.xpath(String.format(LocatorsEnum.BASE_BUTTON_NAME.getText(), name)));
        addButton.sendKeys(file.getAbsolutePath());
    }
}
