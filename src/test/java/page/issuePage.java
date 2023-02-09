package page;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class issuePage extends BasePage {
    @FindBy(id = "key-val")
    WebElement issueKeyVal;

    @FindBy(xpath = "//div[contains(@class, issue-error)]/h1")
    WebElement issueErrorMessage;


    public void waitForIssueKeyVal() {
        issueKeyVal = webDriverWait.until(ExpectedConditions.visibilityOf(issueKeyVal));
    }

    public String getIssueKeyValText() {
        return issueKeyVal.getText();
    }

    public void browseExistingIssue() {
        basicLoginWithCorrectCredentials();
        webdriver.get("https://jira-auto.codecool.metastage.net/browse/MTP-2363");
        waitForIssueKeyVal();
    }

    public void waitForIssueErrorMessage() {
        issueErrorMessage = webDriverWait.until(ExpectedConditions.visibilityOf(issueErrorMessage));
    }

    public String getIssueErrorMessageText() {
        return issueErrorMessage.getText();
    }


    public void browseNonExistingIssue() {
        basicLoginWithCorrectCredentials();
        webdriver.get("https://jira-auto.codecool.metastage.net/browse/MTP-4793278");
        waitForIssueErrorMessage();
    }

    public void browseSpecialProjectIssue(String projectURL) {
        basicLoginWithCorrectCredentials();
        webdriver.get(projectURL);
        waitForIssueKeyVal();
    }

}
