package com.trycloud.step_definitions;

import com.trycloud.pages.FilesPage;
import com.trycloud.utilities.BrowserUtils_Gurhans;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class US10_UpdatingSettings_StepDefs {

    FilesPage filesPage = new FilesPage();


    @When("user clicks Settings on the left bottom corner")
    public void user_clicks_settings_on_the_left_bottom_corner() {
        filesPage.settingsButton.click();

    }

    @Then("the user should be able to click any buttons")
    public void the_user_should_be_able_to_click_any_buttons() {
        for (WebElement eachCheckBox : filesPage.checkBoxes) {

            boolean beforeClick = eachCheckBox.isSelected();
            eachCheckBox.click();
            boolean afterClick = eachCheckBox.isSelected();
            Assert.assertNotEquals(!beforeClick, afterClick);

        }
    }


    String beforeStorage, afterStorage;

    @When("user checks the current storage usage")
    public void user_checks_the_current_storage_usage() {
        beforeStorage = filesPage.storageStatus.getText();
        beforeStorage = beforeStorage.substring(0, beforeStorage.indexOf(" "));
    }


    @When("user refresh the page")
    public void user_refresh_the_page() {
        Driver.getDriver().navigate().refresh();
    }

    @Then("the user should be able to see storage usage is increased")
    public void the_user_should_be_able_to_see_storage_usage_is_increased() {
        afterStorage = filesPage.storageStatus.getText();
       afterStorage = afterStorage.substring(0, afterStorage.indexOf(" "));

        System.out.println("beforeStorage = " + beforeStorage);
        System.out.println("afterStorage = " + afterStorage);

        Assert.assertTrue(Double.parseDouble(afterStorage) > Double.parseDouble(beforeStorage));
    }


}
