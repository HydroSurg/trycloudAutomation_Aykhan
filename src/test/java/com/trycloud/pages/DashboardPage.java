package com.trycloud.pages;

import com.trycloud.utilities.BrowserUtils_Gurhans;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardPage {

    public DashboardPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//ul[@id='appmenu']//span")
    public List<WebElement> allModules;

    public List<String> getActualModules(){
        List<String> actualModules = BrowserUtils_Gurhans.getElementsText(allModules);
        return actualModules;
    }

    public void goToTheModule(String moduleName){
        Driver.getDriver().findElement(By.xpath("(//a[contains(@aria-label,'" + moduleName+"')])[1]")).click();
    }

}
