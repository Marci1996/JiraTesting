package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import page.LoginPage;

public class LoginTest {
    LoginPage loginPage = new LoginPage();

    @Test
    public void TryLogInWithCorrectCredentials() {
        loginPage.loginWithCorrectCredentials();
        Assertions.assertEquals("automation31", loginPage.getUsernameFromProfileSummaryPage());
    }

    @Test
    public void TryLogInWithEmptyCredentials() {
        loginPage.loginWithEmptyCredentials();
    }

    @Test
    public void TryLogInWithWrongPassword() {
        loginPage.loginWithWrongPassword();
    }


    @AfterEach
    public void exitWindow() {
        loginPage.quitDriver();
    }

}
