package com.trycloud.step_definitions;

import com.trycloud.pages.LoginPage;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US1_US2_Login_StepDefs {

    LoginPage loginPage =new LoginPage();

    @Given("user on the login page")
    public void user_on_the_login_page() {
        loginPage.goToLoginPage();
    }

    @When("user use username {string} and passcode {string}")
    public void userUseUsernameAndPasscode(String username, String password) {
        loginPage.usernameBox.sendKeys(username);
        loginPage.passwordBox.sendKeys(password);
    }


    @When("user click the login button")
    public void user_click_the_login_button() {
        loginPage.loginButton.click();
    }
    @Then("verify the user should be at the dashboard page")
    public void verify_the_user_should_be_at_the_dashboard_page() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Dashboard"));
    }


    @When("user enter invalid {string} and {string}")
    public void user_enter_invalid_and(String username, String password) {
       loginPage.usernameBox.sendKeys(username);
       loginPage.passwordBox.sendKeys(password);
    }
    @Then("verify {string} message should be displayed")
    public void verify_message_should_be_displayed(String string) {
        Assert.assertTrue(loginPage.message.isDisplayed());
        Assert.assertEquals(string,loginPage.message.getText());
    }


}
