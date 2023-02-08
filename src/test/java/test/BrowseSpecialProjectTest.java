package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import page.HomePage;

public class BrowseSpecialProjectTest {
    HomePage homePage = new HomePage();


    @ParameterizedTest
    @CsvSource({"TOUCAN,https://jira-auto.codecool.metastage.net/projects/TOUCAN/summary",
            "JETI,https://jira-auto.codecool.metastage.net/projects/JETI/summary",
            "COALA,https://jira-auto.codecool.metastage.net/projects/COALA/summary"})
    void TryBrowseSpecialProject(String projectName, String projecturl) {
        homePage.browseExistingSpecialProject(projecturl);
        Assertions.assertEquals(projectName, homePage.getProjectKeyText());
    }

    @AfterEach
    public void exitWindow() {
        homePage.quitDriver();
    }

}
