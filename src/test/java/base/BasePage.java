package base;

import factory.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasePage {
    @FindBy(id = "login-form-username")
    protected WebElement usernameField;

    @FindBy(id = "login-form-password")
    protected WebElement passwordField;

    @FindBy(id = "login")
    protected WebElement loginButton;

    @FindBy(id = "header-details-user-fullname")
    protected WebElement profilePicture;

    protected WebDriver webdriver;
    protected WebDriverWait webDriverWait;


    public BasePage() {
        this.webdriver = new DriverManager().initializeDriver();
        this.webDriverWait = new WebDriverWait(webdriver, Duration.ofSeconds(15));
        PageFactory.initElements(webdriver, this);
    }


    public void setUSERNAME(String username) {
        usernameField.sendKeys(username);
    }

    public void setPASSWORD(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void waitForProfilePictureIsVisible() {
        profilePicture = webDriverWait.until(ExpectedConditions.visibilityOf(profilePicture));
    }


    public void basicLoginWithCorrectCredentials() {
        setUSERNAME("automation31");
        setPASSWORD("CCAutoTest19.");
        clickLoginButton();
        waitForProfilePictureIsVisible();
    }

    public void quitDriver() {
        webdriver.quit();
    }


}