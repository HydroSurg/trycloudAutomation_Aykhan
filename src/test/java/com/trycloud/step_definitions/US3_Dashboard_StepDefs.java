package com.trycloud.step_definitions;

import com.trycloud.pages.DashboardPage;
import com.trycloud.pages.LoginPage;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.List;

public class US3_Dashboard_StepDefs {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @When("the users log in with valid credentials")
    public void the_users_log_in_with_valid_credentials() {
        loginPage.login();

    }

    @Then("Verify the user see the following modules:")
    public void verify_the_user_see_the_following_modules(List<String> expectedModules) {

        Assert.assertEquals(expectedModules,dashboardPage.getActualModules());

    }

}
