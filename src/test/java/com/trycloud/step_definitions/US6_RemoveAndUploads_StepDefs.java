package com.trycloud.step_definitions;

import com.trycloud.pages.FilesPage;
import com.trycloud.utilities.BrowserUtils_Gurhans;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class US6_RemoveAndUploads_StepDefs {

    FilesPage filesPage = new FilesPage();


    @Then("Verify that the file is removed from the Favorites sub-module’s table")
    public void verify_that_the_file_is_removed_from_the_favorites_sub_module_s_table() {
        Assert.assertFalse(Driver.getDriver().findElement(By.xpath("(//span[.='"+filesPage.nameOfRandomFile+"'])[1]")).isDisplayed());

        System.out.println("filesPage.nameOfRandomFile = " + filesPage.nameOfRandomFile);
        //*****************************this part isn't working as the filesPage.nameOfRandomFile part returns null instead of the name of the randomly chosen file************************

        System.out.println("Driver.getDriver().findElement(By.xpath(\"(//span[.='\"+filesPage.nameOfRandomFile+\"'])[1]\")).getText() = " + Driver.getDriver().findElement(By.xpath("(//span[.='" + filesPage.nameOfRandomFile+ "'])[4]")).getText());
    }

    @When("the user clicks the add icon on the top")
    public void the_user_clicks_the_add_icon_on_the_top() {
        filesPage.addIcon.click();

    }

    String fileName;
    @When("users uploads file with the {string} option")
    public void users_uploads_file_with_the_upload_file_option(String option) {
        String filePath = "/Users/aykhanguluzade/Desktop/Map_ClassNotes.png";
        filesPage.uploadStart.sendKeys(filePath);
        BrowserUtils_Gurhans.waitFor(5);
        fileName = filePath.substring(filePath.lastIndexOf("/")+1);
       // System.out.println("fileName = " + fileName);

        // Check if upload failed due to Not Enough Space and retry
        try{
            Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            Assert.assertTrue(filesPage.notEnoughSpaceBtn.isDisplayed());
            filesPage.notEnoughSpaceBtn.click();
            BrowserUtils_Gurhans.sleep(1);
            filesPage.uploadStart.sendKeys(filePath);
           // TryCloudUtils.waitTillUploadBarDisappears();
            BrowserUtils_Gurhans.waitFor(3);
        } catch (Exception e){
            Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
           // TryCloudUtils.waitTillUploadBarDisappears();
        }

    }

    @Then("verify the file is displayed on the page")
    public void verify_the_file_is_displayed_on_the_page() {

    Assert.assertTrue(filesPage.uploadedFile(fileName).isDisplayed());

        // Remove uploaded file
        filesPage.clickOnSpecificActionsButton(fileName);
        filesPage.chooseAnOption("Delete file");
        BrowserUtils_Gurhans.waitFor(2);

    }




}
