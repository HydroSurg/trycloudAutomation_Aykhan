package com.trycloud.pages;

import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public void goToLoginPage(){
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }

    @FindBy(id = "user")
    public WebElement usernameBox;

    @FindBy(id = "password")
    public WebElement passwordBox;

    @FindBy(xpath = "//a[@class='toggle-password']")
    public WebElement showPasswordIcon;

    @FindBy(id = "submit-form")
    public WebElement loginButton;

    @FindBy(id = "lost-password")
    public WebElement forgotPasswordButton;

    @FindBy(xpath = "//a[contains(text(),'Log in with a device')]")
    public WebElement loginWithADeviceButton;

    @FindBy(xpath = "//p[contains(text(),'Wrong username or password')]")
    public WebElement message;

    public void login(){
        usernameBox.sendKeys(ConfigurationReader.getProperty("username1"));
        passwordBox.sendKeys(ConfigurationReader.getProperty("password"));
        loginButton.click();
    }


}
