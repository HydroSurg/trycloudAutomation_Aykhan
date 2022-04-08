package com.trycloud.pages;

import com.trycloud.utilities.Driver;

public class BasePage {

    public String actualPageTitle(){
       return Driver.getDriver().getTitle();
    }



}
