package com.trycloud.step_definitions;


import com.trycloud.pages.DashboardPage;
import com.trycloud.pages.FilesPage;
import com.trycloud.utilities.BrowserUtils_Gurhans;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;


public class US5_Favorites_StepDefs {

    DashboardPage dashboardPage = new DashboardPage();
    FilesPage filesPage = new FilesPage();



    @Given("user on the dashboard page")
    public void user_on_the_dashboard_page() {
        Assert.assertEquals("Dashboard - Trycloud",Driver.getDriver().getTitle());
    }

    @When("the user clicks action-icon from any file on the page")
    public void the_user_clicks_action_icon_from_any_file_on_the_page() {


        //if any file is already in  favorites, remove them from favorites
        // if there is no file in favorites move to the next methods
       // filesPage.removeFavorites();


        BrowserUtils_Gurhans.waitFor(2);

        /*
        //generate random number between 1 and the max number of the files to choose one file randomly
        int randomNumber = new Faker().number().numberBetween(1, filesPage.allFiles.size());
        //store the name of the randomly chosen file in a string (we need this for later to verify if the file is added to favorites or not)
        nameOfRandomFile = Driver.getDriver().findElement(By.xpath("(//span[@class='innernametext'])[" + randomNumber + "]")).getText();
        // click on the action button of this randomly selected file
        Driver.getDriver().findElement(By.xpath("(//a[@class='action action-menu permanent'])[" + randomNumber + "]")).click();

         */
        filesPage.chooseRandomFile();



    }

    @When("user choose the {string} option")
    public void user_choose_the_option(String button) {
        // ===THIS PART IS REMOVED=== in previous steps if there were any favorites already on the list,  all favorite files were removed from favorites and then one file was chosen randomly and clicked on three dots near that file
        //and here click on either "Add to favorites" or "remove from favorites" button
        filesPage.chooseOption(button,filesPage.nameOfRandomFile);
        BrowserUtils_Gurhans.waitFor(3);
    }

    @When("user click the {string} sub-module on the left side")
    public void user_click_the_sub_module_on_the_left_side(String subModule) {
        filesPage.goToSubModule(subModule);
        BrowserUtils_Gurhans.waitFor(2);
    }

    @Then("Verify the chosen file is listed on the table")
    public void verify_the_chosen_file_is_listed_on_the_table() {
      //  Assert.assertEquals(nameOfRandomFile,Driver.getDriver().findElement(By.xpath("(//span[.='"+nameOfRandomFile+"'])[4]")).getText());

        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("(//span[.='"+filesPage.nameOfRandomFile+"'])[4]")).isDisplayed());
        BrowserUtils_Gurhans.waitFor(2);


    }
}
