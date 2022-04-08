package com.trycloud.pages;

import com.github.javafaker.Faker;
import com.trycloud.utilities.BrowserUtils_Gurhans;
import com.trycloud.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FilesPage {

    public FilesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }



    @FindBy(xpath = "(//a[@class='action action-menu permanent'])[1]")
    public WebElement actionsButton;

    public void clickOnSpecificActionsButton(String fileName){
        Driver.getDriver().findElement(By.xpath("//tr[contains(@data-file,'"+fileName+"')]//span[.='Actions']/..")).click();
    }

    @FindBy(xpath = "//span[@class='icon icon-starred']")
    public List<WebElement> allFavorites;

    @FindBy(xpath = "//span[@class='innernametext']")
    public List<WebElement> allFiles;

    @FindBy(xpath = "//a//span[.='Remove from favorites']")
    public WebElement removeFromFavoritesButton;

    @FindBy(xpath = "//span[.='Add to favorites']/..")
    public WebElement addToFavoritesButton;

    @FindBy(xpath = "//a[@class='button new']")
    public WebElement addIcon;

    public void clickOnAddFileOptions(String option){
        Driver.getDriver().findElement(By.xpath("//span[.='"+option+"']")).click();
    }

    @FindBy (xpath = "//div[@class='toastify on dialogs error toastify-right toastify-top']/span") public WebElement notEnoughSpaceBtn;

    @FindBy (xpath = "//div[@id='uploadprogressbar']") public WebElement uploadBar;

    @FindBy (xpath = "//input[@id='file_upload_start']")
    public WebElement uploadStart;

    @FindBy(xpath = "//a[contains(normalize-space(),'Comments')]")
    public WebElement comments;

    @FindBy(xpath = "//form[@class='newCommentForm']//div[@class='message']")
    public WebElement newCommentBox;

    @FindBy(xpath = "//input[@type='submit' and @class='submit icon-confirm has-tooltip']")
    public WebElement commentSubmitBtn;

    @FindBy(xpath = "//button[@class='settings-button']")
    public WebElement settingsButton;

    @FindBy(xpath = "//div[@id='app-settings-content']//label[contains(.,'Show')]")
            //(xpath = "//div[@id='app-settings-content']//input[@type='checkbox']")
    public List<WebElement> checkBoxes;


    public WebElement uploadedFile(String fileName){
        WebElement uploadedFile = Driver.getDriver().findElement(By.xpath("//span[.='" + fileName + "']"));
        return uploadedFile;
    }

    String systemPath = System.getProperty("user.dir");
    public static String fileName;
    public void uploadFile(){
        String filePath = systemPath + "/src/test/resources/files/What-is-Cloud-Storage.png";
                //"/Users/aykhanguluzade/Desktop/Map_ClassNotes.png";
        uploadStart.sendKeys(filePath);
        BrowserUtils_Gurhans.waitFor(5);
        fileName = filePath.substring(filePath.lastIndexOf("/")+1);
        // System.out.println("fileName = " + fileName);

        // Check if upload failed due to Not Enough Space and retry
        try{
            Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            Assert.assertTrue(notEnoughSpaceBtn.isDisplayed());
            notEnoughSpaceBtn.click();
            BrowserUtils_Gurhans.sleep(1);
            uploadStart.sendKeys(filePath);
            // TryCloudUtils.waitTillUploadBarDisappears();
            BrowserUtils_Gurhans.waitFor(3);
        } catch (Exception e){
            Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            // TryCloudUtils.waitTillUploadBarDisappears();
        }
    }

    @FindBy(xpath = "(//div[contains(@style,'filetypes/folder')])[1]")
    public WebElement firstFolder;

    @FindBy(xpath = "//li[@id='quota']")
            //(xpath = "//p[contains(text(),'used')]")
    public WebElement storageStatus;


    public void chooseAnOption(String button){
        Driver.getDriver().findElement(By.xpath("//span[.='"+button+"']/..")).click();
    }

    public static String nameOfRandomFile;

    public void chooseRandomFile(){
        //generate random number between 1 and the max number of the files to choose one file randomly
        int randomNumber = new Faker().number().numberBetween(1, allFiles.size());
        //store the name of the randomly chosen file in a string (we need this for later to verify if the file is added to favorites or not)
         nameOfRandomFile = Driver.getDriver().findElement(By.xpath("(//span[@class='innernametext'])[" + randomNumber + "]")).getText();

        // click on the action button of this randomly selected file
        Driver.getDriver().findElement(By.xpath("(//a[@class='action action-menu permanent'])[" + randomNumber + "]")).click();

    }


    @FindBy(xpath = "//input[@value='New folder']")
    public WebElement newFolderNameBox;

    @FindBy(xpath = "(//input[@type='submit'])[2]")
    public WebElement newFolderSubmitButton;



    public void chooseOption(String button, String fileName){
        //if first option is not our required option than click to that option in order to change it to the one we need
        if (button.contains("favorites") && !firstOption.getText().equals(button)){
            firstOption.click();
            BrowserUtils_Gurhans.waitFor(4);
            //then click on the actions button of the same file again, passing name of the file as argument to find the exact file
           clickOnSpecificActionsButton(fileName);
            //and click on the button we need
            Driver.getDriver().findElement(By.xpath("//span[.='"+button+"']/..")).click();
        }else {
            //if the first option is already what we need then click on it directly
            Driver.getDriver().findElement(By.xpath("//span[contains(.,'"+button+"')]/..")).click();
        }
    }

    public void goToSubModule(String subModule){
        Driver.getDriver().findElement(By.xpath("//a[.='"+subModule+"']")).click();
    }

    Actions actions = new Actions(Driver.getDriver());

    @FindBy (xpath = "//div[@class='fileActionsMenu popovermenu bubble open menu']//li[3]//span[2]//..")
    public WebElement firstOption;


    public void removeFavorites(){
        if (allFavorites.size()==0){
            return;
        }


        Iterator<WebElement> it = allFavorites.iterator();
        while (it.hasNext()){
            it.next();
            actionsButton.click();
            removeFromFavoritesButton.click();
            BrowserUtils_Gurhans.waitFor(2);
        }

//        int size = allFavorites.size();
//            for (int i = 0; i < size; i++) {
//
//                actionsButton.click();
//                removeFromFavoritesButton.click();
//                BrowserUtils_Gurhans.waitFor(2);
//
//
//            }
    }






}
