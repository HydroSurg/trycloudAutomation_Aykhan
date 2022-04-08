package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FilesModulePage {

    public FilesModulePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//label[@for='select_all_files']")
    public WebElement topLeftCheckBox;


    //td[@class='selection']/input
    //label[contains(@for,'select-files')]
    @FindBy(xpath = "td[@class='selection']/input")
    public List<WebElement> allCheckBoxes;

    public void verifyAllBoxesChecked(List<WebElement> allBoxes){
        for (WebElement eachBox : allBoxes) {
          Assert.assertTrue(eachBox.isSelected());
        }
    }

}
