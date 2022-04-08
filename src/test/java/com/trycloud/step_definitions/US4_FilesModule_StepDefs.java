package com.trycloud.step_definitions;

import com.trycloud.pages.BasePage;
import com.trycloud.pages.DashboardPage;
import com.trycloud.pages.FilesModulePage;
import com.trycloud.utilities.BrowserUtils_Gurhans;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class US4_FilesModule_StepDefs {
    DashboardPage dashboardPage = new DashboardPage();
    BasePage basePage = new BasePage();
    FilesModulePage filesModulePage = new FilesModulePage();

    @When("the user clicks the {string} module")
    public void the_user_clicks_the_module(String string) {
        dashboardPage.goToTheModule(string);

    }


    @Then("verify the page title is {string}")
    public void verifyThePageTitleIs(String expectedTitle) {
        Assert.assertEquals(expectedTitle,basePage.actualPageTitle());
    }


    @And("user click the top-left checkbox of the table")
    public void userClickTheTopLeftCheckboxOfTheTable() {

        filesModulePage.topLeftCheckBox.click();
    }

    @Then("verify all the files are selected")
    public void verifyAllTheFilesAreSelected() {

        filesModulePage.verifyAllBoxesChecked(filesModulePage.allCheckBoxes);
    }
}
