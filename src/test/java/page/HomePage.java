package page;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    @FindBy(className = "projects-error-page-heading")
    WebElement projectOpenErrorMessage;

    @FindBy(xpath = "//dd[contains(@class, 'project-meta-value')][2]")
    WebElement projectKey;


    public void waitForProjectOpenErrorMessage() {
        projectOpenErrorMessage = webDriverWait.until(ExpectedConditions.visibilityOf(projectOpenErrorMessage));
    }

    public String getProjectOpenErrorMessageText() {
        return projectOpenErrorMessage.getText();
    }

    public void browseNotExistingProject() {
        basicLoginWithCorrectCredentials();
        webdriver.get("https://jira-auto.codecool.metastage.net/projects/MTP1/summary");
        waitForProjectOpenErrorMessage();
    }

    public void waitForProjectKey() {
        projectKey = webDriverWait.until(ExpectedConditions.visibilityOf(projectKey));
    }

    public String getProjectKeyText() {
        return projectKey.getText();
    }

    public void browseExistingProject() {
        basicLoginWithCorrectCredentials();
        webdriver.get("https://jira-auto.codecool.metastage.net/projects/MTP/summary");
        waitForProjectKey();
    }

    public void browseExistingSpecialProject(String url) {
        basicLoginWithCorrectCredentials();
        webdriver.get(url);
        waitForProjectKey();
    }

}
