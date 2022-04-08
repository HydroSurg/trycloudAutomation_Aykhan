package com.trycloud.step_definitions;

import com.trycloud.pages.FilesPage;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

public class US8_DeleteFileOrFolder_StepDefs {

    FilesPage filesPage = new FilesPage();

    @Then("Verify the deleted file is displayed on the page.")
    public void verify_the_deleted_file_is_displayed_on_the_page() {
        //how to call the randomly chosen file's name here in order to verify if it is displayed on the page or not
        System.out.println("Driver.getDriver().findElement(By.xpath(\"(//span[.='\" + filesPage.nameOfRandomFile + \"'])[1]\")).getText() = " + Driver.getDriver().findElement(By.xpath("(//span[.='" + filesPage.nameOfRandomFile + "'])[1]")).getText());
        System.out.println("filesPage.nameOfRandomFile = " + filesPage.nameOfRandomFile);
        Assert.assertTrue("" +
                filesPage.nameOfRandomFile+"",Driver.getDriver().findElement(By.xpath("(//span[.='" + filesPage.nameOfRandomFile + "'])[1]")).isDisplayed());
    }


}
