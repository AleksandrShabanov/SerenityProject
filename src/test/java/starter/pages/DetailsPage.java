package starter.pages;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import starter.framework.LocatorsEnum;
import starter.pojo.Root;

import java.io.IOException;
import java.util.Objects;

@Getter
public class DetailsPage extends PageObject {

    private WebElementFacade downloadLink;
    private WebElementFacade editLink;
    private WebElementFacade deleteLink;
    private Alert alertConfirmDelete;

    @FindBy(xpath = "//textarea[@name='description']")
    private WebElementFacade textAreaDescription;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElementFacade updateButton;
    @FindBy(xpath = "//div[@class='description' and contains(text(), 'Description')]")
    private WebElementFacade descriptionText;
    @FindBy(xpath = "//div[@class='description' and contains(text(), 'Category')]")
    private WebElementFacade categoryText;
    @FindBy(xpath = "//div[@class='description' and contains(text(), 'Author')]")
    private WebElementFacade authorText;
    @FindBy(xpath = "//div[@class='downloads']")
    private WebElementFacade numberOfDownloads;
    @FindBy(xpath = "//div[@class='name']")
    private WebElementFacade titleText;
    @FindBy(xpath = "/html/body/pre")
    private WebElementFacade jsonResponse;

    private String titleOfApp;
    private String descriptionOfApp;
    private String categoryOfApp;
    private String authorOfApp;
    private int numberOfDownloadsOfApp;

    public String getTitleOfApp() { return titleOfApp; }
    public String getDescriptionOfApp() { return descriptionOfApp; }
    public String getCategoryOfApp() { return categoryOfApp; }
    public String getAuthorOfApp() { return authorOfApp; }
    public int getNumberOfDownloadsOfApp() { return numberOfDownloadsOfApp; }

    public DetailsPage getJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        Root root = null;
        DetailsPage detailsPage = new DetailsPage();

        try {
            root = objectMapper.readValue(jsonResponse.getText(), Root.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        detailsPage.titleOfApp = root.getTitle();
        detailsPage.descriptionOfApp = "Description: " + root.getDescription();
        detailsPage.categoryOfApp = "Category: " + root.getCategory().getTitle();
        detailsPage.authorOfApp = "Author: " + root.getAuthor().getName();
        detailsPage.numberOfDownloadsOfApp = root.getNumberOfDownloads() - 1;
        System.out.println("Json method: " + detailsPage);
        return detailsPage;
    }

    public DetailsPage getDetailsPageInfo() {
        DetailsPage detailsPage = new DetailsPage();
        detailsPage.titleOfApp = titleText.getText();
        detailsPage.descriptionOfApp = descriptionText.getText();
        detailsPage.categoryOfApp = categoryText.getText();
        detailsPage.authorOfApp = authorText.getText();
        detailsPage.numberOfDownloadsOfApp = Integer.parseInt(numberOfDownloads.getText().substring(16));
        System.out.println("Details method: " + detailsPage);
        return detailsPage;
    }

    public void downloadFile(String link) {
        downloadLink = element(By.xpath(String.format(LocatorsEnum.BASE_LINK.getText(), link)));
        downloadLink.click();
    }

    public void deleteFile(String link) {
        deleteLink = element(By.xpath(String.format(LocatorsEnum.BASE_LINK.getText(), link)));
        deleteLink.click();
        alertConfirmDelete = getDriver().switchTo().alert();
        alertConfirmDelete.accept();
    }

    public void editFile(String link) {
        editLink = element(By.xpath(String.format(LocatorsEnum.BASE_LINK.getText(), link)));
        editLink.click();
        textAreaDescription.sendKeys(" and My name's Luke");
        updateButton.click();
    }

    public void isEqual(DetailsPage detailsPageInfo, DetailsPage detailsPageJson) {
        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(detailsPageInfo.getTitleOfApp()).isEqualTo(detailsPageJson.getTitleOfApp());
        softAssertions.assertThat(detailsPageInfo.getDescriptionOfApp()).isEqualTo(detailsPageJson.getDescriptionOfApp());
        softAssertions.assertThat(detailsPageInfo.getAuthorOfApp()).isEqualTo(detailsPageJson.getAuthorOfApp());
        softAssertions.assertThat(detailsPageInfo.getCategoryOfApp()).isEqualTo(detailsPageJson.getCategoryOfApp());
        softAssertions.assertThat(detailsPageInfo.getNumberOfDownloadsOfApp()).isEqualTo(detailsPageJson.getNumberOfDownloadsOfApp());
        softAssertions.assertAll();
    }

    @Override
    public String toString() {
        return "DetailsPage{" +
                "title='" + titleOfApp + '\'' +
                ", description='" + descriptionOfApp + '\'' +
                ", category='" + categoryOfApp + '\'' +
                ", author='" + authorOfApp + '\'' +
                ", numberOfDownloads=" + numberOfDownloadsOfApp +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetailsPage that = (DetailsPage) o;
        return numberOfDownloadsOfApp == that.numberOfDownloadsOfApp && Objects.equals(titleOfApp, that.titleOfApp) && Objects.equals(descriptionOfApp, that.descriptionOfApp) && Objects.equals(categoryOfApp, that.categoryOfApp) && Objects.equals(authorOfApp, that.authorOfApp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titleOfApp, descriptionOfApp, categoryOfApp, authorOfApp, numberOfDownloadsOfApp);
    }
}
