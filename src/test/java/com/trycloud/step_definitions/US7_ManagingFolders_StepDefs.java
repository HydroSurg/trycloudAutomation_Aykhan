package com.trycloud.step_definitions;

import com.github.javafaker.Faker;
import com.trycloud.pages.FilesPage;

import io.cucumber.java.en.*;
import org.junit.Assert;


public class US7_ManagingFolders_StepDefs {

    FilesPage filesPage = new FilesPage();
    String folderName;


    @When("user click {string}")
    public void user_click_new_folder(String option) {

        filesPage.clickOnAddFileOptions(option);
    }
    @When("user write a folder name")
    public void user_write_a_folder_name() {
        folderName = new Faker().name().name();
        filesPage.newFolderNameBox.sendKeys(folderName);
    }
    @When("the user click submit icon")
    public void the_user_click_submit_icon() {
        filesPage.newFolderSubmitButton.click();
    }
    @Then("Verify the folder is displayed on the page")
    public void verify_the_folder_is_displayed_on_the_page() {
        Assert.assertTrue(filesPage.uploadedFile(folderName).isDisplayed());
    }

    @And("user choose a folder from the page")
    public void userChooseAFolderFromThePage() {
       filesPage.firstFolder.click();

    }
}
