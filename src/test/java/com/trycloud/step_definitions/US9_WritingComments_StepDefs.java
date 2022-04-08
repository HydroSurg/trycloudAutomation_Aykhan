package com.trycloud.step_definitions;

import com.trycloud.pages.FilesPage;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class US9_WritingComments_StepDefs {

    FilesPage filesPage = new FilesPage();
    String newComment = "This is a comment";

    @When("user write a comment inside the input box")
    public void user_write_a_comment_inside_the_input_box() {
        filesPage.comments.click();
        filesPage.newCommentBox.sendKeys(newComment);

    }
    @When("user click the submit button to post it")
    public void user_click_the_submit_button_to_post_it() {
        filesPage.commentSubmitBtn.click();

    }
    @Then("Verify the comment is displayed in the comment section.")
    public void verify_the_comment_is_displayed_in_the_comment_section() {
        WebElement comment = Driver.getDriver().findElement(By.xpath("//div[.='" + newComment + "']"));
        Assert.assertTrue(comment.isDisplayed());
    }




}
