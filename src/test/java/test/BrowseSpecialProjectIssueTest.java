package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import page.issuePage;

public class BrowseSpecialProjectIssueTest {
    issuePage issuePage = new issuePage();

    @ParameterizedTest
    @CsvSource({"COALA-1, https://jira-auto.codecool.metastage.net/browse/COALA-1",
            "COALA-2,https://jira-auto.codecool.metastage.net/browse/COALA-2",
            "COALA-3,https://jira-auto.codecool.metastage.net/browse/COALA-3"})
    void TryBrowse_COALA_Issues(String issue, String issueURL) {
        issuePage.browseSpecialProjectIssue(issueURL);
        Assertions.assertEquals(issue, issuePage.getIssueKeyValText());
    }

    @ParameterizedTest
    @CsvSource({"TOUCAN-1, https://jira-auto.codecool.metastage.net/browse/TOUCAN-1",
            "TOUCAN-2,https://jira-auto.codecool.metastage.net/browse/TOUCAN-2",
            "TOUCAN-3,https://jira-auto.codecool.metastage.net/browse/TOUCAN-3"})
    void TryBrowse_TOUCAN_Issues(String issue, String issueURL) {
        issuePage.browseSpecialProjectIssue(issueURL);
        Assertions.assertEquals(issue, issuePage.getIssueKeyValText());
    }

    @ParameterizedTest
    @CsvSource({"JETI-1, https://jira-auto.codecool.metastage.net/browse/JETI-1",
            "JETI-2,https://jira-auto.codecool.metastage.net/browse/JETI-2",
            "JETI-3,https://jira-auto.codecool.metastage.net/browse/JETI-3"})
    void TryBrowse_JETI_Issues(String issue, String issueURL) {
        issuePage.browseSpecialProjectIssue(issueURL);
        Assertions.assertEquals(issue, issuePage.getIssueKeyValText());
    }


    @AfterEach
    public void exitWindow() {
        issuePage.quitDriver();
    }


}
