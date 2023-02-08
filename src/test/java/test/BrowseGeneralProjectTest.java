package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import page.HomePage;

public class BrowseGeneralProjectTest {
    HomePage homePage = new HomePage();

    @Test
    public void browseNotExistingProject() {
        homePage.browseNotExistingProject();
        Assertions.assertEquals("You can't view this project", homePage.getProjectOpenErrorMessageText());
    }

    @Test
    public void browseExistingProject() {
        homePage.browseExistingProject();
        Assertions.assertEquals("MTP", homePage.getProjectKeyText());
    }

    @AfterEach
    public void exitWindow() {
        homePage.quitDriver();
    }

}
