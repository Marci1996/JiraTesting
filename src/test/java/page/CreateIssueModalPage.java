package page;

import base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateIssueModalPage extends BasePage {

    @FindBy(id = "create_link")
    WebElement createButton;

    @FindBy(xpath = "//*[@id='project-field']")
    public WebElement project;

    @FindBy(xpath = "//*[@id='issuetype-field']")
    public WebElement issueType;
    @FindBy(id = "summary")
    WebElement summaryField;

    @FindBy(id = "create-issue-submit")
    WebElement createIssueButton;

    @FindBy(className = "issue-created-key")
    WebElement createIssueConfirmationLink;

    @FindBy(id = "issuetype-field")
    WebElement issueTypeField;

    @FindBy(xpath = "//button[text()=\"Cancel\"]")
    WebElement cancelButton;

    @FindBy(xpath = "//*[@id='aui-flag-container']//a")
    public WebElement newIssueLink;

    public void waitForCreateButton() {
        createButton = webDriverWait.until(ExpectedConditions.visibilityOf(createButton));
    }

    public void clickCreateButton() {
        createButton.click();
    }

    public void clickOnNewIssueLink() {
        webDriverWait.until(ExpectedConditions.visibilityOf(newIssueLink));
        newIssueLink.click();
    }

    public void waitForSummaryField() {
        summaryField = webDriverWait.until(ExpectedConditions.visibilityOf(summaryField));
    }

    public void clickCreateIssueButton() {
        createIssueButton.click();
    }

    public void waitForConfirmationLinkToBeClickable() {
        createIssueConfirmationLink = webDriverWait.until(ExpectedConditions.elementToBeClickable(createIssueConfirmationLink));
    }

    public void clickConfirmationLink() {
        createIssueConfirmationLink.click();
    }

    public void fillUpProjectName(String projectName) {
        webDriverWait.until(ExpectedConditions.visibilityOf(project));
        project.sendKeys(projectName);
        project.sendKeys(Keys.ENTER);
    }

    public void fillUpSummary(String summary) {
        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(this.summaryField));
            this.summaryField.sendKeys(summary);
        } catch (StaleElementReferenceException | ElementNotInteractableException e) {
            webdriver.findElement(By.id("summary")).sendKeys(summary);
        }
    }


    public void fillUpIssueType(String issueType) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(this.issueType));
        this.issueType.click();
        this.issueType.sendKeys(Keys.BACK_SPACE);
        this.issueType.sendKeys(issueType);
        this.issueType.sendKeys(Keys.ENTER);
    }


    public void createIssueToProject() {
        basicLoginWithCorrectCredentials();
        waitForCreateButton();
        clickCreateButton();
        waitForSummaryField();
        fillUpSummary("2023-12-10");
        clickCreateIssueButton();
    }
}
