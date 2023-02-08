package page;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    @FindBy(id = "view_profile")
    WebElement profileInfo;

    @FindBy(id = "up-d-username")
    WebElement usernameInfo;

    @FindBy(id = "usernameerror")
    WebElement loginErrorMessage;

    @FindBy(id = "log_out")
    WebElement logoutButton;


    @FindBy(xpath = "//*[@id=\"main\"]/div/div/p[1]/strong")
    WebElement logoutMessage;


    public void clickProfilePicture() {
        profilePicture.click();
    }


    public void clickProfileInfo() {
        profileInfo.click();
    }

    public void clickLogOutButton() {
        logoutButton.click();
    }

    public void waitForErrorMessageIsVisible() {
        loginErrorMessage = webDriverWait.until(ExpectedConditions.visibilityOf(loginErrorMessage));
    }

    public void waitLogOutMessage() {
        logoutMessage = webDriverWait.until(ExpectedConditions.visibilityOf(logoutMessage));
    }

    public String getUsernameFromProfileSummaryPage() {
        return usernameInfo.getText();
    }

    public String getLogOutMessageText() {
        return logoutMessage.getText();
    }

    public void loginWithCorrectCredentials() {
        basicLoginWithCorrectCredentials();
        clickProfilePicture();
        clickProfileInfo();
    }

    public void loginWithWrongPassword() {
        setUSERNAME("automation31");
        setPASSWORD("password");
        clickLoginButton();
        waitForErrorMessageIsVisible();
    }

    public void loginWithEmptyCredentials() {
        setUSERNAME("");
        setPASSWORD("");
        clickLoginButton();
        waitForErrorMessageIsVisible();
    }

    public void logOut() {
        basicLoginWithCorrectCredentials();
        clickProfilePicture();
        clickLogOutButton();
        waitLogOutMessage();
    }
}
