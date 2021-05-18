package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

import java.util.List;
import java.util.stream.Collectors;

public class Cart {

    public WebDriver driver;
    private By textCart = By.xpath("//div[contains(text(),'Your shopping bag is empty.')]");
    private By contShop = By.xpath("//a[@id='shopcartHomepage']");
    private By numofItem = By.xpath("//span[contains(text(),'(1 Item)')]");
    private By numofItemtwo = By.xpath("//span[contains(text(),'(2 Items)')]");
    private By remove = By.xpath("//a[@id='WC_OrderItemDetailsf_links_2_1']");
    private By price = By.xpath("//div[contains(text(),'$34.65')]");

    private By dropdown = By.xpath("//select[@id='qty_1']");;

    public Cart(WebDriver driver){
        this.driver = driver;
    }

    public String getText(){

        return driver.findElement(textCart).getText();
    }
    public String numofItems(){
        return driver.findElement(numofItem).getText();
    }

    public String numofItemstwo(){
        return driver.findElement(numofItemtwo).getText();
    }

    public Double amount(){
             String a =  driver.findElement(price).getText();
             return Double.parseDouble(a.replaceAll("[^\\d.]", ""))*2;
             //as with drop down I will double the quantity of item
    }

    public String price(){
        WebDriverWait wait = new WebDriverWait(driver, 2000);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(price)));
        return driver.findElement(price).getText();
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public void remove(){
        WebDriverWait wait = new WebDriverWait(driver, 1000);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(remove)));
        driver.findElement(remove).click();
    }
    public void clickGoShop(){
        WebDriverWait wait = new WebDriverWait(driver, 1000);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(contShop)));
        driver.findElement(contShop).click();
    }

    public void selectFromDropDown(int option){

        Select blah = new Select(driver.findElement(dropdown));
        blah.selectByIndex(option);
    }







}
